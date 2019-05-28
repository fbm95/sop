import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import {User} from '../_models';
import {AuthenticationService, UserService} from '../_services';
import {Router} from '@angular/router';
import {Restaurant} from '../_models/restaurant';
import {RestaurantService} from '../_services/restaurant.service';
import {RestaurantComponent} from '../restaurant/restaurant.component';


@Component({
  selector: 'app-restaurant-list',
  templateUrl: 'restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit, OnDestroy {
    currentUser: User;
    currentUserSubscription: Subscription;
    users: User[] = [];
    restaurants: Restaurant[];

    constructor(
        private authenticationService: AuthenticationService,
        private userService: UserService,
        private router: Router,
        private restaurantService: RestaurantService
    ) {
        this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
            this.currentUser = user;
        });
    }

    ngOnInit() {
        // this.loadAllUsers();
      this.getAllRestaurants();
    }

  private getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe(response => {
      this.restaurants = response;
    });
  }

    ngOnDestroy() {
        // unsubscribe to ensure no memory leaks
        this.currentUserSubscription.unsubscribe();
    }

    btnClick = function(restaurantId: number) {
      this.router.navigateByUrl('/restaurants/' + restaurantId);
    };




  // deleteUser(id: number) {
  //     this.userService.delete(id).pipe(first()).subscribe(() => {
  //         this.loadAllUsers();
  //     });
  // }
  //
  // private loadAllUsers() {
  //     this.userService.getAll().pipe(first()).subscribe(users => {
  //         this.users = users;
  //     });
  // }
}
