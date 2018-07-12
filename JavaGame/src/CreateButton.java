import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CreateButton extends JButton {
	static int count; //for planes
	static int count2; //for laserbeams
	int x;
	int y;
	public void rightPlane() { //this method shows the next plane 
		if(count < 9)
		count = count + 1;
		setIcon(new ImageIcon("source/jets/stroke/jet" + Integer.toString(count) + ".png"));
		setRolloverIcon(new ImageIcon("source/jets/stroke/jet" + Integer.toString(count) + ".png"));
		
	}
	public void leftPlane() { //this method shows the previous plane
		if(count > 1)
		count = count - 1;
		setIcon(new ImageIcon("source/jets/stroke/jet" + Integer.toString(count) + ".png"));
		setRolloverIcon(new ImageIcon("source/jets/stroke/jet" + Integer.toString(count) + ".png"));
		
	}
	public void rightBeam() { //this method shows the next laser color
		if(count2 < 5555)
			count2 = count2 + 1111;
		setIcon(new ImageIcon("source/laserbeams/" + Integer.toString(count2) + ".png"));
		setRolloverIcon(new ImageIcon("source/laserbeams/" + Integer.toString(count2) + ".png"));
	}
	public void leftBeam() { //this method shows the previous laser color
		if(count2 > 1111)
			count2 = count2 - 1111;
		setIcon(new ImageIcon("source/laserbeams/" + Integer.toString(count2) + ".png"));
		setRolloverIcon(new ImageIcon("source/laserbeams/" + Integer.toString(count2) + ".png"));
	}
	
	public static int getCount() { //we use this method for understand which plane player selected
		return count;
	}
	public static int getCount2() { //we use this method for understand which laser color player selected
		return count2;
	}
	
	
	public CreateButton(String name, int x, int y, int width, int height) { //this method creates buttons for given parameters
		super();										//calling super
		if(name.length() == 1) {								//when name length = 1, that means it is for jet stroke images
			setBounds(x, y, width, height);
			setIcon(new ImageIcon("source/jets/stroke/jet" + name + ".png"));			
		}
		else if(name.length() == 2) {								//when name length = 2, that means it is for text images
			setBounds(x, y, width, height);
			setIcon(new ImageIcon("source/text/" + name + ".png"));
		}
		else if(name.length() == 3) {								//when name length = 3, that means it is for jet images
			setBounds(x, y, width, height);
			setIcon(new ImageIcon("source/jets/jet" + name + ".png"));
		}
		else if(name.length() == 4) {								//when name length = 4, that means it is for laser images
			setBounds(x, y, width, height);
			setIcon(new ImageIcon("source/laserbeams/" + name + ".png"));
		}
		else {
			setBounds(x, y, width, height);		//if it's a normal button, it's name has at least 5 letters
			setIcon(new ImageIcon("source/buttons/" + name + ".png"));				//reading the main image file
			setPressedIcon(new ImageIcon("source/buttons/" + name + "click.png"));	//reading the pressed image file
			setRolloverIcon(new ImageIcon("source/buttons/" + name + "roll.png"));	//reading the roll image file		
		}
		setBorder(null);				//actually these buttons have no function,
		setContentAreaFilled(false);	//they are just images, so we don't want to button borders or something like that
	}
	
	public void setxy(int x, int y) {
		setLocation(x, y);
	}	
}
