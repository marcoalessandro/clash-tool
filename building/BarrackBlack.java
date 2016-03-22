package com.boberSoft.android.building;

public class BarrackBlack extends Barrack {
	/*
	 * Black unit count
	 */
	private static final int UNIT_COUNT = 6;
	

	
	private int[] unitCapacityPerLevel = {40, 50, 60, 70, 80, 90};
	
	public BarrackBlack(int id, int level) {
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
		unitEnabled = new boolean[UNIT_COUNT];
		for (int i = 0; i < UNIT_COUNT; i++)
			unitEnabled[i] = false;
	}

	private void updateEnabledUnits() {
		for (int i = 0; i < level; i++) {
			unitEnabled[i] = true;
		}
	}
}