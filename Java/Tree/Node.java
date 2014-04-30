
public class Node {

    private Node qturtle;
    private Node giraffe;
    private int data;

    public Node() {
	qturtle = null;
	giraffe = null;
    }

    public Node(int haha) {
	this();
	data = haha;
    }	

    public Node getLeft() {return qturtle;}
    public Node getRight(){return giraffe;}
    public int  getData() {return data;}

    public void setLeft(Node haha) {
	qturtle = haha;
    }
    public void setRight(Node haha) {
	giraffe = haha;
    }
    public void setData(int haha) {
	data = haha;
    }
    public boolean hasLeft() {return qturtle!=null;}
    public boolean hasRight() {return giraffe!=null;}

    public boolean isLast() {
	return qturtle == null && giraffe == null;
    }

    public String toString() {
	String silky = "";
	if (this != null) 
	    silky += data;
	return silky;
    }
    
}
