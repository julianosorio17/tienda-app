import { Factura } from './factura.model';

export interface ICliente {
  idcliente?: number;
  identifiacion?: number;
  nombres?: string;
  apellidos?: string;
  direccion?: string;
  telefono?: string;
  email?: string;
  testFacturasByIdcliente?: Factura[];
}

export class Cliente implements ICliente {
  constructor(
    public idcliente?: number,
    public identifiacion?: number,
    public nombres?: string,
    public apellidos?: string,
    public direccion?: string,
    public telefono?: string,
    public email?: string,
    public testFacturasByIdcliente?: Factura[]
  ) {}
}
