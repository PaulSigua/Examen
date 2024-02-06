import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Recarga } from '../domain/cliente';

@Injectable({
  providedIn: 'root'
})
export class RecargasService {
  
  constructor(private http: HttpClient) { }

  getClientes(){
    let url= environment.WA_PATH + '/Clientes/list';
    return this.http.get<any>(url);
  }

  recargar(recarga: Recarga){
    let url = environment.WA_PATH + '/recargar';
    return this.http.post<any>(url, recarga);
  }
}
