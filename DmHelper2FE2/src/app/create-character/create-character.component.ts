import { Component, OnInit } from '@angular/core';
import { Character } from '../character';
import { CharacterService } from '../character-service';
import { Router } from '@angular/router';
import {FormControl} from '@angular/forms';


@Component({
  selector: 'app-create-character',
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.css']
})
export class CreateCharacterComponent implements OnInit {

  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  character: Character = new Character();
  constructor(private characterService: CharacterService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  saveCharacter() {
    this.characterService.createCharacter(this.character).subscribe( data => {
      console.log(data);
      this.goToCharacterList();
    },
    error => console.log(error));
  }

  goToCharacterList() {
    this.router.navigate(['/characters']);
  }

  onSubmit() {
    this.saveCharacter();
    console.log(this.character);
  }

}
