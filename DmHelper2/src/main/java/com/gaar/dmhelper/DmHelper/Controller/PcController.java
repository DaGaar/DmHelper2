package com.gaar.dmhelper.DmHelper.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaar.dmhelper.DmHelper.Stats;
import com.gaar.dmhelper.DmHelper.Model.Action;
import com.gaar.dmhelper.DmHelper.Model.Pc;

import com.gaar.dmhelper.DmHelper.Service.PcService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class PcController {
	
	@Autowired
	private PcService pcService;
	
	@RequestMapping("/pcs")
	public List<Pc> getCharacters() {
		System.out.println("inside CharacterController getCharacters");
		return pcService.findAll();
	}
	
	@PostMapping("/pcs")
	public Pc createPc(@RequestBody Pc pc) {
		return pcService.save(pc);
	}
	
	@GetMapping("/pcs/{id}")
	public ResponseEntity<Pc> getPcById(@PathVariable Long id) {
		Pc pc = pcService.findById(id);
		return ResponseEntity.ok(pc);
	}
	
	// PUT REQUEST IS USED TO MODIFY AN EXISTING RECORD
	@PutMapping("/pcs/{id}")
	public ResponseEntity<Pc> updateCharacter(@PathVariable Long id, @RequestBody Pc charDetails) {
		
		// STEP ONE: RETRIEVE STUDENT RECORD FROM THE DB USING ID
		Pc pc = pcService.findById(id);
		
		// STEP TWO: UPDATE RETRIEVED STUDENT WITH NEW STUDENT DETAILS
		pc.setName(charDetails.getName());
		pc.setCurrentHp(charDetails.getCurrentHp());
		
		//STEP THREE: SAVE THE MODIFIED STUDENT RECORD TO THE DB
		Pc updatedChar = pcService.save(pc);
		
		//RETURN A RESPONSE CONTAINING OK AND THE UPDATED STUDENT RECORD
		return ResponseEntity.ok(updatedChar);
	}
	
	@GetMapping("/stats/{id}")
	public ResponseEntity<Stats> getStatsById(@PathVariable Long id) {

		Stats stats = pcService.genStats(id);
		return ResponseEntity.ok(stats);
	}
	
	@DeleteMapping("/pcs/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCharacter(@PathVariable Long id) {
		
		//STEP ONE: RETRIEVE STUDENT RECORD FROM THE DATABASE USING ID
		Pc pc = pcService.findById(id);
		
		// STEP TWO: USE CALL SERVICE'S DELETE METHOD
		pcService.delete(pc);
		
		// STEP THREE: CREATE A HASHMAP TO HOLD A MSG (KEY) AND TRUE (VALUE)
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		
		// RETURN MAP INSIDE RESPONSE ENTITY
		return ResponseEntity.ok(response);
	}
	
}
