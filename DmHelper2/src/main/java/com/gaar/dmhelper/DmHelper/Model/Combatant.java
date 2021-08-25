package com.gaar.dmhelper.DmHelper.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="combatant")
public class Combatant {
	
	//LOCAL VARS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long charId;
	private String side;
	private Double initiative;
	private Long encounterId;
	
	//CONSTRUCTORS	
	public Combatant() {
		super();
	}
	
	public Combatant(Long id, Long charId, String side, Double initiative, Long encounterId) {
		super();
		this.id = id;
		this.charId = id;
		this.side = side;
		this.initiative = initiative;
		this.encounterId = encounterId;
	}

	//GETTERS AND SETTERS
	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public Double getInitiative() {
		return initiative;
	}

	public void setInitiative(Double initiative) {
		this.initiative = initiative;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
	
	public Long getId() {
		return id;
	}
	
//	public void setId(Long id) {
//		this.id = id;
//	}
		
	public Long getCharId() {
		return charId;
	}
	
	public void setcharId(Long charId) {
		this.charId = charId;
	}

}
