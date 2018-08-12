package AStar;

import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SliderChangeListener implements ChangeListener {
	
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			System.out.println(source.getValue());
			SliderState.setSliderValue(source.getValue());
		}
	}
}

