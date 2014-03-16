public class Mergesort {

    public static int[] mergesort(int[] turtleArray) {
	//System.out.println("giraffes"); debug
	if (turtleArray.length < 2)
	    return turtleArray;
	else {
	    int[] leftArray, rightArray;
	    leftArray = new int[turtleArray.length/2];
	    rightArray = new int[turtleArray.length - leftArray.length];
	
	    copy(turtleArray, 0, leftArray, 0, leftArray.length);
	    copy(turtleArray, leftArray.length, rightArray, 0, rightArray.length);
	
	    /*for (int n : leftArray)
		System.out.println(n);   
		for (int n : rightArray)
		System.out.println(n); debug
	    */
	    mergesort(leftArray);
	    mergesort(rightArray);
	    
	    copy(merge(leftArray, rightArray), 0, turtleArray, 0, turtleArray.length);
	    return turtleArray;
	}
    }

    public static int[] merge (int[] a, int[] b) {
	int[] pile = new int[a.length + b.length];
	int aCtr = 0;
	int bCtr = 0;
	int n = 0;
	while (aCtr < a.length && bCtr < b.length) {
	    if (a[aCtr] < b[bCtr]) {
		pile[n] = a[aCtr];
		aCtr++;
	    }
	    else {
		pile[n] = b[bCtr];
		bCtr++;
	    }
	    n++;
	}
	while (aCtr < a.length) {
	    pile[n] = a[aCtr];
	    aCtr++;
	    n++;
	}
	while (bCtr < b.length) {
	    pile[n] = b[bCtr];
	    bCtr++;
	    n++;
	}
	return pile;
    }//end merge

    public static void copy(int[] src, int start, int[] dest, int begin, int amt) {
	for (int n = 0; n < amt; n++) {
	    dest[begin + n] = src[start + n];
	}
    }

      public static void main (String[] args) {
	int[] a = {1, 2, 6, 7, 9, 13};
	int[] b = {13, 9, 7, 6, 2, 1};
	int[] unsorted = {6, 13, 47, 11, 3, 28, 5, 23, 18};
        int[] sorted = mergesort(unsorted);
	for (int n: unsorted) {
	    System.out.println(n);
	}
	/*
	int[] b = {4, 6};
	int[] c = {0, 0, 0, 0, 0, 0};
	Mergesort d = new Mergesort();
	copy(a, 0, c, 0, 3);
	for (int n : c) {
	    System.out.println(n);
	}
	//int[] ans = c.merge(a, b) ;
	//for (int n : ans) {
	//    System.out.println(n);
	//}
	*/
	}
}//
