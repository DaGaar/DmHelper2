import { Component, OnInit } from '@angular/core';
import { Character } from '../character';
import { CharacterService } from '../character-service';
import { Action } from '../action';
import { ActionService } from '../action.service';
import { Router } from '@angular/router';
import { Stats } from '../stats';


@Component({
  selector: 'app-character-list',
  templateUrl: './character-list.component.html',
  styleUrls: ['./character-list.component.css']
})
export class CharacterListComponent implements OnInit {

  characters?: Character[];
  character?: Character;
  stats?: Stats;

 // let charAttacks = getCharAttacks()

  constructor(private characterService: CharacterService, private actionService:
     ActionService, private router: Router) { }

  ngOnInit(): void {
    this.getCharacters();
  }

  private getCharacters() {
    this.characterService.getCharacterList().subscribe(data => {
      this.characters = data;
    });
  }

  viewCharStats(id?: number) {
    this.router.navigate(['character-stats', id]);
  }

  editCharacter(id?: number) {
    console.log(id);
    this.router.navigate(['edit-character', id]);
  }

  deleteCharacter(id?: number) {
    this.characterService.deleteCharacter(id).subscribe(data => {
      console.log(data);
      this.getCharacters();
    });
  }

  createCharacter() {
    this.router.navigate(['create-character']);
  }
  // getStats(id?: number) {
  //   this.characterService.getCharStats(id).subscribe(data => {
  //     this.stats = data;
  //   });
  // }


}
