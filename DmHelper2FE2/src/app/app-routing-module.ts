import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CombatComponent } from './combat/combat.component';
import { ActionLogComponent } from './action-log/action-log.component';
import { CharacterListComponent } from './character-list/character-list.component';
import { CharacterStatsComponent } from './character-stats/character-stats.component';
import { CreateCharacterComponent } from './create-character/create-character.component';
import { CreateEncounterComponent } from './create-encounter/create-encounter.component';
import { EditCharacterComponent } from './edit-character/edit-character.component';
import { EncounterListComponent } from './encounter-list/encounter-list.component';
import { EncounterDetailsComponent } from './encounter-details/encounter-details.component';


const routes : Routes = [
	{path : 'combat/:id', component: CombatComponent},
	{path : 'action-log/:id', component: ActionLogComponent},
	{path : 'characters', component: CharacterListComponent},
	{path : 'encounters', component: EncounterListComponent},
	{path : 'create-encounter', component: CreateEncounterComponent},
	{path : '', redirectTo: 'characters', pathMatch: 'full'},
	{path : '', redirectTo: 'encounters', pathMatch: 'full'},
	{path: 'character-stats/:id', component: CharacterStatsComponent},
	{path: 'create-character', component: CreateCharacterComponent},
	{path: 'app-encounter-details/:id', component: EncounterDetailsComponent},
	{path : 'edit-character/:id', component: EditCharacterComponent}

]

@NgModule({
	declarations: [],
	imports: [
		RouterModule.forRoot(routes)
	],
	exports: [RouterModule]
})
export class AppRoutingModule { }
