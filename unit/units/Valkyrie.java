package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.BlackUnit;

public class Valkyrie extends BlackUnit {
	private final int[] unitCost = {70,100,130,160};
	
	public Valkyrie(DataFileManager dfm) {
		this.setTime(480);
		this.setId(13);
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