import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ProductService} from '../_services/product.service';
import {AppComponent} from '../app.component';
import {ShoppingCartService} from '../_services/shopping-cart.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products = [];
  totalPrice = 0;
  key = 'cart';
  emptyCart = false;

  constructor(private router: Router,
              public appComponent: AppComponent,
              private productService: ProductService,
              private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
    this.update();
  }

  update() {
    this.products = [];
    this.totalPrice = 0;
    const storedProducts = JSON.parse(localStorage.getItem(this.key));
    // for each id in storedProduct get info from backend about product and display
    if(storedProducts) {
      for (const product of storedProducts) {
        this.productService.getProductById(product.id).subscribe(response => {
          response['count'] = product.count;
          this.totalPrice += response.price * product.count;

          this.products.push(response);
        });
      }
    }

    if (localStorage.getItem('noProducts') === '0') {
      this.emptyCart = true;
    }
  }

  remove(id: string) {
    const storedProducts = JSON.parse(localStorage.getItem(this.key));
    const index = storedProducts.indexOf(storedProducts.find(x => x.id === id));

    if (storedProducts[index].count >= 1) {
      storedProducts[index].count--;
    }

    if (storedProducts[index].count === 0){
      storedProducts.splice(index, 1);
    }

    localStorage.setItem(this.key, JSON.stringify(storedProducts));
    const flag = localStorage.getItem('noProducts');


    this.update();
    this.appComponent.updateShoppingCartNumber(1);

    if (localStorage.getItem('noProducts') === '0') {
      this.emptyCart = true;
    }
  }

  onClick = function(path: string) {
    this.router.navigateByUrl('/' + path);
  };

  placeOrder() {
    if (localStorage.getItem('Authorization') == null) {
      localStorage.setItem('CameFrom', this.router.url);
      this.router.navigate(['/login']);
      return;
    }
    const storedProducts = JSON.parse(localStorage.getItem(this.key));

    this.shoppingCartService.postOrder(storedProducts);
    this.router.navigate(['/order-form']);
  }


}
