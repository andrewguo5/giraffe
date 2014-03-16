import java.lang.*;

public class Quicksort {

    public static void quicksort (int[] L) {
	quicksort(L, 0, L.length-1);
    }

    public static void quicksort (int[]L, int left, int right) {

	if (right - left < 2) {
	    return;
	}
	else {
	    int partIndex = partition(L, left, right);
	    //debug
	    /*
	    System.out.println("partIndex: " + partIndex);
	    for (int n = 0; n < L.length; n++) {
		System.out.print(n);
		System.out.print(": ");
		System.out.println(L[n]);
	    }
	    */
	    quicksort(L, left, partIndex - 1);
	    quicksort(L, partIndex +1, right);
	}
    }


    public static int partition (int[] L, int left, int right) {
	int partIndex = (int)(Math.random()*(right-left))+left;
	int pivotVal  = L[partIndex];
	int lastval   = right;
	swap (L, partIndex, right);
	right--;
	while (right-left>0) {
	    if (L[left]<=pivotVal) {
		left++; }
	    else { 
		swap(L,left,right);
		right--; } } 	
	if (L[left]>pivotVal) {	
	    swap (L,right,lastval);
	    return right; }
	else {
	    swap (L,right+1,lastval);
	    return right+1; }
    }

    public static void swap (int[] L, int index1, int index2) {
	int temp = L[index2];
	L[index2] = L[index1];
	L[index1] = temp;
    }

    public static void main (String[] args) {
	
	int[] testarray = {1,0,5,6,2,9,3,4,6,1,7,6,8,4,8,4,7};
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(":\t");
	    System.out.println(testarray[n]);
	}
	System.out.println();
	quicksort(testarray);
	
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(":\t");
	    System.out.println(testarray[n]);
	}
	System.out.println();
	

    }
}
