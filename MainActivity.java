package com.boberSoft.android;

import com.boberSoft.android.unit.StandardUnit;
import com.boberSoft.android.unit.Unit;
import com.boberSoft.android.unit.units.*;

public class MainActivity {
	
	
	private Unit[] toBuildUnit;
	DataFileManager dfm = new DataFileManager();

	
	public MainActivity() {
		toBuildUnit = new Unit[16];
		inizializeUnits();
	}
	
	
	public Unit[] getToBuildUnit() {
		return toBuildUnit;
	}


	public void setToBuildUnit(Unit[] toBuildUnit) {
		this.toBuildUnit = toBuildUnit;
	}


	public int[] standardTroopsCost(){
		int[] totalCosts = new int[2];
		for (int i = 0; i<toBuildUnit.length; i++){
			if (toBuildUnit[i] instanceof StandardUnit){
				totalCosts[0] = totalCosts[0] + toBuildUnit[i].getCost() * toBuildUnit[i].getNumber();
			} else {
				totalCosts[1] = totalCosts[1] + toBuildUnit[i].getCost() * toBuildUnit[i].getNumber();
			}
		}
		return totalCosts;
	}
	

	private void inizializeUnits(){
		toBuildUnit[0] = new Barbarian(dfm);
		toBuildUnit[1] = new Archer(dfm);
		toBuildUnit[2] = new Giant(dfm);
		toBuildUnit[3] = new Goblin(dfm);
		toBuildUnit[4] = new Wallbreaker(dfm);
		toBuildUnit[5] = new Balloon(dfm);
		toBuildUnit[6] = new Wizard(dfm);
		toBuildUnit[7] = new Healer(dfm);
		toBuildUnit[8] = new Dragon(dfm);
		toBuildUnit[9] = new Pekka(dfm);
		toBuildUnit[10] = new Minion(dfm);
		toBuildUnit[11] = new HogRider(dfm);
		toBuildUnit[12] = new Valkyrie(dfm);
		toBuildUnit[13] = new Golem(dfm);
		toBuildUnit[14] = new Witch(dfm);
		toBuildUnit[15] = new LavaHound(dfm);		
	}
}
