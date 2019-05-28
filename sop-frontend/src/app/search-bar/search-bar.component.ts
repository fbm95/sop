import {Component, NgModule, OnInit} from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})

export class SearchBarComponent implements OnInit {

  searchText;

  constructor() { }

  ngOnInit() {
  }

  searchFood(str: string) {
    this.searchText = str;
    console.log(str);

  }
}
