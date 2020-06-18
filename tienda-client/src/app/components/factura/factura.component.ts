import { Component, OnInit } from '@angular/core';
import { ICliente } from 'src/app/shared/model/cliente.model';
import { Router } from '@angular/router';
import { ClienteService } from '../clientes/cliente.service';
import {
  faEye,
  faPencilAlt,
  faTrash,
  faPlus,
} from '@fortawesome/free-solid-svg-icons';
import { FacturaService } from '../factura.service';
import { IFactura, Factura } from 'src/app/shared/model/factura.model';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css'],
})
export class FacturaComponent implements OnInit {
  facturas?: Factura[];

  constructor(public router: Router, public facturaService: FacturaService) {}
  faEye = faEye;
  faPencilAlt = faPencilAlt;
  faTrash = faTrash;
  faPlus = faPlus;
  closeResult: string;

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.facturaService.getAll().subscribe(
      (res) => {
        this.facturas = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  page = 1;
  pageSize = 4;

  eliminar(cliente: ICliente) {
    if (
      confirm('¿Esta seguro de eliminar el cliente ' + cliente.nombres + ' ?')
    ) {
      this.facturaService.delete(cliente.idcliente).subscribe(
        () => {
          this.loadAll();
        },
        (err) => {
          console.error(err);
        }
      );
    }
  }

  verDetalle(factura: IFactura) {
    this.router.navigateByUrl(`/facturaDetalle/${factura.idfactura}`, {
      state: { factura: factura },
    });
  }
}
