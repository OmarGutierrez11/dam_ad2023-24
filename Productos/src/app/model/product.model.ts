export class ProductModel {
  static numProducts:number=0;
  idProduct:number;

  constructor(
    public sku:string,
    public name:string,
    public imageUrl:string,
    public department:string[],
    public price:number
  ){
    ProductModel.numProducts++;
    this.idProduct=ProductModel.numProducts;
  }
}
