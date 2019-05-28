import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import { AuthenticationService } from './_services';
import { User } from './_models';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material';
import {RestaurantComponent} from './restaurant/restaurant.component';

@Component({ selector: 'my-app', templateUrl: 'app.component.html' })
export class AppComponent {
    currentUser: User;
    storedTotalProd = 0;
    public totalProducts;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        public snackBar: MatSnackBar
    ) {
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
         if (JSON.parse(localStorage.getItem('noProducts')) > 0) {
          this.totalProducts = JSON.parse(localStorage.getItem('noProducts'));
      } else{
           this.totalProducts = 0;
         }
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }

  getUrl() {
    return 'url("https://cdn-images-1.medium.com/max/1200/1*fCWCAdS1TbDy6wuG_uWvww.jpeg")';
  }

  updateShoppingCartNumber(value: number) {
    switch (value) {
      case 0 :
        this.totalProducts++; break;
      case 1 :
        this.totalProducts--; break;
    }
    localStorage.setItem('noProducts', JSON.stringify(this.totalProducts));
  }

  openSnackBar(message: string) {
      const prop =  new MatSnackBarConfig();
      prop.duration = 2000;
      this.snackBar.open(message, 'X', prop);
  }
}
