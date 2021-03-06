import java.lang.*;

public class Quicksort {

    public static void quicksort (int[] L) {
	quicksort(L, 0, L.length-1, 0.5);
    }

    public static void quicksort (int[] L, int left, int right) {
	if (right - left < 1) {
	    return;
	}
	else {
	    int partIndex = partition(L, left, right);
	    quicksort(L, left, partIndex -1, pass);
	    pass+= 0.5;
	    quicksort(L, partIndex+1, right, pass);
	}
    }


    public static int partition (int[] L, int left, int right) {
	//Assigns a random pivot index, and records the value at the index.
	int partIndex = (int)(Math.random()*(right-left))+left;
	int pivotVal = L[partIndex];

	//Iterates through an array, moving smaller elements to the left,
	//larger elements to the right, and leaving the elements equal to
	//the pivot in the middle.
	int i = left;
	while (right - i >= 0) {
	    if (L[i] == pivotVal) {
		i++;
	    }
	    else if (L[i] < pivotVal) {
		swap (L, left, i);
		i++;
		left++; }
	    else if (L[i] > pivotVal ) { 
		swap(L, i, right);
		right--; } 
	}
	//returns the index of the median pivot value;
	return (right + left)/2;
    }

    //Helper swap function
    public static void swap (int[] L, int index1, int index2) {
	int temp = L[index2];
	L[index2] = L[index1];
	L[index1] = temp;
    }

    public static void main (String[] args) {
	
	int arrayLength = Integer.parseInt(args[0]);
	int variance = Integer.parseInt(args[1]);
	int[] testarray = new int[arrayLength];
	for (int n = 0; n < testarray.length; n++) {
	    //testarray[n] = 2;
	    testarray[n] = (int)(Math.random() * variance);
	}    
	 	
	long time1 = System.currentTimeMillis();

	/*	int[] testarray = {1,2,23,4,5,6,1,3,4,5,6,6,34,5,7,85,3,3,4,4,5,6,1,3,4,3,6,8,9,7,5,3,2};	
		for (int n = 0; n < testarray.length; n++) {
		System.out.print(n);
		System.out.print(":\t");
		System.out.println(testarray[n]);
		}
		System.out.println();
	  */
	  quicksort(testarray);
	  //int partitionVals = partition(testarray, 0, testarray.length-1);	
	  //System.out.println(partitionVals);
	  /*
	    for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(":\t");
	    System.out.println(testarray[n]); 
	    }
	    System.out.println();*/
        
	  long time2 = System.currentTimeMillis();
	  long difference = time2 - time1;
	  System.out.println(difference);

    }
}
