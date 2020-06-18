import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { IProducto } from 'src/app/shared/model/producto.model';
import { Observable } from 'rxjs';

type EntityResponseType = HttpResponse<IProducto>;
type EntityArrayResponseType = HttpResponse<IProducto[]>;

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  public resourceUrl = 'http://localhost:8080/api/testProducto';

  constructor(protected http: HttpClient) {}

  create(producto: IProducto): Observable<IProducto> {
    return this.http.post<IProducto>(this.resourceUrl, producto);
  }

  update(producto: IProducto): Observable<IProducto> {
    return this.http.put<IProducto>(this.resourceUrl, producto);
  }

  find(id: number): Observable<IProducto> {
    return this.http.get<IProducto>(`${this.resourceUrl}/${id}`);
  }

  getAll(): Observable<IProducto[]> {
    return this.http.get<IProducto[]>(this.resourceUrl);
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, {
      observe: 'response',
    });
  }
}
