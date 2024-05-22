/*
 * Author: Dunnatello
 * Date:   November 22nd, 2020
 * Purpose: To set and display player information on a team
 * 
 * Problem: Work with user input and store/calculate information based upon the data.
 * 
 * Input: Text Document with a list as well as user text input for modification
 * Process: Modify player object data based on user input.
 * Output: Display roster with specified parameters.
 * 
 * UML Diagram:
 * ---------------------------------
 * Player
 * ---------------------------------
 * - playerJerseyNumber: int
 * - playerRank: int
 * - playerLastName: String
 * ---------------------------------
 * 
 * 
 * + Player( )
 * + Player( jerseyNumber: int, playerLastName: String )
 * 
 * + setJerseyNumber( jerseyNumber: int )
 * + setRank( newRank: int )
 * + setLastName( newName: String )
 * 
 * + getJerseyNumber( )
 * + getRank( )
 * + getLastName( )
 * 
 * + toString( )
 * 
 * ---------------------------------
 * Teams
 * ---------------------------------
 * 
 * + main( )
 * + showMenu( )
 * + getSoccerRosterFromFile( )
 * + updateRating( )
 * + showPlayersAboveARank( )
 * + replaceAPlayer( )
 * + findPlayerInArray( numberToFind: int )
 * + sortByJerseyNumber( )
 * + showRoster( maximumRank: int )
 * 
 * Test Plan:
 *	
 *	Unsorted:
 *		
 *		Player		|	Jersey Number
 *		McQueen				96
 *		Smith				 7
 *		Thomas				23
 *		 
 * Sorted (using Insertion Sort):
 *
 *		Player		|	Jersey Number
 *		Smith				 7
 *		Thomas				23
 *		McQueen				96
 *
 * 
 * Pseudocode:
 * 
 * function: showMenu
 * 
 * 		pass in: nothing
 * 
 * 		initialize userInput to -1
 * 		initialize options to a set of array String options
 * 		
 * 		while userInput != options.length - 1
 * 
 * 			get userInput with JOptionPane.showOptionDialog
 * 				
 * 			Case 0
 * 			
 * 				Call updateRating( )
 * 			
 * 			Case 1
 * 				
 * 				Call replaceAPlayer( )
 * 			
 * 			Case 2
 * 				
 * 				Call showPlayersAboveARank( )
 * 
 * 			Case 3
 * 
 * 				Call showRoster( 9999999 )
 * 
 *			End Case
 *
 *	end function showMenu 
 *
 * function: updateRating
 * 
 * 		pass in: nothing
 * 
 * 		initialize userInput to ""
 * 		
 * 		get userInput with JOptionPane.showInputDialog prompt for jersey number
 * 		
 * 		if userInput != null
 * 			
 * 			Call findPlayerInArray( userInput )
 * 			
 * 			get newRank with JOptionPane.showInputDialog prompt for rank
 * 			
 * 			Call setRank( userInput: convert to int ) on the Player object to update rank
 *  
 *	end function updateRating
 *
 */

