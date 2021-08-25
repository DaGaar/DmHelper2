import { Component, OnInit} from '@angular/core';
import { Character } from '../character';
import { Combatant } from '../combatant';
import { CharacterService } from '../character-service';
import { CombatantService } from '../combatantservice';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import {ThemePalette} from '@angular/material/core';
import { Encounter } from '../encounter';
import { EncounterServiceService } from '../encounter-service.service';


export interface ChipColor {
  name: string;
  color: ThemePalette;
}



@Component({
  selector: 'app-create-encounter',
  templateUrl: './create-encounter.component.html',
  styleUrls: ['./create-encounter.component.css']
})
export class CreateEncounterComponent implements OnInit {

  encounter: Encounter = new Encounter();
  
  // character = new Character();
  // allCharacters?: Character[];
  // allCombatants?: Combatant[];
  // allies?: Character[];
  // enemies?: Character[];
  // combatant: Combatant = new Combatant();

  constructor(private encounterService: EncounterServiceService,
     private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.saveEncounter();
    console.log(this.encounter);
  }

  // saveCombatant() {
  //   this.combatantService.createCombatant(this.combatant).subscribe( data => {
  //     console.log(data);

  //   },
  //   error => console.log(error));
  // }

  // onCharMouseOver($event: MouseEvent) {
  //   console.log('mousing over ' + $event);
  // }

  // showAllies() {
  //   console.log(allies);
  // }

  //TODO: MAKE VIEW UPDATE CHARACTER LIST (mat-chip)
  // loadAlly(character: Character) {
  //   this.allies?.push(character);
  //   console.log(this.allies);
    //this.goToCharacterList();
    // this.combatantService.createCombatant(this.combatant).subscribe( data => {
    //   console.log(data);
     // this.goToCharacterList();
    // },
    // error => console.log(error));
  //}

  // onSubmit() {
  //   this.goToCharacterList();
  // }

  //  goToCharacterList() {
  //   this.router.navigate(['/characters']);
  // }

  
  saveEncounter() {
    this.encounterService.createEncounter(this.encounter).subscribe( data => {
      console.log(data);
      this.goToEncounterDetails();
    },
      error => console.log(error));
   // this.router.navigate(['create-character']);
    //    this.id = this.route.snapshot.params['id'];
    // this.character = new Character();
    // this.characterService.getCharacterById(this.id).subscribe( data => {
    //   this.character = data;
    // });
  }

  goToEncounterDetails() {
    this.router.navigate(['/encounters']);
  }

  // onSubmit() {
  //   this.saveEncounter();
  //   console.log(this.encounter);
  // }

  // private getAllCharacters() {
  //   this.characterService.getCharacterList().subscribe(data => {
  //     this.allCharacters = data;
  //   });
  // }

  //   private getAllCombatants() {
  //   this.combatantService.getCombatantList().subscribe(data => {
  //     this.allCombatants = data;
  //   });
  // }
  // loadCharacters() {
  //   this.allCharacters;
  // }
}
