import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Combatant } from './combatant';

@Injectable({
	providedIn: 'root'
})
export class CombatantService {
	
	private baseURL = "http://localhost:8080/api/v1/combatants";

	constructor(private httpClient: HttpClient) { }

	getCombatantList(): Observable<Combatant[]> {
		return this.httpClient.get<Combatant[]>(this.baseURL);
	}

	createCombatant(combatant: Combatant): Observable<Object> {
		return this.httpClient.post(`${this.baseURL}`, combatant);
	}

	getCombatantById(id?: number): Observable<Combatant>{
 		return this.httpClient.get<Combatant>(`${this.baseURL}?id=${id}`);
	}

	getCombatantsByEncounterAndSide(encounterId?: number, side?: string): Observable<Combatant[]> {
		console.log("combatantService recieved side:" + side + encounterId);
		return this.httpClient.get<Combatant[]>(
			`${this.baseURL}?encounterId=${encounterId}&side=${side}`);
	}

	GetCombatantByEncounterIdAndCharId(encounterId?: number, charId?: number): Observable<Combatant>{
		console.log("combatantService recieved:" + charId + " and " + encounterId);
		return this.httpClient.get<Combatant>(
			`${this.baseURL}?encounterId=${encounterId}&charId=${charId}`);
		// return this.httpClient.get<Combatant>(`${this.baseURL}?encounterId=encounterId&charId=charId`);
	}

	editCombatant(id?: number, combatant?: Combatant): Observable<Object>{
		return this.httpClient.put(`${this.baseURL}/${id}`, combatant);
	}

	deleteCombatant(id?: number): Observable<Object> {
		return this.httpClient.delete(`${this.baseURL}/${id}`);
	}
	
}