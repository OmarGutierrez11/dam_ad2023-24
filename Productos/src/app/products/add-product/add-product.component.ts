import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductModel } from 'src/app/model/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  producto!: ProductModel;

  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    this.producto = this._productService.createEmptyProduct();
  }

  /** Método que se llama desde la plantilla html al pulsar el botón añadir */
  addProduct(): void {
    // antes de añadir el producto, se debe manipular el departamento, pues se ha
    // recogido como un array con un solo string separado por comas y en el modelo debe ser un
    // array de strings. Para convertilo hacemos:
    let dpto: string = this.producto.department.toString();
    this.producto.department = dpto.split(',');
    // ahora ya puedo añadir el producto llamando al método addProduct del servicio
    this._productService.addProduct(this.producto);
    // y navego al listado de productos
    this._router.navigateByUrl('products');
  }
}
