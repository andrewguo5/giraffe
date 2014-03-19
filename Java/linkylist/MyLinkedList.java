
public class MyLinkedList {
    
    private Node head;
    
    public MyLinkedList() {
	head = null;
    }

    public MyLinkedList(String data) {
	Node( data );
    }

    public Node getNode(int position, Node turtle) {
	if (position == 0) {
	    return turtle;
	}
	else {
	    //if null return exception;
	    turtle = turtle.getNext();
	    return getNode(position - 1);
	}
    }

    public void add(String s, int position) {
	//Call the node at the current location
	Node currentNode = getNode(position, head); 
	//create a node
	Node newNode = new Node(s);
	//Add it to the indicated position.
	Node tmp = currentNode.getNext();
	Node newNode.setNext(tmp);
	currentNode.setNext(currentNode);
	    
	}
	
    }


}