import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teams {
	
	ArrayList< Player > AllPlayers = new ArrayList< Player >( );
	int PlayerIndexes[ ];
	int JerseyNumbers[ ];
	
	public int findPlayerInArray( int jerseyNumber ) {
		
		int playerLocation = -1;
		
		for ( int i = 0; i < AllPlayers.size( ); i++ ) {
			
			if ( ((Player) AllPlayers.get( i )).getJerseyNumber( ) == jerseyNumber ) {
				
				playerLocation = i;
				break;
				
			}
			
		}
		
		return playerLocation;
		
	}
	
	public boolean isInteger( String newInput ) {
		try {
			
			Integer.parseInt( newInput );
			return true;
		}
		catch ( Exception e ) {
			
			return false;
			
		}
		
	}
	
	public void updateRating( ) {
		
		String userInput = "";
		int playerIndex = -1;
		Player currentPlayer;
		
		userInput = JOptionPane.showInputDialog( "Enter the player's jersey number to update:" );
		
		
		if ( isInteger( userInput ) ) { // Check to make sure input is valid.
			
			playerIndex = findPlayerInArray( Integer.parseInt( userInput ) );
		
		}
		
		if ( playerIndex != -1 ) { // If player was found, modify player rank.
			
			currentPlayer = AllPlayers.get( playerIndex );
			
			userInput = JOptionPane.showInputDialog( "Enter the new rank for " + currentPlayer.getLastName( ) + ":" );
			
			if ( isInteger( userInput ) ) { // Check to make sure input is an integer.
				
				currentPlayer.setRank( Integer.parseInt( userInput ) );
			
				JOptionPane.showMessageDialog( null, "Player rank updated for " + currentPlayer.getLastName( ) + "." );
				
			}

		}
		else { // Player not found
			
			JOptionPane.showMessageDialog( null, "Player not found." );
			
		}
			
	}
	
	public void sortByJerseyNumber( ) { 
		
		// Create two tables to handle player indexes and jersey number sorting.
		PlayerIndexes = new int[ AllPlayers.size( ) ];
		JerseyNumbers = new int[ AllPlayers.size( ) ];
		
		
		for ( int i = 0; i < AllPlayers.size( ); i++ ) { // Copy Jersey Numbers from object ArrayList to another ArrayList
			
			PlayerIndexes[ i ] = i;
			JerseyNumbers[ i ] = AllPlayers.get( i ).getJerseyNumber( );
			
		}
		
		int temp;
		int j;
		
		for ( int i = 1; i < PlayerIndexes.length; i++ ) { // Insertion Sort
			
			j = i;
			
			while ( j > 0 && JerseyNumbers[ j ] < JerseyNumbers[ j - 1 ] ) {
			
				temp = JerseyNumbers[ j ];
				
				JerseyNumbers[ j ] = JerseyNumbers[ j - 1 ];
				JerseyNumbers[ j - 1 ] = temp;
				
				temp = PlayerIndexes[ j ];
				
				PlayerIndexes[ j ] = PlayerIndexes[ j - 1 ];
				PlayerIndexes[ j - 1 ] = temp;
				
				--j;
			}
			
		}
		
		
	}
	
	public void showRoster( int maximumRank ) {
		
		String totalRoster = "";
		Player currentPlayer;
		
		for ( int i = 0; i < JerseyNumbers.length; i++ ) {
			
			currentPlayer = AllPlayers.get( PlayerIndexes[ i ] );
			
			if ( currentPlayer.getRank( ) <= maximumRank ) { 
				
				totalRoster = totalRoster + currentPlayer.toString( );
			
			}
		}
		
		JOptionPane.showMessageDialog( null, totalRoster );
		
	}
	
	public void showPlayersAboveARank( ) {
		
		String userInput = "";
		int desiredRank = 999999;
		
		userInput = JOptionPane.showInputDialog( "Enter the minimum rank required:" );
		
		if ( isInteger( userInput ) ) {
			
			desiredRank = Integer.parseInt( userInput );
			
			showRoster( desiredRank );
			
		}
		
	}

	public void replaceAPlayer( ) {
		
		String userInput = "";
		int playerIndex = -1;
		
		Player currentPlayer;
		
		userInput = JOptionPane.showInputDialog( "Enter the player's jersey number to replace:" );
		
		if ( isInteger( userInput ) ) {
			
			playerIndex = findPlayerInArray( Integer.parseInt( userInput ) );
			
			if ( playerIndex != -1 ) {
				
				currentPlayer = AllPlayers.get( playerIndex  );
				
				userInput = JOptionPane.showInputDialog( "Enter a new name for player " + currentPlayer.getLastName( ) + ":" );
				
				currentPlayer.setLastName( userInput );
				
				userInput = JOptionPane.showInputDialog( "Enter a new jersey number for player " + currentPlayer.getLastName( ) + ":" );
				
				if ( isInteger( userInput ) ) {
					
					currentPlayer.setJerseyNumber( Integer.parseInt( userInput ) );
					
				}
				
				userInput = JOptionPane.showInputDialog( "Enter a new rank for player " + currentPlayer.getLastName( ) + ":" );

				if ( isInteger( userInput ) ) {
					
					currentPlayer.setRank( Integer.parseInt( userInput ) );
					
				}
				
				JOptionPane.showMessageDialog( null, "Player has been modified." );
				
			}
			
		}
		
		sortByJerseyNumber( ); // Sort array since jersey number could have changed.
		
	}
	

	
	public void showMenu( ) {
		
		int userInput = -1;
		String[ ] options = { "Update Player Rank", "Replace Player", "Show Ranked Players", "Show Roster", "Quit" };
		
		while ( userInput != options.length - 1 ) {
		
			userInput = JOptionPane.showOptionDialog( null, "Select an option:", "Soccer Team Menu", 0, 0, null, options, options[ 0 ] );
						
			switch ( userInput ) {
				
				case 0:
				
					updateRating( );
					break;
				
				case 1:
					
					replaceAPlayer( );
					break;
				
				case 2:
					
					showPlayersAboveARank( );
					break;
				
				case 3:
					
					showRoster( 99999999 ); // Large number so that no players get left out.
					break;
			
			}
			
		}
		
	}
	
	public void getSoccerRosterFromFile( ) {
		
		String line = "";
		Scanner aLine = new Scanner( line );
		
		try {
			
			Scanner input = new Scanner( new File( "SoccerPlayers.txt" ) );
			
			// Temp values to use in creating Player objects
			String playerLastName = "NoName";
			
			int playerJerseyNumber = -1;
			int playerRank = -1;
			
			
			
			while( input.hasNextLine( ) == true )
    		{
    			
					
    			line = input.nextLine( );
    			// Create a new Scanner object with one line.
    			
    			aLine = new Scanner(line);
    			// Use a "," delimiter for reading data items from line
    			aLine.useDelimiter(", ");
    			
    			// Assign player last name
    			playerLastName = aLine.next( );
    			
    			// Assign player jersey number
    			playerJerseyNumber = Integer.parseInt( aLine.next( ) );
    			
    			// Assign player rank
    			playerRank = Integer.parseInt( aLine.next( ) );
    			    			
    			AllPlayers.add( new Player( playerJerseyNumber, playerRank, playerLastName ) );
    			
    		}
			
			input.close( );
		}
		catch ( IOException ioe ) {
			
    		System.out.println( "File not found" );
    		
    	}
		
		aLine.close( );
		
		
	}
	
	public static void main( String[] args ) {
		
		Teams newTeam = new Teams( );
		
		newTeam.getSoccerRosterFromFile( );
		newTeam.sortByJerseyNumber( );
		
		newTeam.showMenu( );
		
		
	}

}

class Player {
	
	private int playerJerseyNumber = -1;
	private int playerRank = -1;
	private String playerLastName = "NoName";
	
	public Player( ) {
		
	}
	
	public Player( int jerseyNumber, int playerRank, String playerLastName ) {
		
		playerJerseyNumber = jerseyNumber;
		
		this.playerRank = playerRank;
		this.playerLastName = playerLastName;
		
	}
	
	// Mutator Methods
	public void setJerseyNumber( int jerseyNumber ) {
		
		playerJerseyNumber = jerseyNumber;
		
	}
	
	public void setRank( int newRank ) {
		
		playerRank = newRank;
		
	}
	
	public void setLastName( String newName ) {
		
		playerLastName = newName;
		
	}
	
	// Accessor Methods
	
	public int getJerseyNumber( ) {
		
		return playerJerseyNumber;
		
	}
	
	public int getRank( ) {
		
		return playerRank;
		
	}
	
	public String getLastName( ) {
		
		return playerLastName;
		
	}
	
	public String toString( ) {
		
		return "#" + playerJerseyNumber + " - " + playerLastName + " - Rank: " + playerRank + "\n";
		
	}
	
}