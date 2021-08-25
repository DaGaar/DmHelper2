import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Action } from './action';

@Injectable({
	providedIn: 'root'
})
export class ActionService {

	private baseURL = "http://localhost:8080/api/v1/actions";
	private encounterURL = "http://localhost:8080/api/v1/encounterActions";
	private attackerBaseURL = "http://localhost:8080/api/v1/charAttacksMade";
	private attackedBaseURL = "http://localhost:8080/api/v1/charAttacksRecieved";


	constructor(private httpClient: HttpClient) { }

	getActionList(): Observable<Action[]> {
		return this.httpClient.get<Action[]>(this.baseURL);
	}

	getEncounterActionList(id?: number): Observable<Action[]> {
		return this.httpClient.get<Action[]>(`${this.encounterURL}/${id}`);
	}

	createAction(action: Action): Observable<Object> {
		return this.httpClient.post(`${this.baseURL}`, action);
	}

	getActionById(id?: number): Observable<Action>{
 		return this.httpClient.get<Action>(`${this.baseURL}/${id}`);
	}

	getActionsByAttackerId(id?: number): Observable<Action>{
		return this.httpClient.get<Action>(`${this.attackerBaseURL}/${id}`);
	}

	getActionsByAttackedId(id?: number): Observable<Action>{
		return this.httpClient.get<Action>(`${this.attackedBaseURL}/${id}`);
	}

	viewAction(id?: number, action?: Action): Observable<Object>{
   		return this.httpClient.get<Action>(`${this.baseURL}/${id}`);
	 }
	 
	
}
