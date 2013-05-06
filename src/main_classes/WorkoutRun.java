package main_classes;

import java.util.GregorianCalendar;

public class WorkoutRun extends Run {

	private WorkoutType workType;

	
	public WorkoutRun(GregorianCalendar c, int p, int m, double d, WorkoutType w){
		super(c,p,m,d);
		workType = w;
	
		
	}
	
	public WorkoutType getWorkType() {
		return workType;
	}
	
}
