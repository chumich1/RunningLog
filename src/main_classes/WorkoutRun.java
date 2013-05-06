package main_classes;

import java.util.GregorianCalendar;

public class WorkoutRun extends Run {

	private WorkoutType workType;
	private double totalDistance;
	
	public WorkoutRun(GregorianCalendar c, int p, int m, double d, WorkoutType w){
		super(c,p,m);
		workType = w;
		totalDistance = d;
		
	}
	
	public WorkoutType getWorkType() {
		return workType;
	}
	
	public double getTotalDistance() {
		return totalDistance;
	}
}
