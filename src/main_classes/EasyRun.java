package main_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EasyRun extends Run{
	
	
	private Calendar dayOfRun;
	private int physicalFeel;
	private int mentalFeel;
	
	public EasyRun(){
		dayOfRun = GregorianCalendar.getInstance();
	
		
	}
	
	public EasyRun(GregorianCalendar c, int p, int m, double d){
		super(c,p,m,d);
		
	
	}




}
