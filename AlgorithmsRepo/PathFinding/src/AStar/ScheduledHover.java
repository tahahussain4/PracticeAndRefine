package AStar;

import java.util.TimerTask;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Dhinakaran P.
 */
// Create a class extends with TimerTask
public class ScheduledHover extends TimerTask{
	private static GUIPathFinding gui;
	private static Coordinates previousCooridnates;
	private static Color previousColor;
	
	public ScheduledHover(GUIPathFinding gui) {
		this.gui = gui;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		ArrayList<Coordinates> hoverQueue = MouseEventQueue.getMouseHoverQueue();
		Coordinates coord = null;

		//restore privous color
		if(previousColor != null && previousCooridnates != null){
			gui.renderBlock(previousCooridnates.getX(), previousCooridnates.getY(),previousColor,"");
			previousColor = null;
			previousCooridnates = null;
		}
		
		if(!hoverQueue.isEmpty()){
			coord = hoverQueue.get(0);
			
			previousColor = gui.getDisplayGrid()[coord.getX()][coord.getY()].getColor();
			gui.renderBlock(coord.getX(), coord.getY(), "hover", null, "");
			previousCooridnates = coord;
		}
	}

		public static Coordinates getPreviousCooridnates() {
			return previousCooridnates;
		}
	
		public static void setPreviousCooridnates(Coordinates previousCooridnates) {
			ScheduledHover.previousCooridnates = previousCooridnates;
		}
	
		public static Color getPreviousColor() {
			return previousColor;
		}
	
		public static void setPreviousColor(Color previousColor) {
			ScheduledHover.previousColor = previousColor;
		}
	
		public static void erasePreviousState(){
			setPreviousColor(null);
			setPreviousCooridnates(null);
		}
	
}
