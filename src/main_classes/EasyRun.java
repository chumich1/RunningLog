package main_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EasyRun extends Run{
	
	
	private Calendar dayOfRun;
	private double distance;
	private int physicalFeel;
	private int mentalFeel;
	
	public EasyRun(){
		dayOfRun = GregorianCalendar.getInstance();
		distance = 6;
		
	}
	
	public EasyRun(GregorianCalendar c, int p, int m, double d){
		super(c,p,m);
		distance = d;
	
	}


	public double getDistance() {
		return distance;
	}
	


}
