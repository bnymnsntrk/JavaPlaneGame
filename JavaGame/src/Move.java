import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Move extends TimerTask  {
	
	CreateButton beam;
	CreateButton plane;
	CreateButton restart;
	CreateWindow gameplay;
	int x;
	int y;
	
	public Move(CreateButton beam, CreateButton plane, CreateButton restart, CreateWindow gameplay, int x, int y) {
		this.beam = beam;
		this.plane = plane;
		this.restart = restart;
		this.gameplay = gameplay;
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public void run()  {
		x = x - 15;		//laser beams move 15 pixel left in x coordinate every 0.01 second
		beam.setxy(x, y);
		
		if(plane.getX() < x + 500 && plane.getX() > x - 200) {	//these if controllers detect if there is a collision between plane and laser beams
			if(plane.getY() < y + 50 && plane.getY() > y - 100) {			
				
				plane.setVisible(false);		//plane gets invisible when game overs
				Gameplay.stopper();				//stopping timer tasks
				
				File scores = new File("source/scores.txt"); 		//txt file which scores will saved
				PrintWriter newscore = null;
				Scanner data;
				int line = 0;
				int max = 0;
				try {
					data = new Scanner(scores);
					newscore = new PrintWriter(new BufferedWriter(new FileWriter(scores, true))); //writing scores to "scores.txt"
					newscore.println(CreateBeams.getScore());
					newscore.close();
					while(data.hasNextLine()){	//this works while there is a next line
			        	line = data.nextInt();
			        	max = Math.max(line, max);	//comparing the scores for know which one is the high score
					}
				}	
				
			        	
				catch (IOException e) {
				}
				catch (NoSuchElementException e) {
				}
				
				JOptionPane.showMessageDialog(gameplay, "Your Score Is: " + CreateBeams.getScore() + "\nHigh Score Is: " + max, "Game Over", //give info to player
				        JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);		//close the program
			
			}
		}
	}
}


