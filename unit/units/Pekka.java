package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;

public class Pekka extends StandardUnit {
	private final int[] unitCost = {28000,32000,36000,40000,45000};
	
	public Pekka(DataFileManager dfm) {
		this.setTime(2700);
		this.setId(10);
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