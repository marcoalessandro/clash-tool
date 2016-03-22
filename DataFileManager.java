package com.boberSoft.android;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.boberSoft.android.building.Barrack;
import com.boberSoft.android.unit.Unit;

public class DataFileManager {
	/*
	 * Unit count
	 */
	private static final int UNIT_COUNT = 16;
	
	/*
	 * Total barracks count: normal + black
	 */
	private static final int BARRACKS_COUNT = 6;
	
	// path for the files containing levels of troops and barracks informations
	private String fileNameLevels = "src/com/boberSoft/android/assets/resources/DefaultUnitLevel.txt";
	private String fileNameBarracks = "src/com/boberSoft/android/assets/resources/buildingsSettings.txt";

	private int[] level;
	private int armySlots;
	private int[][] barracksData;

	/**
	 * Default DataFileManager constructor
	 */
	public DataFileManager() {
		level = new int[UNIT_COUNT];
		
		/*
		 * Second parameter sets the barrack level and status: LEVEL ___ TRUE or FALSE
		 */
		barracksData = new int[BARRACKS_COUNT][2];

		update();
	}
	
	/*
	 * Returns the level of the given unit
	 * ID's start with 1, the array starts with 0
	 * Subtract 1 to the index to get the correct level
	 */
	public int getLevel(Unit unit) {
		return level[unit.getId() - 1];
	}
	
	public int getArmySlots() {
		return armySlots;
	}
	
	public int getBarrackLevel(Barrack barrack) {
		return barracksData[barrack.getId() - 1][0];
	}
	
	public int getBarrackStatus(Barrack barrack) {
		return barracksData[barrack.getId() -1][1];
	}
	
	private void update() {
		/*
		 * Retrieve the line containing all the levels of the troops
		 * Must be sent to the splitter function
		 */
		String levels = readLevels();
		
		/*
		 * Sending the line with levels to the splitter
		 * The splitter function will update the data on the fly
		 */
		updateLevelData(levels);
		
		/*
		 * Retrieve the line containing all the barracks informations
		 * Must be sent to the splitter function
		 */
		String barracksData = readBarracks();
		
		/*
		 * Sending the line with barracks data to the splitter
		 * The splitter function will update the data on the fly
		 */
		updateBarracksData(barracksData);
	}
	
	/*
	 * Sends the barracks line to the splitter
	 * Converts single barrack data to integer
	 * Adds the data to the matrix
	 */
	private void updateBarracksData(String barracks) {
		String[] singleBarrackData = explode(barracks, "#");
		
		for (int i = 0; i < BARRACKS_COUNT; i++) {
			String[] singleBarrackArray = explode(singleBarrackData[i], "@");
			barracksData[i][0] = Integer.parseInt(singleBarrackArray[0]);
			barracksData[i][1] = Integer.parseInt(singleBarrackArray[1]);
		}
	}

	/*
	 * Sends the level line to the splitter
	 * Converts the single levels into integers
	 * and adds them to the level array
	 */
	private void updateLevelData(String levels) {
		String[] levelArray = explode(levels, "#");
		
		for (int i = 0; i < UNIT_COUNT; i++) {
			int currentLevel = Integer.parseInt(levelArray[i]);
			level[i] = currentLevel;
		}
	}

	private String readLevels() {
		try {
			FileReader fReader = new FileReader(fileNameLevels);
			BufferedReader reader = new BufferedReader(fReader);

			String out = reader.readLine();

			reader.close();
			fReader.close();

			return out;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open the file '" + fileNameLevels + "'");
		} catch (IOException ex) {
			System.out.println("Error reading the file '" + fileNameLevels + "'");
		}

		return null;
	}
	
	/*
	 * Reads the barracks file
	 * Updates the armySlots directly
	 * Returns a line with other data
	 */
	private String readBarracks() {
		try {
			FileReader fReader = new FileReader(fileNameBarracks);
			BufferedReader reader = new BufferedReader(fReader);

			armySlots = Integer.parseInt(reader.readLine());
			String out = reader.readLine();

			reader.close();
			fReader.close();

			return out;
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open the file '" + fileNameBarracks + "'");
		} catch (IOException ex) {
			System.out.println("Error reading the file '" + fileNameBarracks + "'");
		}
		
		return null;
	}

	private String[] explode(String line, String splitter) {
		return line.split(splitter);
	}
}
