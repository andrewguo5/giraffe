import java.lang.*;

public class Quickselect {

    public static int quickselect(int[] L, int k) {

	return quickselect(L, 0, L.length-1, k);
    }

    public static int quickselect (int[] L, int left, int right, int k) {
	
	if (right - left < 1) {
	    return L[left];
	}
	
	else {
	    int partIndex = partition(L, left, right);	

	    //debug
	    /*
	    System.out.print("Partition value: ");
	    System.out.println(partIndex);
	    for (int n = 0; n < L.length; n++) {
		System.out.print(n);
		System.out.print(": ");
		System.out.println(L[n]);
	    }
	    System.out.println();
	    */
	    if (k == partIndex) {
		//	System.out.println("k == partIndex, returning L[k]");
		return L[k];
	    }
	    if (k < partIndex) {
		//	System.out.println("k is less than partIndex");
		return quickselect(L, left, partIndex-1, k);
	    }
	    else {
		//	System.out.println("k is greater than partIndex");
		return quickselect(L, partIndex + 1, right, k);
	    }
	}	
    }
    
    public static int partition (int[] L, int left, int right) {

	int partIndex = (int)(Math.random() * (right - left) ) + left;
	int pivotVal  = L[partIndex];
	int lastval   = right;

	swap (L, partIndex, right);
	right--;

	while (right - left > 0) {
	    if (L[left] <= pivotVal) {
		left++;
	    }
	    else {
		swap(L, left, right);
		right--;
	    }
	}
	if (L[left] > pivotVal) {	
	    swap (L, right, lastval);
	    return right;
	}
	else {
	    swap (L, right+1, lastval);
	    return right+1;
	}
    }

    public static void swap (int[] L, int index1, int index2) {
	int temp = L[index2];
	L[index2] = L[index1];
	L[index1] = temp;
    }

    public static void main (String[] args) {
	/* test for partition method

	int[] testarray = {6, 3, 4, 1, 5, 8, 7, 2, 9, 0};
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(": ");
	    System.out.println(testarray[n]);
	}

	System.out.println(partition(testarray, 0, testarray.length-1 ));
	for (int n = 0; n < testarray.length; n++) {
	    System.out.print(n);
	    System.out.print(": ");
	    System.out.println(testarray[n]);
	}
		 */

	/* test for quickselect
	int[] testarray1 = {6, 3, 4, 1, 5, 8, 7, 2, 9, 0};
	for (int n = 0; n < testarray1.length; n++) {
	    System.out.print(n);
	    System.out.print(": ");
	    System.out.println(testarray1[n]);
	}
	System.out.println();
	
	System.out.println(quickselect(testarray1, 7) );
	for (int n = 0; n < testarray1.length; n++) {
	    System.out.print(n);
	    System.out.print(": ");
	    System.out.println(testarray1[n]);
	}

	*/
    }  

}

