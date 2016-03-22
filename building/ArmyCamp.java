package com.boberSoft.android.building;

import com.boberSoft.android.DataFileManager;

public class ArmyCamp {
	
	private int totalSlots;
	private int occupiedSlots;

	public ArmyCamp(DataFileManager dfm) {
		this.setTotalSlots(dfm.getArmySlots());
		System.out.println(totalSlots);
	}
	
	public int getTotalSlots(){
		return this.totalSlots;
	}
	
	public boolean setTotalSlots(int totalslots){
		try{
			this.totalSlots = totalslots;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
		
	public int getOccupiedSlots(){
		return this.occupiedSlots;
	}
		
	public boolean setOccupiedSlots(int occupiedslots){
		try{
			this.occupiedSlots = occupiedslots;
			return true;
		} catch (Exception e) {
			System.out.println("The application encountered an error.");
			return false;
		}
	}
		
	public int getFreeSlots(){
		return (totalSlots - occupiedSlots);
	}
	
}