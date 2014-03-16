public class Merge {

    public int[] merge (int[] a, int[] b) {
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

    public static void main (String[] args) {
	int[] a = {1, 2, 6, 7, 9, 13};
	int[] b = {4, 6};
	Merge c = new Merge();
	int[] ans = c.merge(a, b) ;
	for (int n : ans) {
	    System.out.println(n);
	}

    }
}//
