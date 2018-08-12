package AStar;

import java.util.ArrayList;

public class SliderState {
	private static int sliderValue;

	
	private SliderState() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int getSliderValue() {
		if(sliderValue == 0){
			return 1;
		}
		return sliderValue;
	}

	public static void setSliderValue(int sliderValue) {
		SliderState.sliderValue = sliderValue;
	}
	
	
	
}
