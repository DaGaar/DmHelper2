import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Character } from '../character';
import { CharacterService } from '../character-service';

@Component({
  selector: 'app-edit-character',
  templateUrl: './edit-character.component.html',
  styleUrls: ['./edit-character.component.css']
})
export class EditCharacterComponent implements OnInit {

  id?: number;
  character: Character = new Character();

  constructor(private characterService: CharacterService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];

    this.characterService.getCharacterById(this.id).subscribe(data => {
      this.character = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.characterService.editCharacter(this.id, this.character).subscribe( data =>{
      console.log(data);
      this.goToCharacterList();
    }, error => console.log(error));
  }

  goToCharacterList(){
    this.router.navigate(['/characters']);
  }
}
