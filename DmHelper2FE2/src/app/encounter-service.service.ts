import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Encounter } from './encounter';
import { Combatant } from './combatant';
import { Character } from './character';


@Injectable({
  providedIn: 'root'
})
export class EncounterServiceService {

  private baseURL = "http://localhost:8080/api/v1/encounters";
  private combatantsURL = "http://localhost:8080/api/v1/combatants";
  private charactersURL = "http://localhost:8080/api/v1/encountercharacters";

  constructor(private httpClient: HttpClient) { }

  // getNumOfCombatants(id?: number): {
  //   return this.httpClient.get<Encounter>(`${this.baseURL}/${id}`);
  // } 

  getEncounterList(): Observable<Encounter[]> {
    return this.httpClient.get<Encounter[]>(this.baseURL);
  }

  createEncounter(encounter: Encounter): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, encounter);
  }

  getEncounterById(id?: number): Observable<Encounter>{
 		return this.httpClient.get<Encounter>(`${this.baseURL}/${id}`);
  }

  getEncounterCombatants(id?: number): Observable<Combatant[]>{
    return this.httpClient.get<Combatant[]>(`${this.combatantsURL}?encounterId=${id}`);
  }

  getEncounterCharacters(id?: number): Observable<Character[]>{
    return this.httpClient.get<Character[]>(`${this.charactersURL}/${id}`);
  }
  
  // startEncounter(id?: number) {
  //   this.startEncounter.navigate(['create-encounter', id]);
  // }

  // viewCombatants()

  // viewLog()

  // editEncounter()

  deleteEncounter(id?: number): Observable<Object> {
		return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}