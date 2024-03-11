import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductModel } from 'src/app/model/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {
  idProductoElegido!: number;
  productoElegido!: ProductModel;

  constructor(private _activatedRoute: ActivatedRoute,
              private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    // recojo el id que llega en la url a este componente al navegar hacia él
    let idRecogidoDeLaUrl = this._activatedRoute.snapshot.paramMap.get('id');
    // compruebo que no sea nulo
    if (idRecogidoDeLaUrl !== null) {
      this.idProductoElegido = +idRecogidoDeLaUrl;
      this.productoElegido = this._productService.getProduct(this.idProductoElegido);
    }
  }

  /** Método que borra el producto del array de productos
   *
   */
  deleteProduct(id: number): void {
    this._productService.deleteProduct(id);
    this._router.navigateByUrl('products');
  }
}
