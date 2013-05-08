package main_classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;



public class Log extends JFrame{
	private Multimap<RunType, Run> runs = HashMultimap.create();
	private String name;
	private String fileName;
	private JButton logSwitch;
	private GraphGUI myGUI;
	private JPanel panelThing;
	private JFrame graphFrame;
	private LogGUI myLog;
	
	public Log(String name){
		myLog = new LogGUI();
		this.setLayout(new GridLayout(2,2));
		graphFrame = new JFrame();
		
		this.name = name;
		fileName = name+".csv";
		readFile(fileName);
		Run[] a = new Run[runs.size()];
		panelThing = new JPanel();
		logSwitch = this.createSwitchButton();
		this.add(logSwitch);
		this.add(myLog);
		myGUI = new GraphGUI(this.getAllRuns().toArray(a));
		graphFrame.add(myGUI);
		
		this.setSize(new Dimension(1100, 800));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		graphFrame.setSize(new Dimension(1100, 800));
		graphFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
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
	
	public Collection<Run> getAllRuns(){
		return runs.values();
	}
	
	public void openLog(){
		System.out.println("AMEN");
		this.add(panelThing);
		this.remove(myGUI);
		
	}
	
	public void openGraph(){
		System.out.println("YO");
		this.add(myGUI);
		this.remove(panelThing);
		
	}
	
	private JButton createSwitchButton() {
		logSwitch = new JButton("Show Graph");
		class MenuItemListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				graphFrame.setVisible(true);
			}
		}
		logSwitch.addActionListener(new MenuItemListener());
		return logSwitch;
	}
	public static void main(String[] args) {
		Log myLog = new Log("testLog");
		System.out.println(myLog.getAllRuns());
		System.out.println(myLog.getAllRuns());

		
	}
	
}
