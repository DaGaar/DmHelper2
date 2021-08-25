package com.gaar.dmhelper.DmHelper.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


//import com.gaar.dmhelper.DmHelper.Model.EncounterCombat;

@Entity

public class Pc {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//game stats
	private String name;
	private String race;
	private String background;
	private Integer level;
	private Integer xp;
	private Integer perceptionMod;
	private Integer insightMod;
	private Integer ac;
	private Integer maxHp;
	private Integer currentHp;
	private Integer initScore;
	private Integer profBonus;
	private Integer atkMod;
	private Integer moveSpeed;
	private Integer swimSpeed;
	private Integer climbSpeed;
	private Integer flySpeed;
	
	
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
	private Integer passivePerc;
	private Integer passiveInsight;
	private Integer passiveInvest;
	
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
	
	//brag stats
//	private Integer totalAtks;
//	private Integer totalAtksTaken;
//	private Integer totalTimesAtked;
//	private Integer totalHitsTaken;
//	private Integer totalHitsDodged;
//	private Integer totalCrits;
//	private Integer totalCritFails;
//	private Integer totalMassiveDmgs;
//	private Integer timesGoneDown;
//	private Integer totalHits;
//	private Integer totalMisses;
//	private Integer totalDmgDone;
//	private Integer totalDmgTaken;
//	private Integer totalCombats;
//	private Integer totalKills;
		
//	@OneToMany(mappedBy = "pc")
//	@OneToMany(mappedBy = "pc")
//	private List<EncounterCombat> encounterCombat;
	
//	@ManyToMany(mappedBy = "pc")
//	private List<Encounter> encounter;
	
	private Long[] encounterIds;
	
	private Long party;
	
	
//	@OneToMany
//	private List<Action> actions;

	//CONSTRUCTORS
	public Pc() {
		super();
	}
	
//	public Pc(Long id, String name, String race, String background, Integer level, Integer xp, Integer perceptionMod,
//			Integer insightMod, Integer ac, Integer maxHp, Integer currentHp, Integer initiative, Integer profBonus,
//			Integer atkMod, Integer moveSpeed, Integer swimSpeed, Integer climbSpeed, Integer flySpeed,
//			Integer passivePerc, Integer passiveInsight, Integer passiveInvest, List<Encounter> encounter) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.race = race;
//		this.background = background;
//		this.level = level;
//		this.xp = xp;
//		this.perceptionMod = perceptionMod;
//		this.insightMod = insightMod;
//		this.ac = ac;
//		this.maxHp = maxHp;
//		this.currentHp = currentHp;
//		this.initiative = initiative;
//		this.profBonus = profBonus;
//		this.atkMod = atkMod;
//		this.moveSpeed = moveSpeed;
//		this.swimSpeed = swimSpeed;
//		this.climbSpeed = climbSpeed;
//		this.flySpeed = flySpeed;
//		this.passivePerc = passivePerc;
//		this.passiveInsight = passiveInsight;
//		this.passiveInvest = passiveInvest;
//		this.encounter = encounter;
//	}
	
	
	
	public Pc(Long id, String name, Integer level, Integer perceptionMod, Integer insightMod, Integer ac, Integer maxHp,
			Integer initScore) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.perceptionMod = perceptionMod;
		this.insightMod = insightMod;
		this.ac = ac;
		this.maxHp = maxHp;
		this.initScore = initScore;
	}
	
