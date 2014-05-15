
public class RunningMedian 
{
    private int _median;
    
    public static void swapmagic (int[] a, int qturtle, int giraffe) 
    {
	int temp = a[qturtle];
	a[qturtle] = a[giraffe];
	a[giraffe] = temp;
    }

    //HEAPMAGIC//
    //Turns an array into a heap//
    public static void heapmagic (int[] a) 
    {
	//if less than i/2, then push up!
	int i = 0;
	while (i < a.length) {
	    if (i != 0 && a[i] > a[i/2]) {
		int n = i;
		while (n > 0 && a[n] > a[n/2]) {
		    swapmagic(a, n, n/2);
		    n /= 2;
		}
	    }
	    i++;
	}
    }

}
