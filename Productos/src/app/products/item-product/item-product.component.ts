import { Component, Input } from '@angular/core';
import { ProductModel } from '../../model/product.model'
@Component({
  selector: 'app-item-product',
  templateUrl: './item-product.component.html',
  styleUrls: ['./item-product.component.css']
})
export class ItemProductComponent {
  @Input() product!:ProductModel;

}
