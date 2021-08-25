package com.gaar.dmhelper.DmHelper.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {

	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long encounterId;
	
	private Long attackerId;
	private Long attackedId;
	private Integer dmgDone;
	private String effect;
	private String type;
	
	//CONSTRUCTORS
	public Action() {
		super();
	}

	public Action(Long id, Long encounterId, Long attackerId, 
			Long attackedId, Integer dmgDone) {
		super();
		this.id = id;
		this.encounterId = encounterId;
		this.attackerId = attackerId;
		this.attackedId = attackedId;
		this.dmgDone = dmgDone;
	}

public Action(Long id, Long encounterId, Long attackerId, Long attackedId, Integer dmgDone, String effect, String type) {
	super();
	this.id = id;
	this.encounterId = encounterId;
	this.attackerId = attackerId;
	this.attackedId = attackedId;
	this.dmgDone = dmgDone;
	this.effect = effect;
	this.type = type;
}

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getAttackerId() {
		return attackerId;
	}

	public void setAttackerId(Long attackerId) {
		this.attackerId = attackerId;
	}

	public Long getAttackedId() {
		return attackedId;
	}

	public void setAttackedId(Long attackedId) {
		this.attackedId = attackedId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Integer getDmgDone() {
		return dmgDone;
	}

	public void setDmgDone(Integer dmgDone) {
		this.dmgDone = dmgDone;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
}
