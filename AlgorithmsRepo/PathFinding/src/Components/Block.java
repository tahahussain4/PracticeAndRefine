package Components;

import AStar.BlockType;
import AStar.Coordinates;

public class Block {
	private Block previousBlock;
	private Coordinates pos;
	private BlockType blockType;
	private int destCost;
	private int startCost;
	
	public Block(Block previousBlock, Coordinates pos) {
		super();
		this.previousBlock = previousBlock;
		this.pos = pos;
	}
	
	public Block(Coordinates pos,BlockType blockType) {
		super();
		this.pos = pos;
		this.blockType = blockType;
	}

	
	public Block(int destCost, int startCost) {
		super();
		this.destCost = destCost;
		this.startCost = startCost;
	}

	public Block getPreviousBlock() {
		return previousBlock;
	}

	public void setPreviousBlock(Block previousBlock) {
		this.previousBlock = previousBlock;
	}

	public Coordinates getPos() {
		return pos;
	}

	public void setPos(Coordinates pos) {
		this.pos = pos;
	}

	public int getDestCost() {
		return destCost;
	}

	public void setDestCost(int destCost) {
		this.destCost = destCost;
	}

	public int getStartCost() {
		return startCost;
	}

	public void setStartCost(int startCost) {
		this.startCost = startCost;
	}
	
	

	public BlockType getBlockType() {
		return blockType;
	}

	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}


	
	
	@Override
	public String toString() {
		return "Block [pos=" + pos + ", blockType=" + blockType + ", destCost=" + destCost + ", startCost=" + startCost
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(this.getPos().equals(((Block) obj).getPos())){
			return true;
		}
		return false;
	}
}
