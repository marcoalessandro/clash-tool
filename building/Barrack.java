package com.boberSoft.android.building;

import com.boberSoft.android.unit.*;

public abstract class Barrack {
	protected int level;
	private boolean enabled;
	private Unit[] unit;
	protected int id;
	protected int unitCapacity;
	
	/*
	 * Total unit count
	 */
	private static final int UNIT_COUNT = 16;
	
	/*
	 * Units id are the indices
	 * TRUE for enabled ___ FALSE for disabled
	 */
	protected boolean[] unitEnabled;
	
	public boolean[] getEnabledUnits() {
		return unitEnabled;
	}
	
	public int getLevel() {
		return level ;
	}

	public boolean isEnabled() {
		return enabled ;
	}

	public Unit[] getUnit() {
		return unit ;
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

	public boolean setEnabled(boolean enabled) {
		try{
			this.enabled = enabled;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}

	public int getId() {
		return id;
	}
}