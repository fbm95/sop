import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AppComponent} from '../app.component';
import {HeaderComponent} from '../header/header.component';
import {ProductService} from '../_services/product.service';

import {Product} from '../_models/product';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  private key = 'cart';
  private restaurantId: number;
  private products: Product[];

  constructor(private route: ActivatedRoute,
              private productService: ProductService, public appComponent: AppComponent) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.restaurantId = params.id;
      this.getAllProductsForRestaurant();
    });
  }

  private getAllProductsForRestaurant() {
    this.productService.getAllProductsForRestaurant(this.restaurantId).subscribe(response => {
      this.products = response;
    });
  }

  buy(prodId: string) {
    let storedProducts = [];

    const storedJson = localStorage.getItem(this.key);
    if (storedJson == null || JSON.parse(storedJson).length === 0) {
      const prodArray = [{id : prodId, rid: this.restaurantId, count: 1}];
      localStorage.setItem(this.key, JSON.stringify(prodArray));
      this.appComponent.openSnackBar('Added item to cart');
      this.appComponent.updateShoppingCartNumber(0);
    } else {
      storedProducts = JSON.parse(localStorage.getItem(this.key));
      const checkRestaurant = storedProducts.find(x => x.rid === this.restaurantId);
      if (checkRestaurant) {
        const obj = storedProducts.find(x => x.id === prodId);

        if (obj) {
          let index = storedProducts.indexOf(obj);
          const newCount = obj.count + 1;
          storedProducts.fill(obj.count = newCount, index, index++);
        } else {
          storedProducts[storedProducts.length] = {id: prodId, rid: this.restaurantId, count: 1};
        }
      } else {
        this.appComponent.openSnackBar('Cant add products from multiple restaurant');
        return;
      }
      localStorage.setItem(this.key, JSON.stringify(storedProducts));
      this.appComponent.openSnackBar('Added item to cart');
      this.appComponent.updateShoppingCartNumber(0);
    }
  }

}
