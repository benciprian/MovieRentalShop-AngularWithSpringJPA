import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import { ClientService } from '../shared/client.service';
import { Client } from '../shared/client.model';
import { Location } from '@angular/common';
import {switchMap} from "rxjs";


@Component({
  selector: 'app-client-update',
  templateUrl: './client-update.component.html',
  styleUrls: ['./client-update.component.css']
})
export class ClientUpdateComponent implements OnInit {


  @Input() client!: Client;
  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router,
   private location: Location
  ) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.clientService.getClient(+params['id'])))
      .subscribe(client => this.client = client ?? <Client>{});
  }

  goBack(): void {
    this.location.back();
  }

  // saveClient(): void {
  //   this.clientService.update(this.client)
  //     .subscribe(_ => this.goBack());
  // }

  saveClient(): void {
    this.clientService.update(this.client)
      .subscribe(_ => {
        console.log('Client saved successfully');
        this.goBack();
      });
  }

}


