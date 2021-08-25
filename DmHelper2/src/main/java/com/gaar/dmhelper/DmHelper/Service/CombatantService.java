package com.gaar.dmhelper.DmHelper.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaar.dmhelper.DmHelper.DAO.CombatantDAO;
import com.gaar.dmhelper.DmHelper.Model.Action;
import com.gaar.dmhelper.DmHelper.Model.Combatant;
import com.gaar.dmhelper.DmHelper.Model.Pc;

import Exception.ResourceNotFoundException;

@Service
public class CombatantService {

	@Autowired
	private CombatantDAO combatantDAO;
	
	public List<Combatant> findAll() {
		return combatantDAO.findAll();
	}
	
	public Combatant save(Combatant combatant) {
		System.out.println("inside CombatantService save");
		return combatantDAO.saveAndFlush(combatant);
	}
	
	public Combatant findById(Long id) {
		return combatantDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Combatant not "
						+ "found with id: " + id));
	}
	
	public List<Combatant> findByEncounter(Long id) {
		return combatantDAO.findCombatantByEncounterId(id);
//		List<Combatant> allCombatants = combatantDAO.findAll();
//		List<Combatant> encounterCombatants = new LinkedList<Combatant>();
//		
//		for (int i = 0; i < allCombatants.size(); i++) {
//			if (allCombatants.get(i).getEncounterId() == id) {
//				encounterCombatants.add(allCombatants.get(i));
//			}
//		}
//		System.out.println("encounter combatants: " + encounterCombatants);
//		return encounterCombatants;
	}
	
	public List<Combatant> findByEncounterAndSide(Long encounterId, String side) {
		return combatantDAO.findCombatantByEncounterAndSide(encounterId, side);
//		List<Combatant> allCombatants = combatantDAO.findAll();
//		List<Combatant> sideCombatants = new LinkedList<Combatant>();
//
//		for (int i = 0; i < allCombatants.size(); i++) {
//			if (allCombatants.get(i).getSide().equals(side)) {
//				sideCombatants.add(allCombatants.get(i));
//			}
//		}
//		System.out.println(sideCombatants);
//		return sideCombatants;
	}
	
	public Combatant findByEncounterAndChar(Long encounterId, Long charId) {
		return combatantDAO.findCombatantByEncounterAndChar(encounterId, charId).get(0);
//		List<Combatant> allCombatants = combatantDAO.findAll();
//		List<Combatant> encounterCombatants = new LinkedList<Combatant>();
//		Combatant combatant = new Combatant();
//		
//		for (int i = 0; i < allCombatants.size(); i++) {
//			if (allCombatants.get(i).getEncounterId() == encounterId) {
//				encounterCombatants.add(allCombatants.get(i));
//			}
//			
//		}
//		System.out.println(encounterCombatants.size());
//		
//		for (int i = 0; i < encounterCombatants.size(); i++) {
//			if (encounterCombatants.get(i).getCharId() == charId) {
//				combatant = encounterCombatants.get(i);
//			}
//		}
//		System.out.println("encounter+Char = combatant: " + combatant.getId());
//		return combatant;
	}
	
	public void delete(Combatant combatant) {
		combatantDAO.delete(combatant);
	}
	
}
