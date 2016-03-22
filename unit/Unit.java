/**
 * 
 */
package com.boberSoft.android.unit;



/**
 * @author BoberSoft
 *
 */
public abstract class Unit {
	private int cost;
	private int time;
	protected int level;
	private int number;
	private int id;
	
	
	public int getCost() {
		return cost;
	}

	public boolean setCost(int cost) {
		try {
			this.cost = cost;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
	
	public int getTime() {
		return time;
	}

	public boolean setTime(int time) {
		try {
			this.time = time;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
	
	public int getLevel() {
		return level;
	}

	public boolean setLevel(int level) {
		try {
			this.level = level;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}