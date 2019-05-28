import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-order',
  templateUrl: './order_history.component.html',
  styleUrls: ['./order_history.component.css']
})
export class OrderHistoryComponent implements OnInit {
  orderHistoryObject = [
    {id: 'id1', orderDate: 'Name2', address: 'description 2', foodName: '2.00', restaurantName: 'mada', price: '25', quantity: '2'},
    {id: 'id2', orderDate: 'Name2', address: 'description 2', foodName: '2.00', restaurantName: 'mada', price: '25', quantity: '2'},
    {id: 'id3', orderDate: 'Name3', address: 'description 3', foodName: '3.00', restaurantName : 'mada', price: '25', quantity: '2'},
    {id: 'id4', orderDate: 'Name4', address: 'description 4', foodName: '4.00', restaurantName : 'mada', price: '25', quantity: '2'},
    {id: 'id5', orderDate: 'Name5', address: 'description 5', foodName: '5.00', restaurantName : 'mada', price: '25', quantity: '2'},
    {id: 'id6', orderDate: 'Name6', address: 'description 6', foodName: '6.00', restaurantName : 'mada', price: '25', quantity: '2'}];

  constructor() { }

  ngOnInit() {
  }
  buy(id: string) {

  }
  seeDetails(id: string) {


  }

}

