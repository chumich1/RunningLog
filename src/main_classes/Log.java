package main_classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;



public class Log {
	private Multimap<RunType, Run> runs = HashMultimap.create();
	private String name;
	private String fileName;
	
	public Log(String name){
		this.name = name;
		fileName = name+".csv";
		readFile(fileName);
		
	}
	
	public void readFile(String file){
		Scanner csvFile = null;
		try{
		csvFile = new Scanner(new File(file));
		}catch(FileNotFoundException e){
			System.out.println("FILE: "+file+"does not exist");
		}
		
		// Create an array to hold the line after splitting
		String[] csvSplit;
		
		while(csvFile.hasNextLine()){
			csvSplit = csvFile.nextLine().split(",");
			
			if(csvSplit.length == 6){
				runs.put(RunType.EASY, new EasyRun(new GregorianCalendar(Integer.parseInt(csvSplit[0]),Integer.parseInt(csvSplit[1]),Integer.parseInt(csvSplit[2])),Integer.parseInt(csvSplit[3]),Integer.parseInt(csvSplit[4]),Double.parseDouble(csvSplit[5])));
			}
			
			else if(csvSplit.length == 7){
				WorkoutType temp = WorkoutType.INTERVAL;
				switch (Integer.parseInt(csvSplit[6])){
				case 1:
					temp = WorkoutType.INTERVAL;
					break;
				case 2:
					temp = WorkoutType.TEMPO;
					break;
				}
				runs.put(RunType.WORKOUT, new WorkoutRun(new GregorianCalendar(Integer.parseInt(csvSplit[0]),Integer.parseInt(csvSplit[1]),Integer.parseInt(csvSplit[2])),Integer.parseInt(csvSplit[3]),Integer.parseInt(csvSplit[4]),Double.parseDouble(csvSplit[5]), temp));
			}
			
			
		}
		
	}
	
	public  Collection<Run> getWorkouts(){
		return runs.get(RunType.WORKOUT);
	}
	
	public  Collection<Run> getEasyRuns(){
		return runs.get(RunType.EASY);
	}
	
	public static void main(String[] args) {
		Log myLog = new Log("testLog");
		System.out.println(myLog.getWorkouts());
		System.out.println(myLog.getEasyRuns());

		
	}
	
}
