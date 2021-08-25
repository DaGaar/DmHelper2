package com.gaar.dmhelper.DmHelper.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaar.dmhelper.DmHelper.Stats;
import com.gaar.dmhelper.DmHelper.DAO.CombatantDAO;
import com.gaar.dmhelper.DmHelper.DAO.PcDAO;
import com.gaar.dmhelper.DmHelper.Model.Action;
import com.gaar.dmhelper.DmHelper.Model.Combatant;
import com.gaar.dmhelper.DmHelper.Service.ActionService;
import com.gaar.dmhelper.DmHelper.Model.Pc;

import Exception.ResourceNotFoundException;


@Service
public class PcService {

	@Autowired
	private PcDAO pcDAO;
	@Autowired
	private ActionService actionService;
	@Autowired
	private CombatantDAO combatantDAO;
	
//	@Autowired
//	private Actions actions;
	
	public List<Pc> findAll() {
		System.out.println("inside PcService findAllmethod");
		return pcDAO.findAll();
	}
	
	public Pc save(Pc pc) {
		System.out.println("inside PcService saveAndFLush");
		return pcDAO.saveAndFlush(pc);
	}
	
	public List<Pc> getParty(Long partyId) {
		List<Pc> party = new LinkedList<Pc>();
		List<Pc> allPcs = findAll();
		for (int i = 0; i < allPcs.size(); i++) {
			if (partyId == allPcs.get(i).getParty()) {
				party.add(allPcs.get(i));			
			}
		}
		return party;
	}
	
	public Pc findById(Long id) {
		return pcDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pc not "
						+ "found with id: " + id));
	}
	
	public List<Pc> findByEncounterId(Long id) {
		List<Combatant> allCombatants = combatantDAO.findAll();
		List<Pc> encounterPcs = new LinkedList<Pc>();
		
		for (int i = 0; i < allCombatants.size(); i++) {
			if (allCombatants.get(i).getEncounterId() == id) {			
				encounterPcs.add(findById(allCombatants.get(i).getCharId()));
			}
		}		
		return encounterPcs;
	}
	
	public Stats genStats(Long id) {

		//LOCAL VARS
		int atkOut = 0;
		int atkIn = 0;
		int hitOut = 0;
		int hitIn = 0;
		int missOut = 0;
		int missIn = 0;
		int dmgOut = 0;
		int dmgIn = 0;
//		double hitPercent = 0.0;
//		double missPercent = 0.0;
//		double getHitPercent = 0.0;
//		double getMissedPercent = 0.0;
	
		List<Action> actionsOut = actionService.findByAttackerId(id);
		List<Action> actionsIn = actionService.findByAttackedId(id);	
		
		//GENERATE OUTWARD STATS
		for (Integer i = 0; i < actionsOut.size(); i++) {
			atkOut++;
			if (actionsOut.get(i).getDmgDone() != 0) { hitOut++; }
				else { missOut++; }
			dmgOut += actionsOut.get(i).getDmgDone();
		}
		double hitPercent = (double) hitOut / (double) atkOut;
		hitPercent = hitPercent * 100;
		double missPercent = (double) missOut / (double) atkOut;
		missPercent = missPercent * 100;
		
		//GENERATE INWARD STATS
		for (int i = 0; i < actionsIn.size(); i++) {
			atkIn++;
			if (actionsIn.get(i).getDmgDone() != 0) { hitIn++; }
				else { missIn++; }
			dmgIn += actionsIn.get(i).getDmgDone();
		}
		double getHitPercent = ((double) hitIn/(double) atkIn)*100.0;
		//getHitPercent = getHitPercent*100.0;
		double getMissedPercent = (double) missIn / (double) atkIn;
		getMissedPercent = getMissedPercent*100;
		
		//COLLECT AND RETURN STATS
		Stats stats = new Stats(atkOut, atkIn, hitOut, hitIn, missOut, 
				missIn, dmgOut, dmgIn, hitPercent, missPercent, getHitPercent, 
				getMissedPercent);
		System.out.println(atkOut);
		return stats;
	}
	
	public void delete(Pc pc) {
		pcDAO.delete(pc);
	}
	//TODO
//	public int getDmgTaken(Pc pc) {
//		int dmgTaken = 0;
//		List<Action> actions = pc.getActions();
//		//long id = pc.getId();
//		for (int i = 0; i < actions.size(); i++) {
//		//	long attackedId = actions.get(i).getAttacked().getId();
//			if (pc.getId() == actions.get(i).getAttacked().getId()) {
//				dmgTaken += actions.get(i).getDmgDone();
//			}
//		}
//		return dmgTaken;
//	}


}
