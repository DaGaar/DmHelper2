import { Component, OnInit } from '@angular/core';
import { Action } from '../action';
import { ActionService } from '../action.service';
import { Character } from '../character';
import { CharacterService } from '../character-service';
import { Router, ActivatedRoute } from '@angular/router';
import {MatMenuModule} from '@angular/material/menu';
import { Encounter } from '../encounter';
import { EncounterServiceService } from '../encounter-service.service';
import { CombatantService } from '../combatantservice';
import { Combatant } from '../combatant';




@Component({
  selector: 'app-combat',
  templateUrl: './combat.component.html',
  styleUrls: ['./combat.component.css']
})
export class CombatComponent implements OnInit {
  
  // characters?: Character[];
  action: Action = new Action();
  actionTypes = [
    { type: 'attack', name: 'Attack'}, { type: 'castSpell', name: 'Cast Spell'}, 
    { type: 'dash', name: 'Dash'}, { type: 'disengage', name: 'Disengage'}, 
    { type: 'dodge', name: 'Dodge'}, { type: 'help', name: 'Help'},
    { type: 'hide', name: 'Hide'}, { type: 'ready', name: 'Ready'}, 
    { type: 'abilityCheck', name: 'Ability Check'}, { type: 'useObject', name: 'Use Object'}
  ];
  // attack_select?: string;

  //LOCAL VARS
  id?: number;
  encounter?: Encounter;
  encounterChars?: Character[];
  charEnemies: Character[] = [];
  charAllies: Character[] = [];
  combEnemies: Combatant[] = [];
  combAllies: Combatant[] = [];
  charAtempt?: Character;
  combAtempt?: Combatant;



  constructor(
    private actionService: ActionService, 
    private characterService: CharacterService,
    private combatantService: CombatantService,
    private encounterService: EncounterServiceService, 
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.encounter = new Encounter();
    this.encounterService.getEncounterById(this.id).subscribe( data => {
      console.log("OnInit encounter: " + data.id);
      this.encounter = data;
    });
    this.getCharacters();
    this.getCombBySide();
    this.getCharBySide();
  }

   private getCharacters() {
    this.encounterService.getEncounterCharacters(this.id).subscribe(data => {
      this.encounterChars = data;
    });
    // this.combatantService.getCombatantById(7).subscribe(data => {
    //   console.log("testing getCombatantById: " + data.charId);
    // })
    // this.combatantService.getCombatantsByEncounterAndSide(this.id, "enemy").subscribe(data => {
    //   //charAtempt?: Character;
    //   let combAtempt: Combatant = new Combatant;
    //   for(let i = 0; i < data.length; i++) {
    //     combAtempt = data[i];
    //     this.charAtempt = this.characterService.getCharacterById(combAtempt.charId);
    //     // this.enemies.push
    //     ()
    //   }
    //   console.log("enemies" + data);
    // });
   }

  private getCombBySide() {
    console.log("getCombBySide: " + this.combEnemies);
    this.combatantService.getCombatantsByEncounterAndSide(this.id, "enemy").subscribe(data => {
      console.log("getCombBySide data: " + data[0].charId);
      this.combEnemies = data;
      console.log("getCombBySide data to combEnemies: " + this.combEnemies);
    });
    // this.combatantService.getCombatantsByEncounterAndSide(this.id, "allie").subscribe(data => {
    //   this.combAllies = data;
    // });
    
  }

  private getCharBySide() {
    for(let i = 0; i < this.combEnemies.length; i++) {
      this.characterService.getCharacterById(this.combEnemies[i].charId).subscribe(data => {
        this.charEnemies.push(data);
      });
    }    
    for(let i = 0; i < this.combAllies.length; i++) {
      this.characterService.getCharacterById(this.combAllies[i].charId).subscribe(data => {
        console.log("pushing data to charAllies: " + data);
        this.charAllies.push(data);
      });
    }
    console.log("getCharBySide " + this.charAllies);
  }
  // private getCharacters() {
  //   this.characterService.getCharacterList().subscribe(data => {
  //     this.characters = data;
  //   });
  // }

  // getId(event: Event): string {
  //   return (event.target as HTMLInputElement).value;
  // }
  
  //TODO PERHAPS ASSIGN FIELDS TO PLACEHOLDER VARIABLES?
  //flush variables after creating action
  //flush if go back to previus variable creation (chenged mind or messed up)
  // a?: number = id
	// b?: number = encounterId
	// c?: number = attackerId
	// d?: number = attackedId
	// e?: number = dmgDone
	// f?: string = effect
	// g?: string = type

  saveAction() {
    this.action.encounterId = this.encounter?.id;
    this.actionService.createAction(this.action).subscribe( data => {
      console.log(data);
     // this.goToActionList();
    },
    error => console.log(error));
  }

  viewActionLog() {
    this.router.navigate(['action-log', this.encounter?.id]);
  }

  // goToActionList() {
  //   this.router.navigate(['/actions']);
  // }

  onSubmit() {
     this.saveAction();
    // console.log(this.action);
  }

  

}
