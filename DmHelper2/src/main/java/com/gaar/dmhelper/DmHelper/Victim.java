package com.gaar.dmhelper.DmHelper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gaar.dmhelper.DmHelper.Model.Action;

@Entity
public class Victim {
	
	//vars
	@Id
	private Long id;
	private Long atkedId;
	private Integer dmg;
	private String effect;
	
//	@ManyToOne()
//	private Action action;
	
	//CONSTRUCTORS 
	public Victim() {
		super();
	}
	
	public Victim(Long atkedId, Integer dmg, String effect) {
		super();
		this.atkedId = atkedId;
		this.dmg = dmg;
		this.effect = effect;
	}
	
	//GETTERS AND SETTERS
	public Long getAtkedId() {
		return atkedId;
	}

	public void setAtkedId(Long atkedId) {
		this.atkedId = atkedId;
	}

	public Integer getDmg() {
		return dmg;
	}

	public void setDmg(Integer dmg) {
		this.dmg = dmg;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
}
