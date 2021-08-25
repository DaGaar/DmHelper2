import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Action } from '../action';
import { ActionService } from '../action.service';
import { Character } from '../character';
import { CharacterService } from '../character-service';
import { Encounter } from '../encounter';
import { EncounterServiceService } from '../encounter-service.service'

@Component({
  selector: 'app-action-log',
  templateUrl: './action-log.component.html',
  styleUrls: ['./action-log.component.css'],
  providers: [ ActionService]
})
export class ActionLogComponent implements OnInit {

  id?: number;
  actions?: Action[];
  characters?: Character[];
  encounter?: Encounter;

  constructor(private actionService: ActionService, private characterService: 
    CharacterService, private encounterService: EncounterServiceService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getActions(this.id);
    this.getCharacters();
  }

  private getActions(id?: number) {
    this.actionService.getEncounterActionList(id).subscribe(data => {
      this.actions = data;
    })
  }

  // private getEncounter() {
  //   this.actionService.getEncounterActionList().subscribe(data => {
  //     this.actions = data;
  //   }).
  // }

  private getCharacters() {
    this.characterService.getCharacterList().subscribe(data => {
      this.characters = data;
    });
  }


  //TODO: FIND WAY TO DISPLAY CHARACTER NAME ALONGSIDE ID IN LOG
  // private getCharName(id?: number) {
  //   this.characterService.getCharacterById(id)
  // }

  // viewAction(id?: number) {
  //   this.router.navigate(['ac'])
  // }

}
