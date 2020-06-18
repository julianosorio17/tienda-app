import { FacturaDetalle } from './facturaDetalle.model';

export interface IProducto {
  idproducto?: number;
  codigo?: string;
  nombre?: string;
  stock?: number;
  valorunidad?: number;
  testFacturaDetallesByIdproducto?: FacturaDetalle[];
  idVenta?: number;
}

export class Producto implements IProducto {
  constructor(
    public idproducto?: number,
    public codigo?: string,
    public nombre?: string,
    public stock?: number,
    public valorunidad?: number,
    public testFacturaDetallesByIdproducto?: FacturaDetalle[],
    public idVenta?: number,
  ) {}
}
