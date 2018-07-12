//150116007 Bünyamin Þentürk
//150115055 Yaþar Salý
//USE A 1920x1080 MONITOR!

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class GameProject {

	public static void main(String args[]) throws FileNotFoundException {

		CreateBackground mainim = new CreateBackground("0");		//reading background image using our CreateBackground Class		
		CreateWindow mainmenu = new CreateWindow("Game Project");	//Creating the Main Frame
		CreateButton start = new CreateButton("start", 850, 450, 220, 70);		//CreateButton class creates each button, 
		CreateButton opts = new CreateButton("options", 850, 575, 220, 70);		//parameters are name, x, y, width, height
		CreateButton howto = new CreateButton("howto", 850, 700, 220, 70);		
		CreateButton exit = new CreateButton("exitt", 850, 825, 220, 70);			
		CreateButton back = new CreateButton("backk",850, 900, 220, 70);
		mainmenu.add(start);
		mainmenu.add(opts);
		mainmenu.add(howto);
		mainmenu.add(exit);
		mainmenu.setExtendedState(JFrame.MAXIMIZED_BOTH);		//maximizing frames
		mainmenu.add(mainim);									//setting background image
		
		start.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateWindow startmenu = new CreateWindow("Select Your Plane");			//new frame
				CreateButton left = new CreateButton("leftt", 500, 150, 150, 100);		//left arrow for plane selection
				CreateButton play = new CreateButton("gamestart", 850, 750, 220, 70);	//this button starts game
				left.setVisible(false);													//left button will not be visible until player clicks right button
				CreateButton left2 = new CreateButton("leftt", 500, 550, 150, 100);		//left arrow for laser color selection
				left2.setVisible(false);												//left2 button will not be visible until player clicks right2 button
				CreateButton right = new CreateButton("rightt", 1270, 150, 150, 100);	//right arrow for plane selection
				CreateButton right2 = new CreateButton("rightt", 1270, 550, 150, 100);	//right arrow for laser color selection
				CreateButton planes = new CreateButton("1", 660, 0, 600, 400);			//plane images for selection
				CreateButton beams = new CreateButton("1111", 675, 570, 570, 50);		//laser colors for selection
				planes.rightPlane();								//we use rightplane method for show next plane image
				beams.rightBeam();									//we use rightbeam method for show next beam image
				mainmenu.setVisible(false);							
				startmenu.add(back);								//adding buttons to frame....
				startmenu.add(left);
				startmenu.add(right);
				startmenu.add(right2);
				startmenu.add(planes);
				startmenu.add(left2);
				startmenu.add(beams);
				startmenu.add(play);
				startmenu.setExtendedState(JFrame.MAXIMIZED_BOTH);		//maximizing frame
				CreateBackground startim = new CreateBackground("1");	//background image for this frame
				startmenu.add(startim);									//adding background
				right.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent e) {
						left.setVisible(true);
						planes.rightPlane();							//button gets invisible when there is no plane image left to show
							if(CreateButton.getCount() == 9)
								right.setVisible(false);}});
				left.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						right.setVisible(true);
						planes.leftPlane();								//button gets invisible when there is no plane image left to show
							if(CreateButton.getCount() == 1)
								left.setVisible(false);}});
				right2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						left2.setVisible(true);
						beams.rightBeam();								//button gets invisible when there is no laser image left to show
							if(CreateButton.getCount2() == 5555)
								right2.setVisible(false);}});
				left2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						right2.setVisible(true);
						beams.leftBeam();								//button gets invisible when there is no laser image left to show
							if(CreateButton.getCount2() == 1111)
								left2.setVisible(false);}});
				play.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						startmenu.setVisible(false);
						String p = Integer.toString(CreateButton.getCount());		//that stands for understand which plane player selected
						String l = Integer.toString(CreateButton.getCount2());		//that stands for understand which laser color player selected
						new Gameplay(p+p+p, l);										//gameplay screen has its own class
						 
					}
				});
				back.addActionListener(new ActionListener() {	//each screen has back button, which shows the main menu
					public void actionPerformed(ActionEvent e) {
						startmenu.setVisible(false);
						mainmenu.setVisible(true);
						mainmenu.add(mainim);	}});}});
		opts.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				CreateWindow optionsmenu = new CreateWindow("Options");
				CreateButton optstext = new CreateButton("12", 565, 10, 777, 895);
				mainmenu.setVisible(false);
				optionsmenu.add(back);
				optionsmenu.add(optstext);
				optionsmenu.setExtendedState(JFrame.MAXIMIZED_BOTH);		//maximizing frames
				CreateBackground optim = new CreateBackground("2");
				optionsmenu.add(optim);
				
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionsmenu.setVisible(false);	
				mainmenu.setVisible(true);
				mainmenu.add(mainim);		//we don't know why, but we have to set background image again
			}});}});
		howto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				CreateWindow howtomenu = new CreateWindow("How To Play");
				CreateButton howtotext = new CreateButton("11", 530, 130, 876, 723);			
				mainmenu.setVisible(false);
				howtomenu.add(back);
				howtomenu.add(howtotext);
				howtomenu.setExtendedState(JFrame.MAXIMIZED_BOTH);		//maximizing frames
				CreateBackground howtoim = new CreateBackground("3");
				howtomenu.add(howtoim);
				
				
				back.addActionListener(new ActionListener() {	//each screen has back button, which shows the main menu
					public void actionPerformed(ActionEvent e) {
						howtomenu.setVisible(false);
						mainmenu.setVisible(true);
						mainmenu.add(mainim); }});}});		//we have to set background image again
		exit.addActionListener(new ActionListener() {			//exit button terminates the program
			public void actionPerformed(ActionEvent e) {
				System.exit(0); }});
	}

}