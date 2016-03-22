package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;




public class Balloon extends StandardUnit {
	private final int[] unitCost = {2000,2500,3000,3500,4000,4500};

	public Balloon(DataFileManager dfm) {
		this.setTime(480);
		this.setId(6);
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