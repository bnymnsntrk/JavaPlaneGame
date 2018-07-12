import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreateBackground extends JPanel { //with this class, we can set background images to our jframes
	
	String name = "0";
	
	public CreateBackground(String name) { //different name for each background
		this.name = name;
	}
	@Override
	protected void paintComponent(Graphics g) {
		Image bg;
		super.paintComponent(g);
		if(name.length() == 1) {
			bg = new ImageIcon("source/bg" + name + ".jpg").getImage();
		}
		else {
			bg = new ImageIcon("source/bg" + name + ".gif").getImage();
		}
		
			g.drawImage(bg, 0, 0, null);
	}
}
