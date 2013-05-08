package main_classes;

import java.awt.GridLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.InternationalFormatter;

import com.toedter.calendar.JCalendar;


public class LogGUI extends JPanel{
	private Calendar runDate;
	//private int mentalFeel, physicalFeel;
	//private double distance;
	private WorkoutType workType;
	private JComboBox mentalFeel, physicalFeel;
	private String[] rangeArray;
	private JCalendar myCalendar;
	private JPanel mentalPanel, physicalPanel;
	private JLabel mentalLabel, physicalLabel;
	
	private JPanel distancePanel;
	private JLabel milesLabel;
	private JComboBox distanceBox;
	
	public LogGUI(){
		rangeArray = new String[100];
		for(int i = 0; i < 100; i++)
			rangeArray[i] = Double.toString((i+1)*.5);
		
		distancePanel = new JPanel();
		milesLabel = new JLabel("How many miles was the run?");
		distanceBox = new JComboBox(rangeArray);
		distanceBox.setSelectedIndex(9);
		distancePanel.add(milesLabel);
		distancePanel.add(distanceBox);

		
		mentalPanel = new JPanel();
		physicalPanel = new JPanel();
		mentalLabel = new JLabel("Mental Feel");
		physicalLabel = new JLabel("Physical Feel");
		mentalFeel = new JComboBox(rangeArray);
		physicalFeel = new JComboBox(rangeArray);
		mentalPanel.add(mentalLabel);
		mentalPanel.add(mentalFeel);
		physicalPanel.add(physicalLabel);
		physicalPanel.add(physicalFeel);
		
		myCalendar = new JCalendar();
		
		this.setLayout(new GridLayout(2,0));
		this.add(mentalPanel);
		this.add(physicalPanel);
		this.add(myCalendar);
		this.add(distancePanel);
	
		
		
		
		
	}
	
	

	
}
