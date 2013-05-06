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
		for(int i = 0; i < runs.length; i++){
			g.setColor(Color.black);
			g.fillOval((this.getWidth()/runs.length)*i, (int)runs[i].getDistance(),5 , 5);
		}
		
	}

}
