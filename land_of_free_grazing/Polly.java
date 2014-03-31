//Andrew Guo
//Period 6

import java.util.*;
import java.io.*;


public class Polly {

    static String input = "7\nABCABCABCABC\nABCABCABCA\nABBABCABCABCA\nABCABCABA\nABABCABA\nFF\nABCABCABCABCFF"; //sample input;

    public static String getLast (String line, int n) {//helper
	return line.substring(line.length() - n);
    }
    
    public static String getSequence(String line) {//gets the seqence 
	
	String sequence = line.substring(line.length() - 1);
	String nline = line.substring(0, line.length() - 1);
	int seqlength = 1;
	int n = nline.length();
	boolean badDay = true;
	while (n - seqlength >= 0) {
	    if (getLast(nline, seqlength).equals(sequence) ) { //if the last n match
		badDay = false;
		break; //we're done
	    }
	    else {
		sequence = getLast(nline, 1) + sequence; //must be more to seq
		seqlength = sequence.length();	
		n -= 1;
		if (n < 0) break;;
		nline = nline.substring(0, n); //truncate the line being anlyzd
	    }
	} //after this we have our seq string
	if (badDay) {
	    return "0"; //polly only reads letters. this is a number.
	}
	return sequence;
    }    

    //returns the number of letters in sequence that polly said before she was interrupted
    public static int interruptedNum (String line, String seq) {
	int n = 0;
	int i = 1;
	int firstOccurence = line.indexOf(seq);

	String nline = line.substring(0, firstOccurence); //the part before the seqence starts

	boolean matches = true;
	while (matches && i <= firstOccurence) {
	    //System.out.println("giraffe");
	    if (getLast(seq, i).equals(getLast(nline,i))) {
	
		n++;
		i++;
	
	    }
	    else {matches = false;}
	}
	return n;
    }

    public static String swap (String seq, int n) {//rotates the seqence 
	String retStr = seq;
	while (n > 0) {
	    String last = retStr.substring(seq.length() - 1);
	    retStr = last + retStr.substring(0, seq.length() - 1);
	    n--;
	}
	return retStr;
    }

    public static String output (String line) { //processes the line

	String retStr = "";
	String seq = getSequence(line); //get the seqence

	if (seq.equals("0") ){
	    return "Polly had a bad day"; //if no seqence, return bad day
	}
	else{ 
	    int intrptNum = interruptedNum(line, seq); //find the excess to the sequence (polly was interrupted, she said part of the sequence but did not finish)
	    seq = swap(seq, intrptNum); //find right sequence order by rotating the sequence
	    retStr += seq;
	    retStr += " ";
	    retStr += line.indexOf(seq);
	    return retStr; //add them up and return;
	}
    }

    public static void main (String[] args) {

	    
	Scanner in = new Scanner (System.in) ;
	//Scanner in = new Scanner (input);

	int numDays = in.nextInt();
	String[] sequences = new String[numDays];
	for (int n = 0; n < numDays; n++ ) {
	    sequences[n] = output(in.next());
	}
	for (String output : sequences) {
	    System.out.println(output);
	}	    

    }

}
