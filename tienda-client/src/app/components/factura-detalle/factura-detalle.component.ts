import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/shared/model/factura.model';
import { Router, ActivatedRoute } from '@angular/router';
import { FacturaService } from '../factura.service';
import {
  faEye,
  faPencilAlt,
  faTrash,
  faPlus,
  faUndo,
} from '@fortawesome/free-solid-svg-icons';
import { ICliente } from 'src/app/shared/model/cliente.model';
import { Observable } from 'rxjs';
import {
  FacturaDetalle,
  IFacturaDetalle,
} from 'src/app/shared/model/facturaDetalle.model';

@Component({
  selector: 'app-factura-detalle',
  templateUrl: './factura-detalle.component.html',
  styleUrls: ['./factura-detalle.component.css'],
})
export class FacturaDetalleComponent implements OnInit {
  facturas?: Factura[];
  isUpdate: boolean;
  producto: any;

  constructor(
    public router: Router,
    public facturaService: FacturaService,
    protected activatedRoute: ActivatedRoute
  ) {}
  faUndo = faUndo;
  faPencilAlt = faPencilAlt;
  faTrash = faTrash;
  faPlus = faPlus;
  closeResult: string;
  state$: Observable<object>;
  idFactura: number = 0;
  detalle: IFacturaDetalle[];

  ngOnInit(): void {
    this.detalle = [];
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.idFactura = params.id;
        this.facturaService.findDetalleFactura(params.id).subscribe((res) => {
          this.detalle = res;
          // this.producto = res;
        });
      }
    });

    this.loadAll();
  }
  updateForm(producto: any) {
    throw new Error('Method not implemented.');
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

  regresar() {
    window.history.back();
  }
}
