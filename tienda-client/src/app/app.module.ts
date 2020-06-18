import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductosComponent } from './components/productos/productos.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { CajaComponent } from './components/caja/caja.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ProductoCreateUpdateComponent } from './components/productos/producto-create-update/producto-create-update.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClientesCreateUpdateComponent } from './components/clientes/clientes-create-update/clientes-create-update.component';
import { HomeComponent } from './components/home/home.component';
import { FacturaComponent } from './components/factura/factura.component';
import { FacturaDetalleComponent } from './components/factura-detalle/factura-detalle.component';
@NgModule({
  declarations: [
    AppComponent,
    ProductosComponent,
    ClientesComponent,
    CajaComponent,
    NavbarComponent,
    ProductoCreateUpdateComponent,
    ClientesCreateUpdateComponent,
    HomeComponent,
    FacturaComponent,
    FacturaDetalleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
