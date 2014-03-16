import java.lang.Math;

public class Hail {
    
    public static int hail(int n) {
	if (n==1){
	    System.out.println(n);
	    return 1;
	}
	if (n%2 == 0) {
	    System.out.println(n);
	    return (hail (n/2) );
	}
	else 
	    {
		System.out.println(n);
		return hail (3*n + 1);
	    }
    }

    public static int hailLen(int n) {
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
    
    public static int longestHailR(int n) {
	if (n <= 0)
	    return 0;
	if (n == 1)
	    return 1;
	if (helperlongestHailR(n) > helperlongestHailR(n-1) )
	    return n;
	else
	    return longestHailR(n-1);
    }

    public static int helperlongestHailR(int n) {
	if (n <= 1) {
	    return 1;
	}
	return Math.max( hailLen(n), helperlongestHailR(n-1) );
    }

    public static int longestHail(int n) {
	int maxNum = 0;
	int maxVal = 0;
	for (int i = 1; i <= n; i++) {
	    if (hailLen(i) > maxNum) {
		/* debug
		System.out.println("turtles");
		System.out.print("maxNum:");
		System.out.println(maxNum);
		System.out.print("currentVal:");
		System.out.println(hailLen(i));
		System.out.print("index:");
		System.out.println(i);
		*/
				   
		maxVal = i;
		maxNum = hailLen(i);
	    }
	}
	return maxVal;
    }

    public static void main (String[] args) {
	System.out.println("LOLOLOLOLOL");
	//hail(7);
	System.out.println( longestHail(7) );
	System.out.println( longestHailR(7) );
	System.out.println();
	System.out.println( longestHail(9) );
	System.out.println( longestHailR(9) );
	System.out.println();
	System.out.println( longestHail(4) );
	System.out.println( longestHailR(4) );
	System.out.println();
	
	//for (int n = 1; n <= 4; n++) {
	//    System.out.println(hailLen(n) );
	//}
	
    }
}
