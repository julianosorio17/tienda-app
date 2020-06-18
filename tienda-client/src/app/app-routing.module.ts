import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductosComponent } from './components/productos/productos.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { CajaComponent } from './components/caja/caja.component';
import { ProductoCreateUpdateComponent } from './components/productos/producto-create-update/producto-create-update.component';
import { ClientesCreateUpdateComponent } from './components/clientes/clientes-create-update/clientes-create-update.component';
import { HomeComponent } from './components/home/home.component';
import { FacturaComponent } from './components/factura/factura.component';
import { FacturaDetalleComponent } from './components/factura-detalle/factura-detalle.component';

const routes: Routes = [
  { path: '', component: CajaComponent, children: [] },
  { path: 'productos', component: ProductosComponent, children: [] },
  { path: 'clientes', component: ClientesComponent },
  { path: 'caja', component: CajaComponent },
  {
    path: 'crearProducto',
    component: ProductoCreateUpdateComponent,
  },
  { path: 'modificarProducto/:id', component: ProductoCreateUpdateComponent },
  {
    path: 'crearCliente',
    component: ClientesCreateUpdateComponent,
  },
  { path: 'modificarCliente/:id', component: ClientesCreateUpdateComponent },

  { path: 'factura', component: FacturaComponent },
  { path: 'facturaDetalle/:id', component: FacturaDetalleComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
