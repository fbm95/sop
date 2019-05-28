import { Routes, RouterModule } from '@angular/router';

import { RestaurantListComponent } from './restaurant-list';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
import {RestaurantComponent} from './restaurant/restaurant.component';
import {NgModule} from '@angular/core';
import {OrderHistoryComponent} from './order_history/order_history.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import { OrderFormComponent } from './order-form/order-form.component';
import {SearchResultsComponent} from './search_results/search_results.component';
import {OrderListComponent} from './order-list/order-list.component';

const appRoutes: Routes = [
    { path: '', component: RestaurantListComponent }, // , canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'restaurants/:id', component: RestaurantComponent },

    // otherwise redirect to restaurant-list
    { path: 'order_history', component: OrderHistoryComponent},
    { path: 'shopping-cart', component: ShoppingCartComponent },
    { path: 'order-form', component: OrderFormComponent },
    { path: 'search-results', component: SearchResultsComponent },
    { path: 'order-list', component: OrderListComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
  providers: []
})
export class RoutingModule {
}
