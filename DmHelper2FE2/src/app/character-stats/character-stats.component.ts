import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Character } from '../character';
import { CharacterService } from '../character-service';
import { Action } from '../action';
import { ActionService } from '../action.service';
import { Stats } from '../stats';


@Component({
  selector: 'app-character-stats',
  templateUrl: './character-stats.component.html',
  styleUrls: ['./character-stats.component.css']
})
export class CharacterStatsComponent implements OnInit {

  id?: number;
  character?: Character;
  stats?: Stats;

  constructor(private characterService: CharacterService, private actionService: 
      ActionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.character = new Character();
    this.characterService.getCharacterById(this.id).subscribe( data => {
      this.character = data;
    });
    this.getStats(this.id); 
  }

    getStats(id?: number) {
    this.characterService.getCharStats(id).subscribe(data => {
      this.stats = data;
    });
  }
}
