
public class MyLinkedList<T> {
    
    private Node<T> head;
    private Node<T> tail;
    
    public MyLinkedList(){
	head = new Node<T>(null);
	tail = head;
    }

    public MyLinkedList(T data) {
	this();
	head.setNext(new Node<T>(data) );
	tail = head.getNext();
    }

    public Node<T> getNode(int position) {
	//Create a pointer that starts at instance var head
	Node<T> tmp = head;
	//what
	//create an int to count with
	int i = position + 1;
	while (i > 0) {
	    tmp = tmp.getNext();
	    //if the tmp pointer points to a null, that means we have exceeded the bounds of our list.
	    if (tmp == null) {
		throw new IndexOutOfBoundsException("Index " + position + " is out of bounds");
	    }
	    //moves the tmp pointer one over on the list
	    else {
		i--;
	    }
	}
	return tmp;
    }

    //add method appends an element to the end of the list
    public void add (T s) {
	Node<T> newNode = new Node<T>(s);
	tail.setNext(newNode);
	tail = tail.getNext();
    }

    public void add(T s, int position) {
	//If we try to add beyond the list, we get an exception
	if (position > this.length()  || position < 0)
	    {
		throw new IndexOutOfBoundsException("Index " + position + " is out of bounds");
	    }
	else {
	    //create the node to add
	    Node<T> newNode = new Node<T>(s);

	    //If we are adding to the front, then we place the new node after the head node
	    if (position == 0) {
		newNode.setNext(head.getNext());
		head.setNext(newNode);  
	    }
	    //If we are adding to the end, then we place the new node after the tail node
	    if (position == length() ) {
		tail.setNext(newNode);
		tail = tail.getNext();
	    }
	    //Otherwise, we must find the node that comes before the position we are adding to, and swap 
	    //around links
	    else {
		//Call the node at the previous location
		Node<T> prevNode = getNode(position - 1);
		//Attach the newNode to the next on the list, then attach the previous on the list to the newNode
		newNode.setNext(prevNode.getNext() );
		prevNode.setNext(newNode);
	        
	    }
	}	    
    }


    public T get(int position) {
	return getNode(position).getData();
    }

    public void set(T s, int position) {
	getNode(position).setData(s);
    }

    public void remove(int position) {
	//If we try to remove beyond the list, we get an exception
	if (position > this.length()-1 || position < 0)
	    {
		throw new IndexOutOfBoundsException("Index " + position + " is out of bounds");
	    }
	else if (position == length() - 1) {
	    tail = getNode(length() - 2);
	    tail.setNext(null); 
	}
	else {
	    Node<T> prevNode = getNode(position - 1);
	    prevNode.setNext(prevNode.getNext().getNext());
	}	
    }   

    public int find(T s) {
	Node<T> tmp = head.getNext();
	int ctr = 0;
	while (tmp != null) {
	    if (tmp.getData().equals(s)) {
		return ctr;
	    }
	    ctr++;
	    tmp = tmp.getNext();
	}
	return -1;
    }
    
    public int length() {
	int ctr = 0;
	Node<T> tmp = head.getNext();
	while (tmp != null) {
	    ctr++;
	    tmp = tmp.getNext();
	}
	return ctr;
    }

    public String toString() {
	String retStr = "";
	retStr += "[";
	Node<T> tmp = head.getNext();
	while (tmp != null) {
	    retStr += tmp.getData().toString();
	    tmp = tmp.getNext();
	    retStr += ", ";
	}
	if (retStr.length() > 2) {
	    retStr = retStr.substring(0, retStr.length()-2);
	}
	retStr += "]";
	//System.out.println("pawprint");
	return retStr;
	
    }
   
    public static void main (String[] args) {
	/*
	MyLinkedList giraffe = new MyLinkedList();
	System.out.println(giraffe);
	giraffe.add("andrew");
	System.out.println(giraffe);
	System.out.println(giraffe.getNode(0));
	giraffe.add("atomic");
	giraffe.add("catastrophe");
	giraffe.add("damsel");
	giraffe.add("damsel");

	System.out.println(giraffe);
	System.out.println("Data at 0: " + giraffe.getNode(0));
	System.out.println("Data at 2: " + giraffe.getNode(2));
	System.out.println("Data at 3: " + giraffe.getNode(3));
	System.out.println("Data at 1: " + giraffe.getNode(1));
	System.out.println("Length of list: " + giraffe.length() );
	System.out.println("where is damsel? " + giraffe.find("damsel"));
	System.out.println("where is atomic? " + giraffe.find("atomic"));
	System.out.println("where is catastrophe? " + giraffe.find("catastrophe"));
	System.out.println("where is bombshell? " + giraffe.find("bombshell"));
	System.out.println("where is waldo? " + giraffe.find("waldo"));

	giraffe.remove(1);
	System.out.println(giraffe);
	*/
    }
    
}

