
public class MyLinkedList {
    
    private Node head;
    
    public MyLinkedList() {
	head = null;
    }

    public MyLinkedList(String data) {
	head = new Node(data);
    }

    public Node getNode(int position) {
	//Create a pointer that starts at instance var head
	Node tmp = head;

	//create an int to count with
	int i = position;
	while (i > 0) {
	    //if the tmp pointer points to a null, that means we have exceeded the bounds of our list.
	    if (tmp == null) {
		throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
	    }
	    //moves the tmp pointer one over on the list
	    else {
		tmp = tmp.getNext();
		i--;
	    }
	}
	return tmp;
    }

    public void add(String s, int position) {
	//If we try to add beyond the list, we get an exception
	if (position > this.length() )
	{
	    throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
	}
	else {
	    //create a node
	    Node newNode = new Node(s);

	    //If we are adding to the front, then we simply set the next node to as the head
	    if (position == 0) {
		newNode.setNext(head);
		head = newNode;
	    }
	    //Otherwise, we must find the node that comes before the position we are adding to, and swap 
	    //around links
	    else {
		//Call the node at the previous location
		Node prevNode = getNode(position - 1); 
		//Attach the newNode to the next on the list, then attach the previous on the list to the newNode
		newNode.setNext(prevNode.getNext() );
		prevNode.setNext(newNode);
	        
	    }
	}	    
    }

    public String get(int position) {
	return getNode(position).getData();
    }

    public void remove(int position) {
	//If we try to remove beyond the list, we get an exception
	if (position > this.length() || position < 0)
	    {
		throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
	    }
	else {
	    if (head == null) {
		return;
	    }
	    if (position == 0) {
		head = head.getNext();
	    }
	    else {
		Node prevNode = getNode(position - 1);
		prevNode.setNext(prevNode.getNext().getNext());
	    }	
	}
    }    

    public int find(String s) {
	Node tmp = head;
	int ctr = 0;
	while (tmp != null) {
	    if (tmp.getData() == s) {
		return ctr;
	    }
	    ctr++;
	    tmp = tmp.getNext();
	}
	return -1;
    }
    
    public int length() {
	int ctr = 0;
	Node tmp = head;
	while (tmp != null) {
	    ctr++;
	    tmp = tmp.getNext();
	}
	return ctr;
    }

    public String toString() {
	if (head == null) 
	    {return "[]";}
	else{
	    String retStr = "";
	    retStr += "[";
	    Node tmp = head;
	    while (tmp != null) {
		retStr += tmp.getData();
		tmp = tmp.getNext();
		retStr += ", ";
	    }
	    retStr = retStr.substring(0, retStr.length()-2) + "]";
	    //System.out.println("pawprint");
	    return retStr;
	}
    }
   
    public static void main (String[] args) {
	
	MyLinkedList giraffe = new MyLinkedList("bombshell");
	//System.out.println(giraffe);
	//System.out.println(giraffe.getNode(0));
	giraffe.add("atomic", 1);
	giraffe.add("catastrophe", 2);
	giraffe.add("damsel", 3);
	//System.out.println(giraffe);
	//System.out.println("Data at 2: " + giraffe.get(2));
	//	System.out.println("Data at 3: " + giraffe.get(3));
	//	System.out.println("Data at 1: " + giraffe.get(1));
	//System.out.println("Data at 0: " + giraffe.get(0));
	//System.out.println("Length of list: " + giraffe.length() );
	//System.out.println("where is damsel? " + giraffe.find("damsel"));
	//	System.out.println("where is atomic? " + giraffe.find("atomic"));
	//	System.out.println("where is catastrophe? " + giraffe.find("catastrophe"));
	//System.out.println("where is bombshell? " + giraffe.find("bombshell"));
	//System.out.println("where is waldo? " + giraffe.find("waldo"));
	giraffe.remove(2);
	//System.out.println(giraffe);

    }
    
}

