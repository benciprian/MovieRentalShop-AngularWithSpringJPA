import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Client} from "./client.model";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private url = "http://localhost:8080/api/clients";
  constructor(private httpClient: HttpClient) { }
  getAllClients(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(this.url);
  }

  saveClient(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(this.url, client)
  }

  getClient(id: number): Observable<Client | undefined> {
    return this.getAllClients()
      .pipe(
        map(clients => clients.find(client => client.id === id))
      );
  }

  update(client: Client): Observable<Client> {
    const url = `${this.url}/${client.id}`;
    return this.httpClient
      .put<Client>(url, client);
  }

  deleteClient(id: number): Observable<any> {
    const url = `${this.url}/${id}`
    return this.httpClient.delete(url)
  }
}
