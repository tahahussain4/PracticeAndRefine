package Components;

import java.util.Random;

import AStar.BlockType;
import AStar.Coordinates;

public class Grid {
	private Block[][] grid;
	int lenght;
	int width;
	
	public Grid(int lenght,int width) {
		super();
		grid = new Block[lenght][width];
		fillEmptyGrid();
		this.lenght = lenght;
		this.width = width;
		// TODO Auto-generated constructor stub
	}

	public void fillEmptyGrid(){
		for(int x=0;x<grid.length;x++){
			for(int y=0;y < grid[0].length;y++){
				grid[x][y] = new Block(new Coordinates(x, y),BlockType.EMPTY);
			}
		}
	}
	
	public void randomObstacleGenerator(int numberOfObstacles){
		int randomWidth = 0;
		int randomHeight = 0;
		for(int generated=0;generated<numberOfObstacles;generated++){
			Random rand = new Random();
			randomWidth = rand.nextInt(grid[0].length );
			randomHeight = rand.nextInt(grid.length);
			
			if(grid[randomHeight][randomWidth].getBlockType() != BlockType.OBSTACLE){
				grid[randomHeight][randomWidth].setBlockType(BlockType.OBSTACLE);
			} else {
				generated--;
			}
		}
	}
	
	public Block[][] getGrid() {
		return grid;
	}

	public void setGrid(Block[][] grid) {
		this.grid = grid;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean isObstacle(int xPos,int yPos){
		if( grid[xPos][yPos].getBlockType() == BlockType.OBSTACLE){
			
			return true;
		}
		return false;
	} 

	
}
