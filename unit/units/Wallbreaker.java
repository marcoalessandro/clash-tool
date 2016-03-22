package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;

public class Wallbreaker extends StandardUnit {
	private final int[] unitCost = {1000,1500,2000,2500,3000,3500};
	
	public Wallbreaker(DataFileManager dfm) {
		this.setTime(120);
		this.setId(5);
		this.setLevel(dfm.getLevel(this));
		this.setCost(unitCost[this.getLevel() - 1]);
			
	}
	
	@Override
	public boolean setLevel(int level) {
		try {
			this.level = level;
			this.setCost(unitCost[level]);
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
}