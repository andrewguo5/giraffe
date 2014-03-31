import java.lang.Math;

public class recursion{
    public String lastName(){
        /*change this! to your name*/
        return "Guo";
    }
    public String firstName(){
        /*change this! to your name*/
        return "Andrew";
    }
    public int hailLen(int n){
       
	if (n <= 0) {
	    System.out.println ("n must be a positive integer");
	    return 0;
	}
	if (n == 1) {
	    return 1;
	}
	else if (n%2 == 0) {
	    return 1 + hailLen(n/2);
	}
	else {
	    return 1 + hailLen(3*n + 1);
	}
    }

    public int longestHail(int n){
	if (n <= 0)
	    return 0;
	if (n == 1)
	    return 1;
	if (helperlongestHailR(n) > helperlongestHailR(n-1) )
	    return n;
	else
	    return longestHail(n-1);
    }
    public int helperlongestHailR(int n) {
	if (n <= 1) {
	    return 1;
	}
	int val = hailLen(n);
	return Math.max( val, helperlongestHailR(n-1) );
    }
    public int fibItr(int n){
	if (n==0) return 0;
	if (n==1) return 1;
	return fibhelp(0, 1, n-2);
    }

    public static int fibhelp(int a, int b, int n) {
	if (n==0) return a + b;
	else return fibhelp(b, a+b, n-1);	
    }

    public recursion(){
        /*leave alone*/
    }
}
