import { Cliente } from './cliente.model';
import { FacturaDetalle } from './facturaDetalle.model';

export interface IFactura {
  idfactura?: number;
  fechaventa?: Date;
  valortotal?: number;
  idcliente?: number;
  testClienteByIdcliente?: Cliente;
  testFacturaDetallesByIdfactura?: FacturaDetalle[];
  
}

export class Factura implements IFactura {
  constructor(
    public idfactura?: number,
    public fechaventa?: Date,
    public valortotal?: number,
    public idcliente?: number,
    public testClienteByIdcliente?: Cliente,
    public testFacturaDetallesByIdfactura?: FacturaDetalle[]
  ) {}
}
