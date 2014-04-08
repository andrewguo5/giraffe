import java.util.*;

public class Calculator<E> {

    private class MyStack<E> {
	private class Node<E> {
	    E data;
	    Node<E> next;
	    public Node (E d) {
		this.data = d;
	    }
	    public String toString() {
		return "" + data;
	    }
	    
	    public void setData(E d) {data = d;}
	    public E getData() {return data;}

	    public void setNext (Node<E> n) {next = n;}
	    public Node<E> getNext() {return next;}
	}	
	private Node<E> top;	
	public MyStack() {
	    top = null;
	}
	public boolean empty() {
	    return (top == null);
	}
	public E peek() {
	    if (empty() ){
		throw new EmptyStackException();
	    }
	    else {
		return top.getData();
	    }
	}
	public E pop() {
	    Node<E> tmp = new Node<E> (peek() );
	    top = top.getNext();
	    return tmp.getData();
	}
	public E push (E item) {
	    Node<E> tmp = top;
	    top = new Node<E>(item);
	    top.setNext(tmp);
	    return item;
	}	
	public int search (Object o ) {
	    Node<E> tmp = top;
	    int n = 1;
	    while (!tmp.getData().equals(o)) {
		tmp = tmp.getNext();
		n++;
	    }
	    return n;
	}
	public String toString() {
	    String retStr = "";
	    Node<E> tmp = top;
	    while (tmp!=null) {
		retStr += tmp.getData() + "\n";
		tmp = tmp.getNext();
	    }
	    return retStr;
	}
    }

    private MyStack<Double> stack;
    private int stackLen = 0;

    public Calculator() {
	stack = new MyStack<Double>();	
    }

    public void inc() {	stackLen++;    }
    public void dec() {	stackLen--;    }    

    public void add() {	
	Double val;
	if (stackLen == 1) {val = new Double(0); stackLen++;}
	else {val = stack.pop();}
	stack.push( stack.pop() + val );
    }

    public void subtract() {
	Double val;
	if (stackLen == 1) {val = new Double(0); stackLen++;}
	else {val = stack.pop();}
	stack.push( stack.pop() - val);
    }

    public void multiply() {
	Double val;
	if (stackLen == 1) {val = new Double(0); stackLen++;}
	else {val = stack.pop();}
	stack.push( stack.pop() * val );
    }

    public void divide() {
	Double val;
	if (stackLen == 1) {val = new Double(0); stackLen++;}
	else {val = stack.pop();}
	stack.push( stack.pop() / val );
    }

    public void push(Double val) {
	stack.push(val);
    }

    public void result() {
	System.out.println(">>>" + stack.peek() );
    }

    public String toString() {
	return stack.toString();
    }

    public static void main (String[] args) {
	
	Scanner in = new Scanner(System.in);
	Calculator calc = new Calculator();

	while (true) {
	    try {
		if (!in.hasNextDouble() ) { 

		    String oper = in.next();
		    switch (oper) {
		    case "+":
			calc.add();
			calc.dec();
			break;
		    case "-":
			calc.subtract();
			calc.dec();
			break;
		    case "*":
			calc.multiply();
			calc.dec();
			break;
		    case "/":
			calc.divide();
			calc.dec();
			break; 
		    default:
			System.out.println("Invalid Input");
			break;
		    }
		
		    calc.result();
		}
		else {
		    calc.push( Double.parseDouble( in.next() ) );
		    calc.inc();
		}
	    }
	    catch (EmptyStackException e) {
		calc.push( new Double(0) );
		calc.result();
	    }

	    
	}//while
    }
}
