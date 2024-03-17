import { Component, OnInit } from '@angular/core';
import { ClientService } from "../shared/client.service";
import { Client } from "../shared/client.model";
import { Location } from "@angular/common";

@Component({
  selector: 'app-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {

  constructor(private clientService: ClientService,
              private location: Location) { }

  ngOnInit(): void {
  }


  saveClient(firstName: string, lastName: string, email: string, phoneNumber: string, city: string) {
    console.log("save button clicked");

    const client: Client = {
      id: 0,
      firstName,
      lastName,
      email,
      phoneNumber,
      city
    };

    this.clientService.saveClient(client)
      .subscribe(d => console.log("saved: ", d));
    this.location.back();
  }
}
