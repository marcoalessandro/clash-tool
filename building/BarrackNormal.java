package com.boberSoft.android.building;

public class BarrackNormal extends Barrack {
	/*
	 * Normal units count
	 */
	private static final int UNIT_COUNT = 10;
	

	private int[] unitCapacityPerLevel = {20, 25, 30, 35, 40, 45, 50, 55, 60, 75};
	
	public BarrackNormal(int id, int level) {
		this.id = id;
		this.level = level;
		/*
		 * Units id are the indices
		 * TRUE for enabled ___ FALSE for disabled
		 */
		unitEnabled = new boolean[UNIT_COUNT];
		
		initializeEnabledUnits();
		unitCapacity = unitCapacityPerLevel[level - 1];
		
		updateEnabledUnits();
	}

	private void initializeEnabledUnits() {
		for (int i = 0; i < UNIT_COUNT; i++)
			unitEnabled[i] = false;
	}

	private void updateEnabledUnits() {
		for (int i = 0; i < level; i++) {
			unitEnabled[i] = true;
		}
	}
}