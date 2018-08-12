package AStar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import Components.Block;
import Components.CustomComponent;
import Components.Grid;
import Components.HeaderComponent;

public class GUIPathFinding extends JFrame {
	CustomComponent[][] displayGrid;
	JPanel gridPanel ;
	JPanel msgPanel;
   int gridWidth = 900;
   int gridHeight = 900;
   int blockLenght;
   HeaderComponent headerComp;
   Grid grid;
   JLabel header ;
   JPanel animationPanel;
	public GUIPathFinding(Grid grid) {
		System.out.println(blockLenght);
		displayGrid = new CustomComponent[grid.getLenght()][grid.getWidth()];
		setPreferredSize(new Dimension(gridWidth,gridHeight));
		setMinimumSize(new Dimension(gridWidth,gridHeight));
		this.grid = grid;
	   	this.setLayout(new FlowLayout(FlowLayout.CENTER));
	   	this.setBackground(Color.black);
	   	//grid panel
	   	gridPanel = new JPanel();
	   	gridPanel.setLayout(new GridLayout(grid.getLenght(),grid.getWidth()));
		gridPanel.setPreferredSize(new Dimension(gridWidth,gridHeight * 9/10));
		blockLenght = (int) Math.min(gridPanel.getPreferredSize().getWidth(),gridPanel.getPreferredSize().getHeight()) / (Math.max(grid.getLenght(), grid.getWidth()));
		generateGrid();
		
	   	//header section
		msgPanel = new JPanel(new FlowLayout());
		msgPanel.setPreferredSize(new Dimension(gridWidth/2,gridHeight/10));
		msgPanel.setBackground(Color.black);
		
		header = new JLabel("Welcome To Path Finding");
		header.setFont(new Font("Serif", Font.PLAIN, 28));
		header.setForeground(Color.white);
		msgPanel.add(header,SwingConstants.CENTER);
		JSlider slider = new JSlider(0,100);
		slider.setBackground(Color.black);
		slider.addChangeListener(new SliderChangeListener());
		msgPanel.add(slider);
		
		
		GridBagConstraints constraints = new GridBagConstraints();
		animationPanel = new JPanel(new GridLayout());
		constraints.gridy = 0;
		constraints.gridx = 0;
		animationPanel.setPreferredSize(new Dimension(gridWidth/2,gridHeight/10));
		System.out.println("animation height panel : " + animationPanel.getPreferredSize().getHeight());
		animationPanel.add(new AnimationComponent((int) animationPanel.getPreferredSize().getHeight(),(int) animationPanel.getPreferredSize().getWidth()));
		animationPanel.setBackground(Color.black);
		this.add(msgPanel);
		this.add(animationPanel);
		this.add(gridPanel);
		
	   	
	   	gridPanel.setVisible(true);
		msgPanel.setVisible(true);
		animationPanel.setVisible(true);
		
	   	setVisible(true);
	   	repaint();
	}
	
	public void animationUpdate(){
		animationPanel.repaint();
	}
	
	public void generateGrid(){
		GridBagConstraints constraints = new GridBagConstraints();
	   	for(int xIndex = 0;xIndex <displayGrid.length;xIndex++){
	   		constraints.gridy = xIndex;
	   		for(int yIndex = 0;yIndex <displayGrid[0].length;yIndex++){
	   			constraints.gridx = yIndex;
	   			CustomComponent comp = new CustomComponent(blockLenght);
	   			comp.setPosX(xIndex*blockLenght);
	   			comp.setPosY(yIndex*blockLenght);
	   			comp.setBlockWidth(blockLenght);
	   			comp.setBackground(Color.blue);
	   			comp.setGridX(xIndex);
	   			comp.setGridY(yIndex);
	   			gridPanel.add(comp,constraints);
	   			comp.addMouseListener(new MyMouseListener(this));
	   			displayGrid[xIndex][yIndex] = comp;
	   		}
	   	}
	}
	
