import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


import java.util.Timer;
	
	public class Gameplay implements MouseMotionListener {
		
		static Timer timer = new Timer(true);	//creating timer which generates laser beams
		public Gameplay(String jet, String beam) {
		
			CreateWindow gameplay = new CreateWindow("Game");					//frame for gameplay screen
			CreateBackground playim = new CreateBackground("4");				//reading background
			CreateButton jetimage = new CreateButton(jet, 300, 500, 330, 150);	//reading jet image which player selected
			CreateButton beam1 = new CreateButton(beam, 2000, 540, 572, 52);	
			CreateButton beam2 = new CreateButton(beam, 2000, 540, 572, 52);
			CreateButton beam3 = new CreateButton(beam, 2000, 540, 572, 52);
			CreateButton beam4 = new CreateButton(beam, 2000, 540, 572, 52);
			CreateButton beam5 = new CreateButton(beam, 2000, 540, 572, 52);	//creating laser beams which player selected
			CreateButton beam6 = new CreateButton(beam, 2000, 540, 572, 52);	//total, we have 9 laser beams.
			CreateButton beam7 = new CreateButton(beam, 2000, 540, 572, 52);	//they spawn, disappear and re-spawn
			CreateButton beam8 = new CreateButton(beam, 2000, 540, 572, 52);
			CreateButton beam9 = new CreateButton(beam, 2000, 540, 572, 52);
			CreateButton restart = new CreateButton("restart", 850, 450, 220, 70);
					
			gameplay.add(jetimage);		//adding components to frame
			gameplay.add(restart);
			restart.setVisible(false);
			gameplay.add(beam1);
			gameplay.add(beam2);
			gameplay.add(beam3);
			gameplay.add(beam4);
			gameplay.add(beam5);
			gameplay.add(beam6);
			gameplay.add(beam7);
			gameplay.add(beam8);
			gameplay.add(beam9);
			gameplay.add(playim);
			gameplay.getContentPane().repaint();
			gameplay.setExtendedState(JFrame.MAXIMIZED_BOTH);
			gameplay.setCursor(gameplay.getToolkit().createCustomCursor( //this hides the mouse cursor
		            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
			
			
			
			timer.schedule(new CreateBeams(beam1, jetimage), 0000, 2500);	//there is 0.3 second delay time between every laser beam. 
			timer.schedule(new CreateBeams(beam2, jetimage), 0300, 2500);	//laser beams re-generate every 2.5 second
			timer.schedule(new CreateBeams(beam3, jetimage), 0600, 2500);
			timer.schedule(new CreateBeams(beam4, jetimage), 1000, 2500);
			timer.schedule(new CreateBeams(beam5, jetimage), 1200, 2500);
			timer.schedule(new CreateBeams(beam6, jetimage), 1500, 2500);
			timer.schedule(new CreateBeams(beam7, jetimage), 1800, 2500);
			timer.schedule(new CreateBeams(beam8, jetimage), 2100, 2500);
			timer.schedule(new CreateBeams(beam9, jetimage), 2400, 2500);
	
			gameplay.addMouseMotionListener(new MouseMotionAdapter() {	//mouse listener controls the position of jet
				public void mouseMoved(MouseEvent e) {
					jetimage.setxy(e.getX()-160, e.getY());			
				}});
		
		}
		
		static void stopper() {
			timer.purge();
			timer.cancel();
		}
		
		
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
