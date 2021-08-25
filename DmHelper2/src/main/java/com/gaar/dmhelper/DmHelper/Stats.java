package com.gaar.dmhelper.DmHelper;

public class Stats {

	//vars
	private int atkOut = 0;
	private int atkIn = 0;
	private int hitOut = 0;
	private int hitIn = 0;
	private int missOut = 0;
	private int missIn = 0;
	private int dmgOut = 0;
	private int dmgIn = 0;
	private double hitPercent = 0;
	private double missPercent = 0;
	private double getHitPercent = 0;
	private double getMissedPercent = 0;
	
	
	
	public Stats(int atkOut, int atkIn, int hitOut, int hitIn, int missOut, int missIn, int dmgOut, int dmgIn,
			double hitPercent, double missPercent, double getHitPercent, double getMissedPercent) {
		super();
		this.atkOut = atkOut;
		this.atkIn = atkIn;
		this.hitOut = hitOut;
		this.hitIn = hitIn;
		this.missOut = missOut;
		this.missIn = missIn;
		this.dmgOut = dmgOut;
		this.dmgIn = dmgIn;
		this.hitPercent = hitPercent;
		this.missPercent = missPercent;
		this.getHitPercent = getHitPercent;
		this.getMissedPercent = getMissedPercent;
	}
	
	//GETTERS AND SETTERS
	public int getAtkOut() {
		return atkOut;
	}
	public void setAtkOut(int atkOut) {
		this.atkOut = atkOut;
	}
	public int getAtkIn() {
		return atkIn;
	}
	public void setAtkIn(int atkIn) {
		this.atkIn = atkIn;
	}
	public int getHitOut() {
		return hitOut;
	}
	public void setHitOut(int hitOut) {
		this.hitOut = hitOut;
	}
	public int getHitIn() {
		return hitIn;
	}
	public void setHitIn(int hitIn) {
		this.hitIn = hitIn;
	}
	public int getMissOut() {
		return missOut;
	}
	public void setMissOut(int missOut) {
		this.missOut = missOut;
	}
	public int getMissIn() {
		return missIn;
	}
	public void setMissIn(int missIn) {
		this.missIn = missIn;
	}
	public int getDmgOut() {
		return dmgOut;
	}
	public void setDmgOut(int dmgOut) {
		this.dmgOut = dmgOut;
	}
	public int getDmgIn() {
		return dmgIn;
	}
	public void setDmgIn(int dmgIn) {
		this.dmgIn = dmgIn;
	}
	public double getHitPercent() {
		return hitPercent;
	}
	public void setHitPercent(double hitPercent) {
		this.hitPercent = hitPercent;
	}
	public double getMissPercent() {
		return missPercent;
	}
	public void setMissPercent(double missPercent) {
		this.missPercent = missPercent;
	}
	public double getGetHitPercent() {
		return getHitPercent;
	}
	public void setGetHitPercent(double getHitPercent) {
		this.getHitPercent = getHitPercent;
	}
	public double getGetMissedPercent() {
		return getMissedPercent;
	}
	public void setGetMissedPercent(double getMissedPercent) {
		this.getMissedPercent = getMissedPercent;
	}
	
}
