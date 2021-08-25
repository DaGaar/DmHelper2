package com.gaar.dmhelper.DmHelper.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Npc {

	@Id
	private Long id;
	private String name;
	private Double dc;
	private Boolean enemy;
	private Boolean ally;
	private Integer perceptionMod;
	private Integer insightMod;
	private Integer ac;
	private Integer initiative;
	

	
//	@ManyToMany(mappedBy = "npc")
//	private List<EncounterCombat> encounterCombat;
	
//	@OneToMany(mappedBy = "npc")
//	private List<EncounterCombat> encounterCombat;

	//CONSTRUCTORS
	public Npc() {
		super();
	}
	
//	public Npc(Long id, String name, Double dc, Boolean enemy, Boolean ally, Integer perceptionMod, Integer insightMod,
//			Integer ac, Integer initiative, List<EncounterCombat> encounterCombat) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dc = dc;
//		this.enemy = enemy;
//		this.ally = ally;
//		this.perceptionMod = perceptionMod;
//		this.insightMod = insightMod;
//		this.ac = ac;
//		this.initiative = initiative;
//		this.encounterCombat = encounterCombat;
//	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDc() {
		return dc;
	}

	public void setDc(Double dc) {
		this.dc = dc;
	}

	public Boolean getEnemy() {
		return enemy;
	}

	public void setEnemy(Boolean enemy) {
		this.enemy = enemy;
	}

	public Boolean getAlly() {
		return ally;
	}

	public void setAlly(Boolean ally) {
		this.ally = ally;
	}

	public Integer getPerceptionMod() {
		return perceptionMod;
	}

	public void setPerceptionMod(Integer perceptionMod) {
		this.perceptionMod = perceptionMod;
	}

	public Integer getInsightMod() {
		return insightMod;
	}

	public void setInsightMod(Integer insightMod) {
		this.insightMod = insightMod;
	}

	public Integer getAc() {
		return ac;
	}

	public void setAc(Integer ac) {
		this.ac = ac;
	}

	public Integer getInitiative() {
		return initiative;
	}

	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}

//	public List<EncounterCombat> getEncounterCombat() {
//		return encounterCombat;
//	}
//
//	public void setEncounterCombat(List<EncounterCombat> encounterCombat) {
//		this.encounterCombat = encounterCombat;
//	}

	
	@Override
	public String toString() {
		return "Npc [id=" + id + ", name=" + name + ", dc=" + dc + ", enemy=" + enemy + ", ally=" + ally
				+ ", perceptionMod=" + perceptionMod + ", insightMod=" + insightMod + ", ac=" + ac + ", initiative="
				+ initiative + "]";
	}
	
	
}
