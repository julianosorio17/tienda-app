import { Producto } from './producto.model';
import { Factura } from './factura.model';

export interface IFacturaDetalle {
  idfacturadetalle?: number;
  cantidad?: number;
  valortotal?: number;
  valorunidad?: number;
  idfactura?: number;
  idproducto?: number;
  testFacturaByIdfactura?: Factura;
  testProductoByIdproducto?: Producto;
}

export class FacturaDetalle implements IFacturaDetalle {
  constructor(
    public idfacturadetalle?: number,
    public cantidad?: number,
    public valortotal?: number,
    public valorunidad?: number,
    public idfactura?: number,
    public idproducto?: number,
    public testFacturaByIdfactura?: Factura,
    public testProductoByIdproducto?: Producto
  ) {}
}