   public void display(Grid grid,Coordinates end,ArrayList<Block> selected, PriorityQueue<Block> explored) {
	   renderMainGrid(grid, end, selected, explored);
	   gridPanel.repaint();
   }
  
   
   public void displayFinalPath(Grid grid,Coordinates end,ArrayList<Block> selected, PriorityQueue<Block> explored) {
	   Block currentBlock = grid.getGrid()[end.getX()][end.getY()];
	   
	   while(true){
		   renderBlock(currentBlock.getPos().getX(), currentBlock.getPos().getY(), "path", end, "");
		   if(currentBlock.getPreviousBlock() == null){
				break;
			}
			else{
				currentBlock = currentBlock.getPreviousBlock();
			}
		}
   }
   
  
   public void renderBlock(int posX,int posY,String state,Coordinates end,String text){
	   CustomComponent comp = displayGrid[posX][posY];
	   comp.setText(text);

	   if(state == "selected"){
		   comp.setColor(Color.green);
	   }
	   else if(state == "explored"){
			comp.setColor(Color.orange);
		}
	   else if(state == "obstacle"){
		   comp.setColor(Color.black);
	   }
	   else if(state == "path"){
			comp.setColor(Color.blue);
		}
	   else if(state =="hover"){
		   comp.setColor(Color.MAGENTA);
	   }
	   else {
			comp.setColor(Color.white);
		}
		
		if(end != null && posX == end.getX() && posY == end.getY()){
			comp.setColor(Color.BLUE);
		}
		comp.repaint();
   }
   
   public void renderBlock(int posX,int posY,Color color,String text){
	   CustomComponent comp = displayGrid[posX][posY];
	   comp.setText(text);
	   comp.setColor(color);
	   comp.repaint();
   }
   
   
   public void renderMainGrid(Grid grid,Coordinates end,ArrayList<Block> selected, PriorityQueue<Block> explored){
	   GridBagConstraints c = new GridBagConstraints();
	  	
	   	for(int xIndex = 0;xIndex <grid.getLenght();xIndex++){
	   		for(int yIndex = 0;yIndex <grid.getWidth();yIndex++){
	   			Block block = grid.getGrid()[xIndex][yIndex];
	   			String state = "";
	   			if(selected.contains(block)){
	   				state = "selected";
	   			}
	   			else if(explored.contains(block)){
	   				state = "explored";
	   			}
	   			else if(block.getBlockType() == BlockType.OBSTACLE ){
	   				state = "obstacle";
	   			}
	   			renderBlock(xIndex, yIndex, state, end, "");
	   		}
	   	}
	   	
//	   	setMinimumSize(getSize()); 
       pack();        
   }
   
   public void renderGridFirst(Grid grid){
	   GridBagConstraints c = new GridBagConstraints();
	  	
	   	for(int xIndex = 0;xIndex <grid.getLenght();xIndex++){
	   		for(int yIndex = 0;yIndex <grid.getWidth();yIndex++){
	   			Block block = grid.getGrid()[xIndex][yIndex];
	   			String state = "";

	   			if(block.getBlockType() == BlockType.OBSTACLE ){
	   				state = "obstacle";
	   			}
	   			renderBlock(xIndex, yIndex, state, null, "");
	   		}
	   	}
	   	
//	   	setMinimumSize(getSize()); 
       pack();        
   }
   
   public void updateHeader(String msg){
	   header.setText(msg);
	   header.repaint();
   }


   public int getGridWidth() {
	return gridWidth;
	}
	
	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}
	
	public int getGridHeight() {
		return gridHeight;
	}
	
	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}
	
	public int getBlockLenght() {
		return blockLenght;
	}
	
	public void setBlockLenght(int blockLenght) {
		this.blockLenght = blockLenght;
	}

	public CustomComponent[][] getDisplayGrid() {
		return displayGrid;
	}

	public void setDisplayGrid(CustomComponent[][] displayGrid) {
		this.displayGrid = displayGrid;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	

	
}
