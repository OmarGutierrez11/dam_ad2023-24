import { Component, OnInit } from '@angular/core';
import { ProductModel } from '../../model/product.model';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  productos!: ProductModel[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    // obtengo los productos del servicio
    this.productos = this.productService.getProducts();

  }

}
