import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SomethingHappensComponent } from './something-happens/something-happens.component';
import { CombatComponent } from './combat/combat.component';
import { AppRoutingModule } from './app-routing-module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ActionLogComponent } from './action-log/action-log.component';
import { CharacterListComponent } from './character-list/character-list.component';
import { CharacterStatsComponent } from './character-stats/character-stats.component';
import { MatSliderModule } from '@angular/material/slider';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card';
import { CreateCharacterComponent } from './create-character/create-character.component';
import { CreateEncounterComponent } from './create-encounter/create-encounter.component';
import {MatChipsModule} from '@angular/material/chips';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import { EditCharacterComponent } from './edit-character/edit-character.component';
import { EncounterListComponent } from './encounter-list/encounter-list.component';
import { EncounterDetailsComponent } from './encounter-details/encounter-details.component';




@NgModule({
  declarations: [
    AppComponent,
    SomethingHappensComponent,
    CombatComponent,
    ActionLogComponent,
    CharacterListComponent,
    CharacterStatsComponent,
    CreateCharacterComponent,
    CreateEncounterComponent,
    EditCharacterComponent,
    EncounterListComponent,
    EncounterDetailsComponent
  ],
  imports: [
    BrowserModule,
    MatSliderModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatCardModule,
    MatChipsModule,
    MatSelectModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
