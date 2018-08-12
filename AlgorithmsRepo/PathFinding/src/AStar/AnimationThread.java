package AStar;

import java.sql.Time;
import java.util.TimerTask;

public class AnimationThread extends TimerTask{
	GUIPathFinding gui;
	
	public AnimationThread(GUIPathFinding gui) {
		super();
		this.gui = gui;
	}

	@Override
	public void run() {
//		System.out.println("update thread");
		gui.animationUpdate();
	}
}
