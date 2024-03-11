import { Injectable } from '@angular/core';
import { ProductModel } from '../model/product.model';

// Array de productos
const PRODUCTOS: ProductModel[] = [
  new ProductModel('NICEHAT',
    'Un bonito sombrero negro',
    '../../assets/images/gorra-negra.jpg',
    ['Hombre', 'Accesorios', 'Gorras'],
    29.99),
  new ProductModel('MYSHOES',
    'Playeros negros de correr',
    '../../assets/images/myshoes.jpg',
    ['Hombre', 'Playeros', 'Calzado Running'],
    109.99),
  new ProductModel('NEATOJACKET',
    'Chaqueta azul',
    '../../assets/images/chaqueta-azul.jpg',
    ['Mujer', 'Prendas Vestir', 'Chaquetas deportivas'],
    238.99)

]


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  /** Método que devuelve un array con los productos */
  getProducts(): ProductModel[] {
    return PRODUCTOS;
  }

  /** Método que añade un producto que se le pasa */
  addProduct(producto: ProductModel): void {
    PRODUCTOS.push(producto);
  }

  /** Método que obtiene un producto cuyo id se le pasa */
  getProduct(id: number): ProductModel {
    return PRODUCTOS.find(producto => producto.idProduct === id) as ProductModel;

  }

  /** Método que borra un producto cuyo id se le pasa */
  deleteProduct(id: number): void {
    let indiceProducto = PRODUCTOS.findIndex(producto => producto.idProduct === id);
    PRODUCTOS.splice(indiceProducto, 1);
  }

  /** Método que crea un producto vacío */
  createEmptyProduct(): ProductModel {
    return new ProductModel('SKU#', '', '', [''], -1);

  }








}
