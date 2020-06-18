import { Component, OnInit, ViewChild } from '@angular/core';
import { IProducto } from 'src/app/shared/model/producto.model';
import { NgbTypeahead } from '@ng-bootstrap/ng-bootstrap';
import { Subject, Observable, merge, of } from 'rxjs';
import {
  debounceTime,
  distinctUntilChanged,
  filter,
  map,
  tap,
  switchMap,
  catchError,
} from 'rxjs/operators';
import { ProductoService } from '../productos/producto.service';
import { Validators, FormBuilder } from '@angular/forms';
import { ClienteService } from '../clientes/cliente.service';
import { ICliente, Cliente } from 'src/app/shared/model/cliente.model';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Factura } from 'src/app/shared/model/factura.model';
import { FacturaDetalle } from 'src/app/shared/model/facturaDetalle.model';
import { FacturaService } from '../factura.service';

@Component({
  selector: 'app-caja',
  templateUrl: './caja.component.html',
  styleUrls: ['./caja.component.css'],
})
export class CajaComponent implements OnInit {
  editForm = this.fb.group({
    id: [],
    nombres: [null, [Validators.required]],
    identificacion: [null, [Validators.required]],
    telefono: [],
    email: [],
    direccion: [],
    apellidos: [],
  });

  @ViewChild('instance', { static: true }) instance: NgbTypeahead;
  focus$ = new Subject<string>();
  click$ = new Subject<string>();
  productos?: IProducto[];
  productoVenta?: IProducto[] = [];
  existeCliente = true;
  model: IProducto;
  searching = false;
  searchFailed = false;
  totalEfectivo: number = 0;
  fechaActual: Date = new Date();
  idCliente: number;
  clienteVenta: ICliente = new Cliente();
  mostrarMsgInventario = false;
  mensajeInventario = '';
  faTrash = faTrash;
  nombreCliente: string = `N/A`;
  totalVenta: number = 0;
  facturaDetalleList: FacturaDetalle[];
  constructor(
    private productoService: ProductoService,
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private facturaService: FacturaService
  ) {}

  ngOnInit(): void {
    this.loadProductos();
    this.enableDisableForm(false);
  }

  loadProductos() {
    this.productoService.getAll().subscribe((res) => {
      this.productos = res;
    });
  }

  formatter = (productoSearch: IProducto) => productoSearch.nombre;

  search = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      filter((term) => term.length >= 1),
      map((term) =>
        this.productos
          .filter((filter) => new RegExp(term, 'mi').test(filter.nombre))
          .slice(0, 10)
      )
    );

  somethingChanged(newObj: IProducto) {
    if (newObj.idproducto) {
      let cantidad: number =
        this.productoVenta.filter(
          (producto) => producto.idproducto === newObj.idproducto
        ).length + 1;
      if (newObj.stock >= cantidad) {
        newObj.idVenta = this.getRandomId();
        this.productoVenta.push(newObj);
        this.model = null;
      } else {
        this.mensajeInventario = `El producto ${newObj.nombre} no cuenta con inventario disponible.`;
        this.mostrarMsgInventario = true;
      }
    }
  }

  calcularTotal() {
    let total: number = 0;
    this.productoVenta.forEach((producto) => {
      total += producto.valorunidad;
    });
    this.totalVenta = total;
    return total;
  }

  calcularCambio() {
    return this.totalEfectivo - this.calcularTotal();
  }

  activarBoton() {
    return this.calcularCambio() < 0;
  }

  save() {
    this.clienteService.create(this.createFromForm()).subscribe(
      (data) => {
        this.enableDisableForm(false);
        this.existeCliente = true;
        this.nombreCliente = `${data.nombres} ${data.apellidos}`;
      },
      (err) => {
        console.error(err);
      }
    );
  }

  buscarCliente() {
    this.clienteService
      .findByIdentificacion(this.idCliente)
      .subscribe((data) => {
        if (data !== null) {
          this.clienteVenta = data;
          this.updateForm(this.clienteVenta);
          this.enableDisableForm(false);
          this.existeCliente = true;
        } else {
          this.enableDisableForm(true);
          this.editForm.reset();
          this.existeCliente = false;

          this.editForm.controls['identificacion'].setValue(this.idCliente);
          this.editForm.controls['identificacion'].disable();
        }
      });
  }

  updateForm(cliente: ICliente): void {
    if (cliente.idcliente) {
      this.nombreCliente = `${cliente.nombres} ${cliente.apellidos}`;
    } else {
      this.nombreCliente = 'N/A';
    }
    this.editForm.patchValue({
      id: cliente.idcliente,
      nombre: cliente.nombres,
      identificacion: cliente.identifiacion,
      celular: cliente.telefono,
      email: cliente.email,
      apelidos: cliente.apellidos,
      direccion: cliente.direccion,
    });
  }

  enableDisableForm(state: boolean) {
    if (!state) {
      this.editForm.controls['nombres'].disable();
      this.editForm.controls['apellidos'].disable();
      this.editForm.controls['identificacion'].disable();
      this.editForm.controls['telefono'].disable();
      this.editForm.controls['email'].disable();
      this.editForm.controls['direccion'].disable();
    } else {
      this.editForm.controls['nombres'].enable();
      this.editForm.controls['apellidos'].enable();
      this.editForm.controls['identificacion'].enable();
      this.editForm.controls['telefono'].enable();
      this.editForm.controls['email'].enable();
      this.editForm.controls['direccion'].enable();
    }
  }

  private createFromForm(): ICliente {
    return {
      ...new Cliente(),
      idcliente: this.editForm.get(['id'])!.value,
      nombres: this.editForm.get(['nombres'])!.value,
      identifiacion: this.editForm.get(['identificacion'])!.value,
      telefono: this.editForm.get(['telefono'])!.value,
      email: this.editForm.get(['email'])!.value,
      apellidos: this.editForm.get(['apellidos'])!.value,
      direccion: this.editForm.get(['direccion'])!.value,
    };
  }

  getRandomId() {
    return Math.floor(Math.random() * 100);
  }

  eliminarProducto(productoBorrar: IProducto) {
    const index: number = this.productoVenta.indexOf(productoBorrar);
    if (index !== -1) {
      this.productoVenta.splice(index, 1);
    }
  }

  cerrarVenta() {
    this.idCliente = null;
    this.totalEfectivo = 0;
    this.facturaDetalleList = [];
    this.productoVenta.forEach((producto) => {
      let facturaDetalle = new FacturaDetalle(
        undefined,
        producto.stock,
        this.totalVenta,
        producto.valorunidad,
        undefined,
        producto.idproducto,
        undefined,
        producto
      );
      this.facturaDetalleList.push(facturaDetalle);
    });

    let facturaVenta = new Factura(
      undefined,
      this.fechaActual,
      this.totalVenta,
      this.clienteVenta.idcliente,
      this.clienteVenta,
      this.facturaDetalleList
    );

    this.facturaService.create(facturaVenta).subscribe((data) => {
      this.limpiarCampos();
    });
  }

  limpiarCampos() {
    this.idCliente = null;
    this.nombreCliente = 'N/A';
    this.fechaActual = new Date();
    this.productoVenta = [];
    this.editForm.reset();
    this.clienteVenta = new Cliente();
    this.totalEfectivo = null;
    this.calcularCambio();
  }
}
