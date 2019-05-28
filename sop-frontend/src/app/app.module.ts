import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';

import {AlertComponent} from './_components';
import {RestaurantListComponent} from './restaurant-list';
import {LoginComponent} from './login';
import {RestaurantComponent} from './restaurant/restaurant.component';
import {HeaderComponent} from './header/header.component';
import { OrderHistoryComponent } from './order_history/order_history.component';

import { RegisterComponent } from './register';
import { NgMatSearchBarModule } from 'ng-mat-search-bar';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';
import { RoutingModule } from './routing.module';
import { MaterialModule } from './material.module';
import {SearchBarComponent} from './search-bar/search-bar.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { OrderListComponent } from './order-list/order-list.component';
import { SearchResultsComponent } from './search_results/search_results.component';

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        ReactiveFormsModule,
        HttpClientModule,
        NgMatSearchBarModule,
        Ng2SearchPipeModule,
        FormsModule,
        RoutingModule,
        MaterialModule
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        RestaurantListComponent,
        LoginComponent,
        RegisterComponent,
        RestaurantComponent,
        HeaderComponent,
        SearchBarComponent,
        OrderHistoryComponent,
        ShoppingCartComponent ,
        OrderFormComponent,
        OrderListComponent,
        SearchResultsComponent
    ],
    providers: [
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }
