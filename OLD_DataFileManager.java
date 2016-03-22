package com.boberSoft.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.boberSoft.android.building.Barrack;
import com.boberSoft.android.unit.Unit;

public class DataFileManager {
	private String fileNameL = "src/com/boberSoft/android/assets/resources/DefaultUnitLevel.txt";
	private String fileNameB = "src/com/boberSoft/android/assets/resources/buildingsSettings.txt";
	private int armySlots;
	public int[] level;
	private int[][] barracksData;

	public DataFileManager() {
		level = new int[16];
		barracksData = new int[6][2];
		updateLevels();
		updateArmyBarracks();
	}

	public int getLevel(Unit unit) {
		System.out.println("level: "+level[unit.getId() - 1]);
		return level[unit.getId() - 1];
	}
	
	public int getArmySlots() {
		return armySlots;
	}
	
	private void updateLevels() {
		explode(readLevels(), "#");
	}
	
	private void updateArmyBarracks() {
		readBarracks();
	}
	
	private String readLevels() {
		try {
			FileReader fReader = new FileReader(fileNameL);
			BufferedReader reader = new BufferedReader(fReader);

			String levels = reader.readLine();
			
			reader.close();
			fReader.close();

			return levels;
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open the file '"+fileNameL+"'");
		} catch(IOException ex) {
			System.out.println("Error reading the file '"+fileNameL+"'");
		}

		return null;
	}

	public void setLevel(Unit unit, int newLevel) {
		try {
			FileWriter fWriter = new FileWriter(fileNameL);
			BufferedWriter writer = new BufferedWriter(fWriter);

			level[unit.getId() - 1] = newLevel;
			writer.write(implode(level));

			writer.close();
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open the file '"+fileNameL+"'");
		} catch(IOException ex) {
			System.out.println("Error reading the file '"+fileNameL+"'");
		}
	}

	private void readBarracks() {
		try {
			FileReader fReader = new FileReader(fileNameB);
			BufferedReader reader = new BufferedReader(fReader);
			// first row, indicates the number of army slots available
			armySlots = Integer.parseInt(reader.readLine());
			String[] barracksDataTemp = explode(reader.readLine(), "#");
			System.out.println(Arrays.toString(level));
			for (int i = 0; i < barracksDataTemp.length; i++) {
				String[] temp = explode(barracksDataTemp[i], "@");
				System.out.println(Arrays.toString(level));
				barracksData[i][0] =  Integer.parseInt(temp[0]);
				barracksData[i][1] = Integer.parseInt(temp[1]);
				System.out.println(Arrays.toString(level));
			}
			System.out.println(Arrays.toString(level));
			reader.close();
			fReader.close();
			//System.out.println(level[0]);
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open the file '"+fileNameB+"'");
		} catch(IOException ex) {
			System.out.println("Error reading the file '"+fileNameB+"'");
		}
	}
	

	public void setBarracks(int newTotalSlots) {
		try {
			FileWriter fWriter = new FileWriter(fileNameB);
			BufferedWriter writer = new BufferedWriter(fWriter);

			writer.write(newTotalSlots+"\n");
			writer.write(implode(barracksData[1]));

			writer.close();
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open the file '"+fileNameB+"'");
		} catch(IOException ex) {
			System.out.println("Error reading the file '"+fileNameB+"'");
		}
	}

	private String[] explode(String line, String splitter) {
		String[] splittedString = line.split(splitter);
		for (int i=0; i<splittedString.length; i++) {
			try {
				level[i] = Integer.parseInt(splittedString[i]);
			} catch (NumberFormatException ex) {
			}
		}
		
		return splittedString;
	}

	private String implode(int[] value) {
		String line = "";
		for (int i=0; i<value.length - 1; i++)
			line += value[i]+"#";
		line += value[value.length - 1];

		return line;
	}
}