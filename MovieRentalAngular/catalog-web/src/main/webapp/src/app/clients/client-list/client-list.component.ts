import { Component, OnInit } from '@angular/core';
import {ClientService} from "../shared/client.service";
import {Client} from "../shared/client.model";
import {Router} from "@angular/router";
@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients: Client[] = []

  constructor(private clientService: ClientService,private router: Router) { }

  ngOnInit(): void {
    this.clientService.getAllClients()
      .subscribe(d => this.clients = d)
  }

  deleteClient(client: Client) {
    this.clientService.deleteClient(client.id)
      .subscribe(_ => console.log("client deleted"))
    this.clients = this.clients.filter(d => d.id !== client.id)
  }


  goToUpdateClient(clientId: number): void {
    console.log("goToUpdateClient clicked")
    this.router.navigate(['/client/update', clientId]);
  }

  // goToUpdateClient(clientId: number): void {
  //   this.router.navigate(['/client/update', clientId]).then(() => {
  //     console.log('Client updated');
  //     // You can place additional code here if needed
  //   });
  // }


}
