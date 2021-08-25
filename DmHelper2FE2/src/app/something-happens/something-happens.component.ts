import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-something-happens',
  templateUrl: './something-happens.component.html',
  styleUrls: ['./something-happens.component.css']
})
export class SomethingHappensComponent implements OnInit {

  hit = 'Glancing blow';
  element?: HTMLElement;
  crit = '';
  
  constructor() { }

  ngOnInit(): void {
  }

  onClickHit() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="Whap";
  }
  onClickMiss() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="Wiff!";
  }
  onClickCritHit() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="Big Whap!";
  }
  onClickCritMiss() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="Big Wiff!";
  }
  onClickBloodied() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="spurt!";
  }
  onClickKill() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="X.X";
  }
  onClickMassiveDmg() {
    this.element = document.getElementById('demo') as HTMLElement;
    this.element.innerHTML="Big Hurt";
  }
}
