package main_classes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

public class GraphGUI extends JPanel{
	private Run[] runs;
	public GraphGUI(Run[] runs){
		this.runs = runs;
		Arrays.sort(this.runs);
		System.out.println(this.runs.length);
		
	}
	
	public void paintComponent(Graphics g){
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

}
