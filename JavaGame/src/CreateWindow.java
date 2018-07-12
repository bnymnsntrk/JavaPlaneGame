import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CreateWindow extends JFrame {
	
	CreateWindow(String title) {
		super(title);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1920, 1080);			//our game just runs well on 1920x1080 resolution
		setLocationRelativeTo(null);		

	}	
}
