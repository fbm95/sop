import { Component, OnInit } from '@angular/core';
import { UserInfoService } from '../_services/user-info.service';
import { Order } from '../_models/order';
import { Product } from '../_models/product';
import { User } from '../_models';
import { HttpClient } from 'selenium-webdriver/http';
import { ShoppingCartService } from '../_services/shopping-cart.service';
import { AppComponent } from '../app.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  name: string;
  address: string;
  detail: string;

  constructor(private userInfoService: UserInfoService, private shopingCartService: ShoppingCartService,
              private appComponent: AppComponent, private router: Router) { }

  ngOnInit() {
  }

  onSubmit = () => {
    const cart = JSON.parse(localStorage.getItem('cart'));
    this.userInfoService.getLoggedInUserInfo().subscribe(response => {
      let order = new Order();
      order.address = this.address;
      order.name = this.name;
      order.customerId = response.id;
      if (cart != null){
        order.products = [];
        for (let product of cart) {
          let p = new Product();
          p.id = product.id;
          order.products.push(p);
        }
      }
      this.shopingCartService.postOrder(JSON.stringify(order)).subscribe(response => {
        this.router.navigate(['/']);
        this.appComponent.openSnackBar('Confirmed');
      }, error => {
        this.appComponent.openSnackBar('Something went wrong!');
      });
      localStorage.removeItem('cart');
      localStorage.removeItem('noProducts');
      this.appComponent.totalProducts = 0;
    });


  }

}
