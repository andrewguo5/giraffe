public class Recursion {

    //O(n)
    public static long factorial(long n) {
	if (n == 0) {return 1;}
	else 
	    return n * factorial(n - 1);
    }

    public static long fib(long n) {
	if (n==0) {return 0;}
	else if (n==1) {return 1;}
	else 
	    return fib(n-1) + fib(n-2);
    }

    public static long fibIter(long n) {
	long a = 0;
	long b = 1;
	while (n > 1) {
	    long temp = a + b;
	    b = a;
	    a = temp;
	    n--;
	}
	return a + b;	
    }


    public static int fibIterR(int n) {
	if (n==0) return 0;
	if (n==1) return 1;
	return fibhelp(0, 1, n-2);
    }

    public static int fibhelp(int a, int b, int n) {
	if (n==0) return a + b;
	else return fibhelp(b, a+b, n-1);	
    }

    public static void main (String[] args) {
	System.out.println(factorial(4));
	System.out.println(factorial(5));
	
	System.out.println("");

	System.out.println(fib(1));
	System.out.println(fib(2));
	System.out.println(fib(3));
	System.out.println(fib(4));
	System.out.println(fib(5));

	System.out.println(fibIter(1));
	System.out.println(fibIter(2));
	System.out.println(fibIter(3));
	System.out.println(fibIter(4));
	System.out.println(fibIter(5));

	System.out.println(fibIterR(1));
	System.out.println(fibIterR(2));
	System.out.println(fibIterR(3));
	System.out.println(fibIterR(4));
	System.out.println(fibIterR(5));
    }
}