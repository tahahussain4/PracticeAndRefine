package AStar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class AnimationComponent extends JComponent{
	private int iterator = 0;
	private int maxHeight;
	private int maxWidth;
	
	public AnimationComponent(int maxHeight,int maxWidth) {
		this.maxHeight = maxHeight;
		this.maxWidth = maxWidth;
		this.setMinimumSize(new Dimension(10, maxHeight));
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2  = (Graphics2D) g;
        System.out.println("painting");
        System.out.println(maxHeight);
        g2.setColor(Color.blue);
        g2.drawRect(0,maxHeight - iterator -10, 10, 10);
        g2.fillRect(0,maxHeight - iterator -10, 10, 10);
        
        iterator++;
        if((iterator+10) > maxHeight){
        	iterator = 0;
        }
        
    }
    
    
	
}
