import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../_models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAllProductsForRestaurant(restaurantId: number): Observable<Product[]> {
    const url = '/api/products?restaurant_id=' + restaurantId;
    return this.http.get<Product[]>(url, {observe: 'body'});
  }

  getProductById(prodId: number): Observable<Product> {
    const url = '/api/products/' + prodId;
    return this.http.get<Product>(url, {observe: 'body'});
  }
}
