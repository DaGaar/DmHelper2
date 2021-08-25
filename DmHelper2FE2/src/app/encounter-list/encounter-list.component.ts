import { Component, OnInit } from '@angular/core';
import { Encounter } from '../encounter';
import { EncounterServiceService } from '../encounter-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-encounter-list',
  templateUrl: './encounter-list.component.html',
  styleUrls: ['./encounter-list.component.css']
})
export class EncounterListComponent implements OnInit {

  encounters?: Encounter[];

  constructor(private encounterService: EncounterServiceService, private router: 
    Router) { }

  ngOnInit(): void {
    this.getEncounters();
  }

  private getEncounters() {
    this.encounterService.getEncounterList().subscribe(data => {
      this.encounters = data;
    });
  }

  startEncounter(id?: number) {
    this.router.navigate(['combat', id]);
  }

  viewActionLog(id?: number) {
    this.router.navigate(['action-log', id]);
  }

  viewEncounterDetails(id?: number) {
    this.router.navigate(['app-encounter-details', id])
  }

  deleteEncounter(id?: number) {
    this.encounterService.deleteEncounter(id).subscribe(data => {
      console.log(data);
      this.getEncounters();
    });
  }

  createEncounter() {
    this.router.navigate(['create-encounter']);
  }

}
