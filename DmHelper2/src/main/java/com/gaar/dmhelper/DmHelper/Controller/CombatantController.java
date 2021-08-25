package com.gaar.dmhelper.DmHelper.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaar.dmhelper.DmHelper.Model.Combatant;
import com.gaar.dmhelper.DmHelper.Model.Pc;
import com.gaar.dmhelper.DmHelper.Service.CombatantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class CombatantController {

	@Autowired
	private CombatantService combatantService;
	
//	@RequestMapping("/combatants")
//	public List<Combatant> getCombatants() {
//		return combatantService.findAll();
//	}
	
	@PostMapping("/combatants")
	public Combatant createCombatant(@RequestBody Combatant combatant) {
		return combatantService.save(combatant);
	}
	
	@GetMapping("/combatants")
	public ResponseEntity<List<Combatant>> getCombatants(@RequestParam(
			required = false) Map<String, String> allParams) {
		
		List<Combatant> combatants = null;
		
		if(allParams.isEmpty()) {
			combatants = combatantService.findAll();
			return ResponseEntity.ok(combatants);
		} else {
			
			//LOCAL VARS
			Long id = null, charId = null, encounterId = null;
			String side = null;
			combatants = new ArrayList<Combatant>();
			
			//INITIALIZE LOCAL VARS FROM PARAMS- NULL IF MISSING
			if(allParams.containsKey("id"))
				id = Long.parseLong(allParams.get("id"));
			if(allParams.containsKey("charId"))
				charId = Long.parseLong(allParams.get("charId"));
			if(allParams.containsKey("encounterId"))
				encounterId = Long.parseLong(allParams.get("encounterId"));
			if(allParams.containsKey("side"))
				side = allParams.get("side");
			
			//ROUTE TO CORRECTE SERVICE METHOD
			if(id != null) { //?id=9
				combatants.add(combatantService.findById(id));
			} else if(encounterId != null && charId == null && side == null) { //?encounterId=124
				combatants = (combatantService.findByEncounter(encounterId));
			} else if(encounterId != null && charId == null && side != null) { //?encounterId=124&charId=101
				combatants = (combatantService.findByEncounterAndSide(encounterId, side));
			} else if(encounterId != null && charId != null && side == null) { //?encounterId=124&side=enemy
				combatants.add(combatantService.findByEncounterAndChar(encounterId, charId));
			}
		}
		System.out.println("inside CombatantControler getCombatants: " + combatants);
		return ResponseEntity.ok(combatants);
	}
	
//	@GetMapping("/combatants/{id}")
//	public ResponseEntity<Combatant> getCombatantById(@PathVariable Long id) {
//		Combatant combatant = combatantService.findById(id);
//		return ResponseEntity.ok(combatant);
//	}
//	
//	@GetMapping("/combatants/side/{side}")
//	public ResponseEntity<List<Combatant>> getCombatantsBySide(@PathVariable String side) {
//		List<Combatant> combatants = combatantService.findBySide(side);
//		return ResponseEntity.ok(combatants);
//	}
//	
//	@GetMapping("/combatants/{encounterId}/{charId}")
//	public ResponseEntity<Combatant> getCombatantByCharIdAndEncounterId(
//				@PathVariable Long encounterId, @PathVariable Long charId) {
//		Combatant combatant = combatantService.findByCharIdAndEncounterId(encounterId, charId);
//		return ResponseEntity.ok(combatant);
//	}
	
	@PutMapping("/combatants/{id}")
	public ResponseEntity<Combatant> updateCombatant(@PathVariable Long id, @RequestBody Combatant combatantDetails) {
		
		// STEP ONE: RETRIEVE STUDENT RECORD FROM THE DB USING ID
		Combatant combatant = combatantService.findById(id);
		
		// STEP TWO: UPDATE RETRIEVED STUDENT WITH NEW STUDENT DETAILS
		combatant.setInitiative(combatantDetails.getInitiative());
		combatant.setSide(combatantDetails.getSide());
		
		//STEP THREE: SAVE THE MODIFIED STUDENT RECORD TO THE DB
		Combatant updatedCombatant = combatantService.save(combatant);
		
		//RETURN A RESPONSE CONTAINING OK AND THE UPDATED STUDENT RECORD
		return ResponseEntity.ok(updatedCombatant);
	}
	
	@DeleteMapping("/combatants/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCombatant(@PathVariable Long id) {
		
		//STEP ONE: RETRIEVE STUDENT RECORD FROM THE DATABASE USING ID
		Combatant combatant = combatantService.findById(id);
		
		// STEP TWO: USE CALL SERVICE'S DELETE METHOD
		combatantService.delete(combatant);
		
		// STEP THREE: CREATE A HASHMAP TO HOLD A MSG (KEY) AND TRUE (VALUE)
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		
		// RETURN MAP INSIDE RESPONSE ENTITY
		return ResponseEntity.ok(response);
	}
}
