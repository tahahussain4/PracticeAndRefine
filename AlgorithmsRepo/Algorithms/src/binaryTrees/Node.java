package binaryTrees;

public class Node<T> {
	T value;
	Node[] children = new Node[2];
	
	
	public Node(T value) {
		super();
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}
	
	public Node<T> getChild(int direction) {
		if(direction < 0 || direction > 2) {
			return null;
		}
		return children[direction];
	}
	
	public void setChild(int direction,T value) throws ArrayIndexOutOfBoundsException{
		if(direction < 0 || direction > 2) {
			throw new ArrayIndexOutOfBoundsException();
		}

		children[direction] = new Node<T>(value);
	}
	
}
