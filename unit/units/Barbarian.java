/**
 * 
 */
package com.boberSoft.android.unit.units;

import com.boberSoft.android.DataFileManager;
import com.boberSoft.android.unit.StandardUnit;

/**
 * @author macom
 *
 */
public class Barbarian extends StandardUnit {
	private final int[] unitCost = {25, 40, 60, 100, 150, 200, 250};
	
	public Barbarian(DataFileManager dfm) {
		this.setTime(20);
		this.setId(1);
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