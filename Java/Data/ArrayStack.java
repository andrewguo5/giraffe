import java.util.*;

public class ArrayStack<E> {

    private Object[] stack;
    private int size;

    public ArrayStack() {
	stack = new Object[1024];
	size = 0;
    }

    public boolean empty() {
	return (size==0);
    }

    public E peek() {
	if (size > 0) {
	    return (E)stack[size-1];
	}
	else {
	    throw new  EmptyStackException() ;
	}
    }

    public E pop() {
	E val = peek();
	size--;
	if (4*size < stack.length) {
	    shrink();
	}
	return val;
    }

    public E push(E item) {
	if (size == stack.length) {
	    grow();
	}
	stack[size] = item;
	return item;
    }

    public void grow() {
	Object[] newStack = new Object[stack.length*2];
	for (int n = 0; n < stack.length; n++) {
	    newStack[n] = stack[n];
	}
	stack = newStack;
    }

    public void shrink() {
	Object[] newStack = new Object[stack.length/2];
	for (int n = 0; n < stack.length; n++) {
	    newStack[n] = stack[n];
	}
	stack = newStack;
    }

    public int search(Object o) {
	int val = 1;
	for (int i = size-1; i < 0; i--) {
	    if (stack[i].equals(o) ) {
		return val;
	    }
	    else {
		val++;
	    }
	}
	return -1;		    
    } 
    

}
