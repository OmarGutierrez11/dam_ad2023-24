import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


// componentes
import { HomeComponent } from './home/home.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { DetailProductComponent } from './products/detail-product/detail-product.component';
import { ProductsComponent } from './products/products/products.component';
import { ContactComponent } from './contact/contact.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'products/add-product', component: AddProductComponent },
  { path: 'products/product/:id', component: DetailProductComponent },
  { path: 'contact', component: ContactComponent },
  { path: '**', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
