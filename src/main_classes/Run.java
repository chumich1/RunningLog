package main_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Run {
	private Calendar dayOfRun;
	private int physicalFeel;
	private int mentalFeel;
	
	public Run(){
		dayOfRun = GregorianCalendar.getInstance();
		
		
	}
	
	public Run(GregorianCalendar c, int p, int m){
	
		dayOfRun = c;
		physicalFeel = p;
		mentalFeel = m;
	}

	public Calendar getDayOfRun() {
		return dayOfRun;
	}

	public int getPhysicalFeel() {
		return physicalFeel;
	}

	public int getMentalFeel() {
		return mentalFeel;
	}
	
}
