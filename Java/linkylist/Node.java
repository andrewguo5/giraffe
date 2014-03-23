
public class Node <T> {

    private T data;
    private Node <T> next;

    public Node (T s) {
	data = s;
    }

    public Node <T> getNext() {
	return next;
    }
    
    public T getData() {
	return data;
    }

    public void setData (T data) {
	this.data = data;
    }

    public void setNext(Node <T> next) {
	this.next = next;
    }

    public String toString() {
	return data.toString();
    }

}