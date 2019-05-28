import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../_models/order';
import {Product} from '../_models/product';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: localStorage.getItem('Authorization'),
      observe: 'response'
    })
  };

  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<Order[]> {
    const url = '/api/orders';
    return this.http.get<Order[]>(url, {observe: 'body'});
  }

  takeOrder(id: number): Observable<any> {
    const url = '/api/orders/' + id;
    return this.http.put(url, null, this.httpOptions);
  }
}
