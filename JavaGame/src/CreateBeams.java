import java.util.Timer;
import java.util.TimerTask;

public class CreateBeams extends TimerTask {

	int x, y;
	CreateButton beam;
	CreateButton plane;
	CreateButton restart;
	CreateWindow gameplay;
	static int score;
	
	public CreateBeams(CreateButton beam, CreateButton plane, CreateButton restart, CreateWindow gameplay) {
		this.beam = beam;
		this.plane = plane;
		this.restart = restart;
		this.gameplay = gameplay;
	}
	public CreateBeams(CreateButton beam, CreateButton plane) {
		this.beam = beam;
		this.plane = plane;

	}
	
	public void run() {
		
		x = ((int) (Math.random()*500 + 1800)); //generating laser beams randomly using Math.random
		y = ((int) (Math.random()*1000));		//they spawn x coordinates between 1800-2300 and y coordinates between 0-1000
		beam.setLocation(x, y);

		Timer move = new Timer(true);		//creating timer for move the lasers
		Timer limit = new Timer(true);		//creating time limiter for lasers, so they can spawn without any error
		move.schedule(new Move(beam, plane,restart,gameplay, x, y), 0, 0010);	//lasers move every 0.01 second 
		limit.schedule(new Limiter(move), 2500, 2500);			//laser beams disappear every 2.5 second
		score = score + 1;					// when a laser beam generated, player gets +1 score point
	
	}

	public static int getScore() {
		return score;
	}

}
