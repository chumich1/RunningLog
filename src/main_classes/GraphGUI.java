package main_classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

public class GraphGUI extends JPanel{
	private Run[] runs;
	private boolean distance;
	private boolean mentalFeel;
	public GraphGUI(Run[] runs){
		this.runs = runs;
		distance = true;
		mentalFeel = true;
		Arrays.sort(this.runs);
		System.out.println(this.runs.length);
		
	}
	
	
	
	public void paintComponent(Graphics g){
		if(distance)
			paintDistance(g);
		if(mentalFeel)
			paintMentalFeel(g);
	}
	
	public void paintDistance(Graphics g){
		int largest = 1;
		int smallest = 0;
		int largestGap = 1;
		for(int i = 0; i < runs.length; i++){
			if((int)runs[i].getDistance() > largest)
				largest = (int)runs[i].getDistance();
			
			if(i == 0)
				smallest = (int)runs[i].getDistance();
			
			if((int)runs[i].getDistance() < smallest)
				smallest = (int)runs[i].getDistance();
	
			}
		int largestDif = largest - smallest;
		
		for(int i = 0; i < runs.length; i++){
			g.setColor(Color.black);
			g.fillOval((this.getWidth()/runs.length)*i, (this.getHeight()-(int)runs[i].getDistance()*this.getHeight()/30),5 , 5);
		}
		
	}
	
	public void paintMentalFeel(Graphics g){
		int largest = 1;
		int smallest = 0;
		int largestGap = 1;
		for(int i = 0; i < runs.length; i++){
			if(runs[i].getMentalFeel() > largest)
				largest = runs[i].getMentalFeel();
			
			if(i == 0)
				smallest = runs[i].getMentalFeel();
			
			if(runs[i].getMentalFeel() < smallest)
				smallest = runs[i].getMentalFeel();
	
			}
		int largestDif = largest - smallest;
		
		for(int i = 0; i < runs.length; i++){
			g.setColor(Color.RED);
			g.fillOval((this.getWidth()/runs.length)*i, (this.getHeight()-runs[i].getMentalFeel()*this.getHeight()/30),5 , 5);
		}
		
	
	}
}
