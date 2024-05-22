// Dunnatello

import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab2 {
   
	public static void main(String[] args) {
      
		// Static variables
		double smallCost = 8.95;
		double mediumCost = 12.50;
		double largeCost = 15.00;
		
		DecimalFormat twoDigits = new DecimalFormat( "0.00" );
		
		// Input variables
		String customerName;
		int small;
		int medium;
		int large;
		
		// Output variables
		double totalCost;
		
		// Get user input
		Scanner scnr = new Scanner(System.in);
		
		System.out.println( "Enter customer name: " );
		customerName = scnr.next( );
		
		System.out.println( "Enter number of small pizza(s) you want: " );
		small = scnr.nextInt( );
		

		System.out.println( "Enter number of medium pizza(s) you want: " );
		medium = scnr.nextInt( );

		System.out.println( "Enter number of large pizza(s) you want: " );
		large = scnr.nextInt( );
		
		scnr.close( );
		
		// Display output
		System.out.println( "Customer name: " + customerName + "\n" );
		
		// Output pizza amounts
		System.out.println( small + " Small Pizzas @ $" + twoDigits.format( smallCost ) + ": $" + twoDigits.format( smallCost * small ) );
		System.out.println( medium + " Medium Pizzas @ $" + twoDigits.format( mediumCost ) + ": $" + twoDigits.format( mediumCost * medium ) );
		System.out.println( large + " Large Pizzas @ $" + twoDigits.format( largeCost ) + ": $" + twoDigits.format( largeCost * large ) + "\n" );
		
		totalCost = ( smallCost * small ) + ( mediumCost * medium ) + ( largeCost * large );
		
		// Display total cost
		System.out.println( "Subtotal: $" + twoDigits.format( totalCost ) );
		System.out.println( "Tax: $" + twoDigits.format( totalCost * 0.09 ) );
		System.out.println( "Total Amount Due: $" + twoDigits.format( totalCost + ( totalCost * 0.09 ) ) );
		
      
   }
	
}