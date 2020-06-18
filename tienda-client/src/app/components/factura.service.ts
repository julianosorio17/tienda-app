import { Injectable } from '@angular/core';
import { IFactura } from '../shared/model/factura.model';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IFacturaDetalle } from '../shared/model/facturaDetalle.model';

@Injectable({
  providedIn: 'root',
})
export class FacturaService {
  public resourceUrl = 'http://localhost:8080/api/testFactura';

  constructor(protected http: HttpClient) {}

  create(factura: IFactura): Observable<IFactura> {
    return this.http.post<IFactura>(this.resourceUrl, factura);
  }

  update(factura: IFactura): Observable<IFactura> {
    return this.http.put<IFactura>(this.resourceUrl, factura);
  }

  find(id: number): Observable<IFactura> {
    return this.http.get<IFactura>(`${this.resourceUrl}/${id}`);
  }

  getAll(): Observable<IFactura[]> {
    return this.http.get<IFactura[]>(this.resourceUrl);
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, {
      observe: 'response',
    });
  }

  findDetalleFactura(id: number): Observable<IFacturaDetalle[]> {
    return this.http.get<IFacturaDetalle[]>(
      `${this.resourceUrl}/detalle/${id}`
    );
  }
}
