import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Encounter } from '../encounter';
import { EncounterServiceService } from '../encounter-service.service';
import { ActionService } from '../action.service';
import { Action } from '../action';
import { Combatant } from '../combatant';
import { Character } from '../character';
import { CombatantService } from '../combatantservice';
import { CharacterService } from '../character-service';

@Component({
  selector: 'app-encounter-details',
  templateUrl: './encounter-details.component.html',
  styleUrls: ['./encounter-details.component.css']
})
export class EncounterDetailsComponent implements OnInit {

    
  //TODO: -find combatant by charId and EncounterId
    //        -when character or encounter are deleted, also delete
    //           any combatant that has one of those ids
    //        -prevent repeat characters within encounter

  id?: number;
  encounter?: Encounter;
  combatant: Combatant = new Combatant();
  combatants?: Combatant[];
  allCharacters?: Character[];
  encounterChars?: Character[];
  comAllies?: Combatant[];
  comEnemies?: Combatant[];
  allies: Character[] = [];
  enemies: Character[] = [];
  queueComb: Combatant = new Combatant();
  queueChar: Character = new Character();
  charComb: Combatant = new Combatant();

  constructor(
    private encounterService: EncounterServiceService, 
    private actionService: ActionService, 
    private combatantService: CombatantService,
    private characterService: CharacterService,
    private router: Router, 
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    
    this.encounter = new Encounter();
    this.encounterService.getEncounterById(this.id).subscribe( data => {
      this.encounter = data;
    });
    this.getCombatants();
    this.getCharacters();
  }

  getCombatants() {
    this.encounterService.getEncounterCombatants(this.id).subscribe(data => {
      this.combatants = data;
    });    
  }

  getCombatantOfChar(id: number): Combatant {
    let charAtempt: Combatant = new Combatant;
    this.combatantService.GetCombatantByEncounterIdAndCharId(
      this.id, id).subscribe(data => {
        charAtempt = data;
      });
      console.log("getCombatantOfChar " + charAtempt.initiative);
    return charAtempt;
  }

  //TODO: seperate out the allies/enemies that are not in the encounter
  //      and get the proper characters w/ that data
  private getCharacters() {
    this.characterService.getCharacterList().subscribe(data => {
      this.allCharacters = data;
    });
    this.encounterService.getEncounterCharacters(this.id).subscribe(data => {
      this.encounterChars = data;
      console.log("encounterChars" + data);
    });
    this.combatantService.getCombatantsByEncounterAndSide(this.id, "allie").subscribe(data => {
      this.comAllies = data;
      console.log("allies" + data);
      // for (let i = 0; i < data.length; i++) {
      //   if (data[i].encounterId === this.encounter?.id) {
      //     this.queueChar = this.characterService.getCharacterById(data[i].charId);
      //   }
      // }
    });
    this.combatantService.getCombatantsByEncounterAndSide(this.id, "enemy").subscribe(data => {
      this.comEnemies = data;
      console.log("enemies" + data);
    });
  } 
  
  // private getCharacter(id?: number) {
  //   this.characterService.getCharacterById(id).subscribe(data => {
  //     this.encounterChars?.push(data);
  //   });
  // }

  saveCombatant() {
    this.combatant.encounterId = this.encounter?.id;
    this.combatantService.createCombatant(this.combatant).subscribe(data => {
      console.log(data);
      //this.goToCharacterList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.saveCombatant();
    //this.getCharacter(this.combatant.charId);
    this.getCharacters();
    console.log(this.combatant);
    location.reload();
  }

  // changeInit(charId: number, init: number) {
  //   this.combatantService.GetCombatantByEncounterIdAndCharId(
  //     this.id, charId).subscribe(data => {
  //       this.charComb = data;
  //     });
    
  //   this.combatantService.editCombatant(
  //     this.charComb.id, this.charComb).subscribe( data =>{
  //       console.log(data);
  //     }, error => console.log(error));  
  // }

  testCombId(comId?: number) {
    console.log(comId);
    this.getCombatantOfChar(101);
  }

  
  removeCombatant(charId?: number) {
  //  console.log(charId, this.encounter?.id);
  
    this.combatantService.GetCombatantByEncounterIdAndCharId(
      this.encounter?.id, charId).subscribe(data => {
        this.queueComb = data;
        console.log("Inside removeCombatant" + data);
        console.log(this.queueComb);
        // this.combatantService.deleteCombatant(data.id).subscribe(data => {
        //   console.log(data);
        // });
      });
  }

  startEncounter() {
    this.router.navigate(['combat', this.encounter?.id]);
  }

}  