//	public Pc(Long id, String name, String race, String background, Integer level, Integer xp, Integer perceptionMod,
//			Integer insightMod, Integer ac, Integer maxHp, Integer currentHp, Integer initiative, Integer profBonus,
//			Integer atkMod, Integer moveSpeed, Integer swimSpeed, Integer climbSpeed, Integer flySpeed,
//			Integer passivePerc, Integer passiveInsight, Integer passiveInvest, List<Encounter> encounter,
//			Long party) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.race = race;
//		this.background = background;
//		this.level = level;
//		this.xp = xp;
//		this.perceptionMod = perceptionMod;
//		this.insightMod = insightMod;
//		this.ac = ac;
//		this.maxHp = maxHp;
//		this.currentHp = currentHp;
//		this.initiative = initiative;
//		this.profBonus = profBonus;
//		this.atkMod = atkMod;
//		this.moveSpeed = moveSpeed;
//		this.swimSpeed = swimSpeed;
//		this.climbSpeed = climbSpeed;
//		this.flySpeed = flySpeed;
//		this.passivePerc = passivePerc;
//		this.passiveInsight = passiveInsight;
//		this.passiveInvest = passiveInvest;
//		this.encounter = encounter;
//		this.party = party;
//	}	

	
	
	public Pc(Long id, String name, String race, String background, Integer level, Integer xp, Integer perceptionMod,
			Integer insightMod, Integer ac, Integer maxHp, Integer currentHp, Integer initScore, Integer profBonus,
			Integer atkMod, Integer moveSpeed, Integer swimSpeed, Integer climbSpeed, Integer flySpeed,
			Integer passivePerc, Integer passiveInsight, Integer passiveInvest, Long[] encounterIds, Long party) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.background = background;
		this.level = level;
		this.xp = xp;
		this.perceptionMod = perceptionMod;
		this.insightMod = insightMod;
		this.ac = ac;
		this.maxHp = maxHp;
		this.currentHp = currentHp;
		this.initScore = initScore;
		this.profBonus = profBonus;
		this.atkMod = atkMod;
		this.moveSpeed = moveSpeed;
		this.swimSpeed = swimSpeed;
		this.climbSpeed = climbSpeed;
		this.flySpeed = flySpeed;
		this.passivePerc = passivePerc;
		this.passiveInsight = passiveInsight;
		this.passiveInvest = passiveInvest;
		this.encounterIds = encounterIds;
		this.party = party;
	}
	
	


	//GETTERS AND SETTERS

	public Long getParty() {
		return party;
	}

	public void setParty(Long party) {
		this.party = party;
	}

	public Long getId() {
		return id;
	}
	
//	public void setId(Long id) {
//	this.id = id;
//}

	public void setPassiveInvest(Integer passiveInvest) {
		this.passiveInvest = passiveInvest;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public Integer getProfBonus() {
		return profBonus;
	}

	public void setProfBonus(Integer profBonus) {
		this.profBonus = profBonus;
	}

	public Integer getAtkMod() {
		return atkMod;
	}

	public void setAtkMod(Integer atkMod) {
		this.atkMod = atkMod;
	}

	public Integer getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(Integer moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public Integer getSwimSpeed() {
		return swimSpeed;
	}

	public void setSwimSpeed(Integer swimSpeed) {
		this.swimSpeed = swimSpeed;
	}

	public Integer getClimbSpeed() {
		return climbSpeed;
	}

	public void setClimbSpeed(Integer climbSpeed) {
		this.climbSpeed = climbSpeed;
	}

	public Integer getFlySpeed() {
		return flySpeed;
	}

	public void setFlySpeed(Integer flySpeed) {
		this.flySpeed = flySpeed;
	}

	public Integer getPassivePerc() {
		return passivePerc;
	}

	public void setPassivePerc(Integer passivePerc) {
		this.passivePerc = passivePerc;
	}

	public Integer getPassiveInsight() {
		return passiveInsight;
	}

	public void setPassiveInsight(Integer passiveInsight) {
		this.passiveInsight = passiveInsight;
	}

	public Integer getPassiveInvest() {
		return passiveInvest;
	}

	public void setPassiveInvest(int passiveInvest) {
		this.passiveInvest = passiveInvest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public Integer getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}

	public Integer getInitScore() {
		return initScore;
	}

	public void setInitScore(Integer initScore) {
		this.initScore = initScore;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public Integer getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(Integer currentHp) {
		this.currentHp = currentHp;
	}

	public Long[] getEncounterIds() {
		return encounterIds;
	}

	public void setEncounterIds(Long[] encounterIds) {
		this.encounterIds = encounterIds;
	}

	
}
