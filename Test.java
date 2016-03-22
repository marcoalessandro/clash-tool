package com.boberSoft.android;

import com.boberSoft.android.building.Barrack;
import com.boberSoft.android.building.BarrackNormal;


public class Test {
	
	public static void main(String args[]){
		DataFileManager dfm = new DataFileManager();
		
		Barrack barrack = new BarrackNormal(2 , 6);
		System.out.println(dfm.getBarrackLevel(barrack));
		
		
		
		//System.out.println(dfm.getLevel(new Archer(dfm)));
		
		//MainActivity mainAct = new MainActivity();
		
		//ArmyCamp armyCamp = new ArmyCamp(dfm);
		

	/*
	
	public static void main(String[] args) {
		
		DataFileManager dfm = new DataFileManager();
		MainActivity mainRiven = new MainActivity();
		
		ArmyCamp armyCamp = new ArmyCamp(dfm);
		
	
		for(int i=0; i<mainRiven.getToBuildUnit().length; i++) {
			System.out.println(mainRiven.getToBuildUnit()[i].getLevel());
			mainRiven.getToBuildUnit()[i].setNumber(1);
		}
		
		System.out.println(Arrays.toString(mainRiven.standardTroopsCost()));
		
		for(int i=0; i<mainRiven.getToBuildUnit().length; i++) {
			mainRiven.getToBuildUnit()[i].setLevel(mainRiven.getToBuildUnit()[i].getLevel() + 1);
			System.out.println(mainRiven.getToBuildUnit()[i].getLevel());
			mainRiven.getToBuildUnit()[i].setNumber(1);
		}
		
		System.out.println(Arrays.toString(mainRiven.standardTroopsCost()));
		*/
	}

}
