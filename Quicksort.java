import java.lang.*;

public class Quicksort {

    //If no additional parameters are given, the quicksort runs on the whole array
    public static void quicksort (int[] L) {
	quicksort(L, 0, L.length-1);
    }

    public static void quicksort (int[]L, int left, int right) {

	if (right - left < 2) {
	    return;
	}
	else {
	    int[] partIndex = partition(L, left, right);
	    quicksort(L, left, partIndex[0] - 1);
	    quicksort(L, partIndex[1] +1, right);
	}
    }


    public static int[] partition (int[] L, int left, int right) {
	int[] retAry = new int[2];

	//Assign a random index value to function as a pivot
	int partIndex = (int)(Math.random()*(right-left))+left;
	int pivotVal  = L[partIndex];

	//Holds on to the initial right side boundary index value
	int lastval   = right;
	
	//Swaps the value at the pivot index to the end
	swap (L, partIndex, lastval);
	right--;

	//a value to count the number of duplicates.
	int dupCtr = 0;

	while (right - left > 0) {
	    //increments the duplicate number if the function encounters a duplicate
	    if (L[left] ==pivotVal) {
		dupCtr++;
		swap(L, left, right);
	    }
	    //ignores values that are smaller than the pivot
	    if (L[left] < pivotVal) {
		left++; }
	    //swaps values that are larger than the pivot to the right side
	    else { 
		swap(L,left,right);
		right--; } */
		} 	
	//swaps the pivot index with the median value if it is larger than the pivot
	if (L[right] > pivotVal) {	
	    swap (L,right,lastval);
	    //if there are n number of duplicates, then return the lower and upper bounds of where the duplicates start and end in the array
	    retAry[0] = right - dupCtr;
	    retAry[1] = right;
	    return retAry; }
	//if the pivot index is the same as the value, first increment dupCtr (since the previous while loop terminated before looking at this value), then swap the next value over out for the index value. then return the upper and lower bounds of the interval where duplicates start and end in the array.
	else if (L[right] == pivotVal) {
	    dupCtr++;
	    swap (L,right+1,lastval);
	    //return right+1 - dupCtr/2; }
	    retAry[0] = right + 1 - dupCtr;
	    retAry[1] = right + 1;
	    return retAry; }
	//the last case is if the index value is smaller than the pivot value. then, swap out this value for the first occurence of the duplicates in the array, so all the duplicates are adjacent to one another.
	else {
	    swap(L, right, right - dupCtr);
	    swap(L, right+1, lastval);
	    retAry[0] = right + 1 - dupCtr;
	    retAry[1] = right + 1;
	    return retAry;
	}
    }


    //Swap helper method
    public static void swap (int[] L, int index1, int index2) {
	int temp = L[index2];
	L[index2] = L[index1];
	L[index1] = temp;
    }

    //testing loops
    public static void main (String[] args) {
	/*
	  int arrayLength = Integer.parseInt(args[0]);
	  int[] testarray = new int[arrayLength];
	  for (int n = 0; n < testarray.length; n++) {
	  testarray[n] = 2;
	  }
	*/
	int[] testarray = {1,5,4,2,5,3,5,4,6,3,2,5,5,3,6,7,5,7,3,6,5,7,8,2,5,7,5,5,5};
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(":\t");
	    System.out.println(testarray[n]);
	}
	System.out.println();
	long time1 = System.currentTimeMillis();
	quicksort(testarray);
	long time2 = System.currentTimeMillis();
	
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(":\t");
	    System.out.println(testarray[n]);
	}
	System.out.println();
	
	long difference = time2 - time1;
	System.out.println(difference);
	

    }
}
