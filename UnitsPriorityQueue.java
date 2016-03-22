package com.boberSoft.android;
import java.util.Vector;

import com.boberSoft.android.unit.Unit;
public class UnitsPriorityQueue {

	private Vector<Unit> unitsQueue = new Vector<Unit>() ;
	
	
	 /*
	  * create a new UnitsPriorityQueue from an Units Array
	  * do the insertion sort of the array
	  * copy the ordered array in a vector
	  */
	
	public UnitsPriorityQueue(Unit[] toBuildUnits) {
		insertionSort(toBuildUnits);
		for(int i=0 ; i<toBuildUnits.length ; i++){
			if(toBuildUnits[i].getNumber() > 0){
				unitsQueue.add(toBuildUnits[i]);
			}
		}
	}

	
	private void insertionSort(Unit[] toBuildUnits) {
		for(int j=1 ; j<toBuildUnits.length ; j++){
			int key = toBuildUnits[j].getTime();
			int i=j-1;
			while(i>0 && toBuildUnits[i].getTime()<key){
				toBuildUnits[i+1] = toBuildUnits[i];
				i=i-1;
			}
			toBuildUnits[i+1] = toBuildUnits[j]; 
		}
	}
		
/*
 * return the Unit with max production time
 * remove the object
 */
	public Unit pull(){
		Unit out = unitsQueue.firstElement();
		unitsQueue.remove(out);
		return out;
	}

	
	
	
}
		
		
