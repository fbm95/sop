import { Component, OnInit } from '@angular/core';
import {OrderService} from '../_services/order.service';
import {Order} from '../_models/order';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  private orders: Order[];

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getAllOrders();
  }

  takeOrder(id: number) {
    this.orderService.takeOrder(id).subscribe(response => {
      this.getAllOrders();
    });
  }

  getAllOrders() {
    this.orderService.getAllOrders().subscribe(response => {
      this.orders = response;
    });
  }

}
