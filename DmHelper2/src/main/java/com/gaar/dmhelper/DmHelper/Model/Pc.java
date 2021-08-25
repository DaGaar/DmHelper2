package com.gaar.dmhelper.DmHelper.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Pc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//game stats
	private String name;
//	private String race;
//	private String background;
//	private Integer level;
//	private Integer xp;
//	private Integer perceptionMod;
//	private Integer insightMod;
//	private Integer ac;
	private Integer maxHp;
	private Integer currentHp;
//	private Integer initScore;
//	private Integer profBonus;
//	private Integer atkMod;
//	private Integer moveSpeed;
//	private Integer swimSpeed;
//	private Integer climbSpeed;
//	private Integer flySpeed;
	
	
	//attributes
//	private Integer str;
//	private Integer strMod;
//	private Integer dex;
//	private Integer dexMod;
//	private Integer con;
//	private Integer conMod;
//	private Integer wis;
//	private Integer wisMod;
//	private Integer intel;
//	private Integer intMod;
//	private Integer cha;
//	private Integer chaMod;
//	
//	//saving throws
//	private Integer strSave;
//	private Integer dexSave;
//	private Integer conSave;
//	private Integer wisSave;
//	private Integer intSave;
//	private Integer chaSave;
	
	//senses
//	private Integer passivePerc;
//	private Integer passiveInsight;
//	private Integer passiveInvest;
	
	//skills
//	private Integer acrobatics;
//	private Integer animalHandling;
//	private Integer arcana;
//	private Integer athletics;
//	private Integer deception;
//	private Integer history;
//	private Integer insight;
//	private Integer intimidation;
//	private Integer investigation;
//	private Integer medicine;
//	private Integer nature;
//	private Integer perception;
//	private Integer performance;
//	private Integer persuasion;
//	private Integer religion;
//	private Integer slightOfHand;
//	private Integer stealth;
//	private Integer survival;

	//CONSTRUCTORS
	public Pc() {
		super();
	}
		
	public Pc(Long id, String name, Integer maxHp) {
		super();
		this.id = id;
		this.name = name;
		this.maxHp = maxHp;
	}
		
	public Pc(Long id, String name, Integer maxHp, Integer currentHp) {
		super();
		this.id = id;
		this.name = name;
		this.maxHp = maxHp;
		this.currentHp = currentHp;
	}
	

	//GETTERS AND SETTERS

	public Long getId() {
		return id;
	}
	
//	public void setId(Long id) {
//	this.id = id;
//}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}

	public Integer getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(Integer currentHp) {
		this.currentHp = currentHp;
	}

}
