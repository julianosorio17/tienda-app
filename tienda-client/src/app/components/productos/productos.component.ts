import { Component, OnInit } from '@angular/core';
import {
  faEye,
  faPencilAlt,
  faTrash,
  faPlus,
} from '@fortawesome/free-solid-svg-icons';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { ProductoService } from './producto.service';
import { IProducto } from 'src/app/shared/model/producto.model';
import { HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css'],
})
export class ProductosComponent implements OnInit {
  productos?: IProducto[];

  constructor(public router: Router, public productoService: ProductoService) {}
  faEye = faEye;
  faPencilAlt = faPencilAlt;
  faTrash = faTrash;
  faPlus = faPlus;
  closeResult: string;

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.productoService.getAll().subscribe((res) => {
      this.productos = res;
    });
  }

  page = 1;
  pageSize = 4;

  modificar(producto: IProducto) {
    this.router.navigateByUrl(`/modificarProducto/${producto.idproducto}`, {
      state: { producto: producto },
    });
  }

  eliminar(producto: IProducto) {
    if (
      confirm('¿Esta seguro de eliminar el producto ' + producto.nombre + ' ?')
    ) {
      this.productoService.delete(producto.idproducto).subscribe(
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
