import java.util.*;

public class Sorts{

    public static String name(){
        return "Guo,Andrew";
    }

    ////////////////////////////////////////
    ////////////////QUICKSORT///////////////
    ////////////////////////////////////////
    public static void quicksort (int[] L) {
	quicksort(L, 0, L.length-1);
    }
    public static void quicksort (int[] L, int left, int right) {
	if (right - left < 1) {
	    return;
	}
	else {
	    int partIndex = partition(L, left, right);
	    quicksort(L, left, partIndex -1);
	    quicksort(L, partIndex+1, right);
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
    //END QUICKSORT//






    ////////////////////////////////////////
    ////////////////MERGESORT///////////////
    ////////////////////////////////////////
    public static void msort(ArrayList<String> L){
	if (L.size() < 2)
	    return;
	else {
	    //Creates two arrays
	    ArrayList<String> turtleArray = new ArrayList<String>();
	    ArrayList<String> giraffeArray= new ArrayList<String>();

	    addOver(L, 0, turtleArray, L.size()/2);
	    addOver(L, turtleArray.size(), giraffeArray, (L.size() + 1)/2);
	    
	    msort(turtleArray);
	    msort(giraffeArray);

	    copy(merge(turtleArray, giraffeArray), 0, L, 0, L.size() );

	}
     }
    public static ArrayList<String> merge (ArrayList<String> a, ArrayList<String> b) {
	ArrayList<String> pile = new ArrayList<String>();
	int aCtr = 0;
	int bCtr = 0;
	//int n = 0;
	while (aCtr < a.size() && bCtr < b.size() ) {
	    if (a.get(aCtr).compareTo( b.get(bCtr) ) < 0) {
		pile.add( a.get(aCtr) );
		aCtr++;
	    }
	    else {
		pile.add( b.get(bCtr) );
		bCtr++;
	    }
	    //n++;
	}
	while (aCtr < a.size() ) {
	    pile.add( a.get(aCtr));
	    aCtr++;
	    // n++;
	}
	while (bCtr < b.size()) {
	    pile.add( b.get(bCtr)) ;
	    bCtr++;
	    // n++;
	}
	return pile;
    }//end merge

    //Copying/modifying helper functions for MergeSort
    public static void addOver(ArrayList<String> src, int start, ArrayList<String> dest, int amt) {
	for (int n = 0; n < amt; n++ ) {
	    dest.add(src.get(n+start) );
	}
    }
    public static void copy (ArrayList<String> src, int start, ArrayList<String> dest, int begin, int amt) {
	for (int n = 0; n < amt; n++) {
	    dest.set(n+begin, src.get(n+start) );
	}
    }

    /*  public static void main (String[] args ) {
	
	ArrayList<String> r1 = new ArrayList();
	r1.add("hello"); r1.add("goodbye");
	ArrayList<String> r2 = new ArrayList();
	r2.add("ancient"); r2.add("farewell");
	System.out.println(r1);
	System.out.println(r2);
	System.out.println(merge(r1, r2));
	

	ArrayList<String> unsorted = new ArrayList<String>();
	unsorted.add("watashi");
	unsorted.add("orewa");
	unsorted.add("moshimoshi");
	unsorted.add("montana");
	unsorted.add("purplefish");
	unsorted.add("neuroscience");
	unsorted.add("applesauce");
	System.out.println(unsorted);
	msort(unsorted);
	System.out.println(unsorted);
    }*/
}
