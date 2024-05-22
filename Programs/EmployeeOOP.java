// Dunnatello

import java.text.DecimalFormat;

public class Lab3OOP {	
	
	public static void main ( String[] args )
	{		
		// Create an instance of the Employee class by sending the name "Smith, Mary" as an argument to the constructor.

		Employee MarySmith = new Employee( "Smith, Mary" );
		
		// Set a salary for employee object to 100000
		MarySmith.setSalaryOfEmployee( 100000 );
		
		
		// Set the years of service of employee object to 15
		MarySmith.setYearsOfService( 15 );
		
		
		// Display employee object using Employee class method toString
		System.out.println( MarySmith.toString( ) );
								
	}// End main.

}// End Lab4OOP

//**************************************************************************************
class Employee {
	
	// Define private instance variables for the Employee class (name, salary, years, bonus)
	String employeeName;
	private int salaryOfEmployee = 0;
	private int yearsOfService = 0;
	private double bonus = 0;
	
	DecimalFormat twoDigits = new DecimalFormat("$0,000.00");
		
	// Define a constructor that takes employee's name as a String parameter
	public Employee( String name ) {
		
		setNameOfEmployee( name );
	
	}
	
	// Define set methods (mutators) for each instance variable
	public void setNameOfEmployee( String name ) {
		
	   employeeName = name;
	   
	}
	

	public void setSalaryOfEmployee( int newSalary ) {
		
		salaryOfEmployee = newSalary;
		
	}
	
	public void setYearsOfService( int totalYears ) {
		
		yearsOfService = totalYears;
		
	}
	
	// Define get methods (accessors) for each instance variable
	
	public int getSalary( ) { 
		
		return salaryOfEmployee;
		
	}
	
	public int getYearsOfService( ) {
		
		return yearsOfService;
		
	}
	
	public double getBonus( ) {
		
		calculateBonus( );
		return bonus;
		
	}
	
	public String getEmployeeName( ) {
		
		return employeeName;
		
	}
	
	// Define a void method named calculateBonus which has no parameters and updates the instance variable for bonus with formula:
	//  yearsOfService multiplied by 2% of the employee salary
	
	public void calculateBonus( ) {
		
		bonus = yearsOfService * ( salaryOfEmployee * 0.02 );
		
	}
	
	// Define the toString method which returns output exactly as indicated in the requirements:
	// Smith, Mary has a salary of: $100,000.00 and 15 years of service
	// Your Bonus this year: $30,000.00
   public String toString()
	{
	   
	   
		return employeeName + " has a salary of: " + twoDigits.format( salaryOfEmployee ) + " and "
							  + yearsOfService + " years of service" + "\n" +
							  "Your Bonus this year: "+ twoDigits.format( getBonus( ) );
	}
	
}// End Employee class

//**************************************************************************************

