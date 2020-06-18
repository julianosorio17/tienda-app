import { Component, OnInit } from '@angular/core';
import { faUndo } from '@fortawesome/free-solid-svg-icons';
import { Validators, FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import { ICliente, Cliente } from 'src/app/shared/model/cliente.model';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-clientes-create-update',
  templateUrl: './clientes-create-update.component.html',
  styleUrls: ['./clientes-create-update.component.css'],
})
export class ClientesCreateUpdateComponent implements OnInit {
  title: string = '';
  faUndo = faUndo;
  isUpdate = false;
  editForm = this.fb.group({
    id: [],
    nombres: [null, [Validators.required]],
    identificacion: [null, [Validators.required]],
    telefono: [],
    email: [],
    direccion: [],
    apellidos: [],
  });

  state$: Observable<object>;
  cliente?: ICliente;
  constructor(
    private clienteService: ClienteService,
    public router: Router,
    private fb: FormBuilder,
    protected activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.title = 'Modificar Cliente';
        this.isUpdate = true;
        this.clienteService.find(params.id).subscribe((res) => {
          this.cliente = res;
          this.updateForm(this.cliente);
        });
      } else {
        this.title = 'Crear Cliente';
      }
    });
  }

  updateForm(cliente: ICliente): void {
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

  regresar(): void {
    window.history.back();
  }

  save(): void {
    this.isUpdate = false;
    const cliente = this.createFromForm();

    if (cliente.idcliente !== null) {
      this.clienteService.update(cliente).subscribe(
        (data) => {
          this.regresar();
        },
        (err) => {
          console.error(err);
        }
      );
    } else {
      this.clienteService.create(cliente).subscribe(
        (data) => {
          this.regresar();
        },
        (err) => {
          console.error(err);
        }
      );
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
}
