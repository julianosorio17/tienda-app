import { Component, OnInit } from '@angular/core';
import { IProducto } from 'src/app/shared/model/producto.model';
import { Router } from '@angular/router';
import { ProductoService } from '../productos/producto.service';
import {
  faEye,
  faPencilAlt,
  faTrash,
  faPlus,
} from '@fortawesome/free-solid-svg-icons';
import { ICliente } from 'src/app/shared/model/cliente.model';
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
})
export class ClientesComponent implements OnInit {
  clientes?: ICliente[];

  constructor(public router: Router, public clienteService: ClienteService) {}
  faEye = faEye;
  faPencilAlt = faPencilAlt;
  faTrash = faTrash;
  faPlus = faPlus;
  closeResult: string;

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.clienteService.getAll().subscribe((res) => {
      this.clientes = res;
    });
  }

  page = 1;
  pageSize = 4;

  modificar(cliente: ICliente) {
    this.router.navigateByUrl(`/modificarCliente/${cliente.idcliente}`, {
      state: { cliente: cliente },
    });
  }

  eliminar(cliente: ICliente) {
    if (
      confirm('¿Esta seguro de eliminar el cliente ' + cliente.nombres + ' ?')
    ) {
      this.clienteService.delete(cliente.idcliente).subscribe(
        () => {
          this.loadAll();
        },
        (err) => {
          console.error(err);
        }
      );
    }
  }
}
