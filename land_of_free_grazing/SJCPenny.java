//Andrew Guo
//Period 6

import java.util.*;
import java.io.*;

public class SJCPenny {

    public static void main (String[] args) {

	Scanner in = new Scanner (System.in);
	int numItems = in.nextInt();

	//Put the names of the items and the prices in two separate arrays
	String[] items = new String[numItems];
	double[] prices = new double[numItems];
	for (int n = 0; n < numItems; n++) {
	    items[n] = in.next();
	    while (!in.hasNextDouble() ) {
		items[n] = items[n] + " " + in.next();
	    }
	    prices[n] = in.nextDouble();
	}
	
	//Find the total price, before discounts, of the items.
	double originalPrice = 0;
	for (double price : prices) {
	    originalPrice += price;
	}
	
	//Find the discount price.
	double discountedPrice = originalPrice;
	if ( originalPrice >= 100 ){
	    discountedPrice -= 10;
	}

	//Find the rate of discount.
	double discountRate = discountedPrice/(double)originalPrice;
       
	//Modify the prices of each item based on the rate of discount.
	double totalPrice = 0;
	for (int n = 0; n < numItems-1; n++) {
	    prices[n] *= discountRate;
	    prices[n] = Math.round(prices[n]*100)/100.0;
	    totalPrice += prices[n];
	}
	//Round the discounted prices to two decimal places
	prices[numItems-1] = discountedPrice - totalPrice;
	prices[numItems-1] = Math.round(prices[numItems-1]*100)/100.0;
	totalPrice += prices[numItems-1];
	totalPrice = Math.round(totalPrice*100)/100.0;

	//Print the names, followed by the prices, and finall the total price.
	for (int n = 0; n < numItems; n++) {
	    System.out.println(items[n] + "\t" + prices[n]);
			       
	}
	System.out.println("TOTAL\t" + totalPrice);	
	
    }   
    


}
