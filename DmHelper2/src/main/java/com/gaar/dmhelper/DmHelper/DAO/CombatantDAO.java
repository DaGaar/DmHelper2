package com.gaar.dmhelper.DmHelper.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gaar.dmhelper.DmHelper.Model.Combatant;

public interface CombatantDAO extends JpaRepository<Combatant, Long> {

	@Query("SELECT c FROM combatant c WHERE c.encounterId=?1")
	List<Combatant> findCombatantByEncounterId(Long encounterId);
	
	@Query("SELECT c FROM combatant c WHERE c.encounterId=?1 AND c.side=?2")
	List<Combatant> findCombatantByEncounterAndSide(Long encounterId, String side);
	
	@Query("SELECT c FROM combatant c WHERE c.encounterId=?1 AND c.charId=?2")
	List<Combatant> findCombatantByEncounterAndChar(Long encounterId, Long charId);
	
}
