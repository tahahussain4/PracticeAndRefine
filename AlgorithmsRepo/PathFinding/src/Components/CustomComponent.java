package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomComponent extends JComponent  implements MouseListener{

    private static final long serialVersionUID = 1L;
    private int posX;
    private int posY;
    private int gridX;
    private int gridY;
    private Color color;
    private String text;
    private int blockWidth;
    JLabel label;
    
    public CustomComponent(int blockWidth) {
    	super();
    	label = new JLabel();
		setPreferredSize(new Dimension(blockWidth, blockWidth));
		this.add(label);
    	this.setLayout(new GridLayout());
    	this.setMinimumSize(new Dimension(5, 5));
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2  = (Graphics2D) g;
        
        g2.setColor(color);
        g2.drawRect(0, 0, blockWidth, blockWidth);
        g2.fillRect(0, 0, blockWidth, blockWidth);
//        label.setText(this.getText());
//        label.setFont(new Font("Serif", Font.PLAIN, 7));
//        label.setVerticalAlignment(SwingConstants.CENTER);
//        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

	  @Override
	public void mouseClicked(MouseEvent arg0) {;
	        System.out.println("here was a click ! ");
	 }
	  
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getBlockWidth() {
		return blockWidth;
	}


	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}
	
	
	

}