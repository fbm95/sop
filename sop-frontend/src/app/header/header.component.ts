import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserInfoService } from '../_services/user-info.service';
import { User } from '../_models';
import {AppComponent} from '../app.component';
import {RestaurantComponent} from '../restaurant/restaurant.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;
  user: User;

  constructor(private router: Router, public appComponent: AppComponent, private userInfoService: UserInfoService) { }

  ngOnInit() {
    if (localStorage.getItem('Authorization')) {
      this.isLoggedIn = true;
    }

    if (localStorage.getItem('Authorization') != null) {
      this.userInfoService.getLoggedInUserInfo().subscribe(response => {
        this.user = response;
      },
      error => {
        if (error.indexOf(401) > -1) {
          localStorage.removeItem('Authorization');
        }
      });
    }
  }

  /*get TotalProducts() {
    return this.totalProducts;
  }*/

  btnClick = function(path: string) {
    this.router.navigateByUrl('/' + path);
  };

  logout = () => {
    localStorage.removeItem('Authorization');
    window.location.replace('/');
  }
}

