import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from './ui/header/header.component';
import { NavbarComponent } from './ui/navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ItemProductComponent } from './products/item-product/item-product.component';
import { ProductsComponent } from './products/products/products.component';
import { NavbarProductsComponent } from './products/ui/navbar-products/navbar-products.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { DetailProductComponent } from './products/detail-product/detail-product.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    HomeComponent,
    ItemProductComponent,
    ProductsComponent,
    NavbarProductsComponent,
    AddProductComponent,
    DetailProductComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
