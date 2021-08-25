package com.gaar.dmhelper.DmHelper.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
//	private Long[] combatantIds;
//	private Long[] actions;
//	private Integer dificulty;
//	private Integer xp;
//	private Integer numOfPcs;
//	private Integer numOfEnemies;
//	private Integer numOfAllies;
//	private Integer totalDmgDone;
	//variable to track length of combat
	//variable to track average turn length
	//variable to track average npc turn length
	//variable to track average specific pc turn length
	
	//TODO: track individual pc stats for individual encounter
	
	//make input boolean to show ally/enemy?
	
//	@ManyToMany
//	private List<Npc> npc;
//	@ManyToOne()
//	private Npc npc;
	

	
//	@ManyToMany
//	private List<Pc> pc;
//	@ManyToOne()
//	private Pc pc;
		
	//CONSTRUCTORS
	public Encounter() {
		super();
	}
	
public Encounter(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
//	this.combatantIds = combatantIds;
//	this.actions = actions;
	
}

//	public EncounterCombat(Long id, String name, Integer dificulty, Integer xp, Integer numOfPcs, Integer numOfEnemies,
//			Integer numOfAllies, Integer totalDmgDone, List<Npc> npc, List<Pc> pc) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dificulty = dificulty;
//		this.xp = xp;
//		this.numOfPcs = numOfPcs;
//		this.numOfEnemies = numOfEnemies;
//		this.numOfAllies = numOfAllies;
//		this.totalDmgDone = totalDmgDone;
//		this.npc = npc;
//		this.pc = pc;
//	}

//	public EncounterCombat(Long id, String name, Integer dificulty, Npc npcs, Pc pcs) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dificulty = dificulty;
//		this.npcs = npcs;
//		this.pcs = pcs;
//	}
	
//	public Encounter(Long id, String name, List<Pc> pc) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.pc = pc;
//	}



	//GETTERS AND SETTERS


//	public Integer getXp() {
//		return xp;
//	}
//
//	public void setXp(Integer xp) {
//		this.xp = xp;
//	}
//
//	public Integer getNumOfPcs() {
//		return numOfPcs;
//	}
//
//	public void setNumOfPcs(Integer numOfPcs) {
//		this.numOfPcs = numOfPcs;
//	}
//
//	public Integer getNumOfEnemies() {
//		return numOfEnemies;
//	}
//
//	public void setNumOfEnemies(Integer numOfEnemies) {
//		this.numOfEnemies = numOfEnemies;
//	}
//
//	public Integer getNumOfAllies() {
//		return numOfAllies;
//	}
//
//	public void setNumOfAllies(Integer numOfAllies) {
//		this.numOfAllies = numOfAllies;
//	}
//
//	public Integer getTotalDmgDone() {
//		return totalDmgDone;
//	}
//
//	public void setTotalDmgDone(Integer totalDmgDone) {
//		this.totalDmgDone = totalDmgDone;
//	}

//	public Npc getNpc() {
//		return npc;
//	}
//
//	public void setNpcs(Npc npc) {
//		this.npc = npc;
//	}
//
//	public Pc getPc() {
//		return pc;
//	}
//
//	public void setPcs(Pc pc) {
//		this.pc = pc;
//	}
	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Long[] getCombatantIds() {
//		return combatantIds;
//	}
//
//	public void setCombatantIds(Long[] combatantIds) {
//		this.combatantIds = combatantIds;
//	}
//
//	public Long[] getActions() {
//		return actions;
//	}
//
//	public void setActions(Long[] actions) {
//		this.actions = actions;
//	}
	
	

//	public Integer getDificulty() {
//		return dificulty;
//	}
//
//	public void setDificulty(Integer dificulty) {
//		this.dificulty = dificulty;
//	}
//
//	public List<Npc> getNpc() {
//		return npc;
//	}
//
//	public void setNpc(List<Npc> npc) {
//		this.npc = npc;
//	}

//	public List<Pc> getPc() {
//		return pc;
//	}
//
//	public void setPc(List<Pc> pc) {
//		this.pc = pc;
//	}

	
	
//	@Override
//	public String toString() {
//		return "EncounterCombat [id=" + id + ", name=" + name + ", dificulty=" + dificulty + ", npcs=" + npcs + ", pcs="
//				+ pcs + "]";
//	}

}
