import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Restaurant} from '../_models/restaurant';

@Injectable({
  providedIn: 'root'
})

export class RestaurantService {

  constructor(private http: HttpClient) { }

  getAllRestaurants(): Observable<Restaurant[]> {
    const url = '/api/restaurants';
    return this.http.get<Restaurant[]>(url, {observe: 'body'});
  }
}
