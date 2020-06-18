import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ICliente } from 'src/app/shared/model/cliente.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  public resourceUrl = 'http://localhost:8080/api/clientes';

  constructor(protected http: HttpClient) {}

  create(producto: ICliente): Observable<ICliente> {
    return this.http.post<ICliente>(this.resourceUrl, producto);
  }

  update(producto: ICliente): Observable<ICliente> {
    return this.http.put<ICliente>(this.resourceUrl, producto);
  }

  find(id: number): Observable<ICliente> {
    return this.http.get<ICliente>(`${this.resourceUrl}/${id}`);
  }

  findByIdentificacion(identificacion: number): Observable<ICliente> {
    return this.http.get<ICliente>(`${this.resourceUrl}/identificacion/${identificacion}`);
  }

  getAll(): Observable<ICliente[]> {
    return this.http.get<ICliente[]>(this.resourceUrl);
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, {
      observe: 'response',
    });
  }
}
