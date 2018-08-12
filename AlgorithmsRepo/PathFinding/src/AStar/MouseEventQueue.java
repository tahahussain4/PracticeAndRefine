package AStar;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

public class MouseEventQueue {
	private static Queue<Coordinates> mouseClicks;
	private static ArrayList<Coordinates> mouseHover;
	
	public static Queue<Coordinates> getMouseQueue(){
		if(mouseClicks == null){
			mouseClicks = new ConcurrentLinkedQueue<Coordinates>();
		}
		return mouseClicks;
	} 
	
	public static ArrayList<Coordinates> getMouseHoverQueue(){
		if(mouseHover == null){	
			mouseHover = new ArrayList<Coordinates>(1);
		}
		return mouseHover;
	}
	
	public static void addToHover(Coordinates coords){
		if(mouseHover == null){	
			mouseHover = new ArrayList<Coordinates>(1);
		}
		System.out.println("hovering");
		
		mouseHover.clear();
		mouseHover.add(coords);
	}
	
}
