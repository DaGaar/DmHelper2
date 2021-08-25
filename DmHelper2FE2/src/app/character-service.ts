import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Character } from './character';
import { Action } from './action';
import { Stats } from './stats';


@Injectable({
	providedIn: 'root'
})
export class CharacterService {

	private baseURL = "http://localhost:8080/api/v1/pcs";
	private statsBaseURL = "http://localhost:8080/api/v1/stats";

	constructor(private httpClient: HttpClient) { }

	getCharacterList(): Observable<Character[]> {
		return this.httpClient.get<Character[]>(this.baseURL);
	}

	createCharacter(character: Character): Observable<Object> {
		return this.httpClient.post(`${this.baseURL}`, character);
	}

	getCharacterById(id?: number): Observable<Character>{
 		return this.httpClient.get<Character>(`${this.baseURL}/${id}`);
	}

	// getCharNameById(id?: number): Observable<Character>{
	// 	return this.httpClient.get<Character>(`${this.baseURL}/${id}`).
	// }

	// getCharacterByName(name?: string): Observable<Character>{
	// 	return this.httpClient.get<Character>
	// }

	viewCharacter(id?: number, character?: Character): Observable<Object>{
   		return this.httpClient.get<Character>(`${this.baseURL}/${id}`);
	 }
	 
	getCharStats(id?: number): Observable<Stats>{
		return this.httpClient.get<Stats>(`${this.statsBaseURL}/${id}`)

	}

	editCharacter(id?: number, character?: Character): Observable<Object>{
		return this.httpClient.put(`${this.baseURL}/${id}`, character);
	}

	deleteCharacter(id?: number): Observable<Object> {
		return this.httpClient.delete(`${this.baseURL}/${id}`);
	}

	// getCharAttacks(id?: number): number{
	// 	let attacks = 0;
	// 	let actions = [this.httpClient.get<Action[]>
	// 		(`${this.attackerBaseURL}/${id}`)];
	// 	for (let i = 0; i < actions.length; i++) { attacks ++}

	// 	console.log(attacks);
	// 	return attacks;
	// } 
}