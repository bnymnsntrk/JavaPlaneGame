import java.util.Timer;
import java.util.TimerTask;

public class Limiter extends TimerTask  {

	Timer mover;
	
	
	
	Limiter(Timer mover) {
		this.mover = mover;
	}
	
	@Override
	public void run() {
		mover.purge();		//this limiter class stops running timer
		mover.cancel();		//so,we can generate new laser beams without any error
		

	}
}
