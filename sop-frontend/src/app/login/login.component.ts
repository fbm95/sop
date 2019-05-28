import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import {AlertService, AuthenticationService} from '../_services';


@Component({templateUrl: 'login.component.html'})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error: string;
    isLoggedIn = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService
    ) {
        // redirect to restaurant-list if already logged in
        if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';

        if (localStorage.getItem('Authorization')) {
            this.isLoggedIn = true;
        }
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    if (data != null) {
                        localStorage.setItem('Authorization', 'Bearer ' + data.access_token);
                        if (localStorage.getItem('CameFrom') != null) {
                            this.router.navigate([localStorage.getItem('CameFrom')]);
                            window.location.replace(localStorage.getItem('CameFrom'));
                            localStorage.removeItem('CameFrom');
                        } else {
                            this.router.navigate([this.returnUrl]);
                            window.location.replace(this.returnUrl);
                        }
                    } else {
                        this.error = 'Bad credentials!';
                        this.loading = false;
                    }
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }

    logout() {
        localStorage.removeItem('Authorization');
        this.router.navigate([this.returnUrl]);
        window.location.replace(this.returnUrl);
    }
}
