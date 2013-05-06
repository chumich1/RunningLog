package main_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Run implements Comparable<Run>{
	private Calendar dayOfRun;
	private int physicalFeel;
	private int mentalFeel;
	private double distance;
	
	public Run(){
		dayOfRun = GregorianCalendar.getInstance();
		
		
	}
	
	public Run(GregorianCalendar c, int p, int m, double d){
	
		dayOfRun = c;
		physicalFeel = p;
		mentalFeel = m;
		distance = d;
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
	
	public double getDistance() {
		return distance;
	}
	@Override
    public int compareTo(Run other){
        return dayOfRun.compareTo(other.getDayOfRun());
    }
	
}
