import { Component, OnInit } from '@angular/core';
import { faUndo } from '@fortawesome/free-solid-svg-icons';
import { Validators, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { IProducto, Producto } from 'src/app/shared/model/producto.model';
import { Observable } from 'rxjs';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-create-update',
  templateUrl: './producto-create-update.component.html',
  styleUrls: ['./producto-create-update.component.css'],
})
export class ProductoCreateUpdateComponent implements OnInit {
  title: string = 'Crear o editar productos';
  faUndo = faUndo;
  isUpdate = false;
  editForm = this.fb.group({
    id: [],
    codigo: [null, [Validators.required]],
    nombre: [null, [Validators.required]],
    cantidad: [null, [Validators.required]],
    valorUnitario: [null, [Validators.required]],
  });
  state$: Observable<object>;
  producto?: IProducto;
  constructor(
    private productoService: ProductoService,
    public router: Router,
    private fb: FormBuilder,
    protected activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.isUpdate = true;
        this.productoService.find(params.id).subscribe((res) => {
          this.producto = res;
          this.updateForm(this.producto);
        });
      }
    });
  }

  updateForm(producto: IProducto): void {
    this.editForm.patchValue({
      id: producto.idproducto,
      codigo: producto.codigo,
      nombre: producto.nombre,
      cantidad: producto.stock,
      valorUnitario: producto.valorunidad,
    });
  }

  regresar(): void {
    window.history.back();
  }

  save(): void {
    this.isUpdate = false;
    const producto = this.createFromForm();

    if (producto.idproducto !== null) {
      this.productoService.update(producto).subscribe(
        (data) => {
          this.regresar();
        },
        (err) => {
          console.error(err);
        }
      );
    } else {
      this.productoService.create(producto).subscribe(
        (data) => {
          this.regresar();
        },
        (err) => {
          console.error(err);
        }
      );
    }
  }

  private createFromForm(): IProducto {
    return {
      ...new Producto(),
      idproducto: this.editForm.get(['id'])!.value,
      codigo: this.editForm.get(['codigo'])!.value,
      nombre: this.editForm.get(['nombre'])!.value,
      stock: this.editForm.get(['cantidad'])!.value,
      valorunidad: this.editForm.get(['valorUnitario'])!.value,
    };
  }
}
