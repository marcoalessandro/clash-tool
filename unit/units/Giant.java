package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;



public class Giant extends StandardUnit {
	private final int[] unitCost = {250,750,1250,1750,2250,3000,3500};
	
	public Giant(DataFileManager dfm) {
		this.setTime(120);
		this.setId(3);
		this.setLevel(dfm.getLevel(this));
		this.setCost(unitCost[this.getLevel() - 1]);
	}
	
	@Override
	public boolean setLevel(int level) {
		try {
			this.level = level;
			this.setCost(unitCost[level - 1]);
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
}