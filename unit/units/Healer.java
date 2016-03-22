package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;

public class Healer extends StandardUnit {
	private final int[] unitCost =  {5000,6000,8000,10000};
	
	public Healer(DataFileManager dfm) {
		this.setTime(900);
		this.setId(8);
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