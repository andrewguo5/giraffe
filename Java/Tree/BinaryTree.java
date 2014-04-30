public class BinaryTree {

    private Node root;
    
    public BinaryTree() {
	root = null;
    }

    public BinaryTree(int haha) {
	root =  new Node(haha);
    }

    public BinaryTree(Node temp) {
	root = temp;
    }

    public void insert(int haha) {
	if (root == null) 
	    root = new Node(haha);
	Node temp = root;
	insertHelper(root, haha);
    }
	
    public void insertHelper(Node temp, int haha) {
	if (haha <= temp.getData() ) {
	    if (temp.getLeft() == null) {
		temp.setLeft(new Node(haha) );
	    }
	    else {
		insertHelper(temp.getLeft(), haha);
	    }
	}
	else {
	    if (temp.getRight() == null) {
		temp.setRight(new Node(haha) );
	    }
	    else {
		insertHelper(temp.getRight(), haha);
	    }
	}
    }

    public String toString() {
	String silky = "";
	Node temp = root;
	silky += root + " ";
	if (temp.hasLeft() ) {
	    silky += "( " + new BinaryTree(temp.getLeft() ) + " )";
	}
	if (temp.hasRight()) {
	    silky += "( " + new BinaryTree(temp.getRight()) + " )";
	}
	return silky;
    }


    public static void main (String[] args) {
	/*
	BinaryTree tinyTree = new BinaryTree();
	BinaryTree swagTree = new BinaryTree(12);
	swagTree.insert(6);
	swagTree.insert(3);
	swagTree.insert(7);
	swagTree.insert(18);
	System.out.println(swagTree);
	*/
    }
}
