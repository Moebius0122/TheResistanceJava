package rules;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Entry {
	public static void main(String[] args) {

		final Scanner scan = new Scanner(System.in); //Scanner that will read all input. Is sent cascading through all classes that need it.
		
		GameState the_state = initGame(scan); // Initialize the game using the scanner from above.
		
		boolean spy_win = the_state.PlayAGame(scan); // Run the game. Returns true if the spies win the game.
		
		if(!spy_win){
			
			System.out.println("The resistance succeeded! The filthy spies couldn't sabotage enough missions.");
			
		}
		
		scan.close();
		
	}

	
		public static GameState initGame(Scanner scan){
			
			

			//Set the spies and let them know of each other.
			
			int spy_one, spy_two=0;
			
			int[] spies = {0, 0, 0, 0, 0};
			
			int[] other_spy = {0, 0, 0, 0, 0};
			
			Random rand = new Random();
			
			spy_one = rand.nextInt(5);
			
			spies[spy_one] = 1;
			
			while(spy_two == spy_one||spy_two == 0){ //Make sure the to not select the same player as a spy twice.
				
				spy_two = rand.nextInt(5);
				
				spies[spy_two] = 1;
				
			}
			
			//Let the other spy know who is their partner.
			other_spy[spy_one] = spy_two;
			
			other_spy[spy_two] = spy_one;
				
			
			
			//Select for each player the corresponding AI or designate it as a human player
			
			int[] player_select = new int[5];
			
			//Initiate factory class
			
			PlayerFactory factory = new PlayerFactory();
			
			for (int i=0; i<5; i++){
				
				player_select[i]=ScanForPlayers(i,scan);
				
			}
			
			//Create all Players
			Player p_one = factory.getPlayer(spies[0], player_select[0], 0, other_spy[0]);
			Player p_two = factory.getPlayer(spies[1], player_select[1], 1, other_spy[1]);
			Player p_three = factory.getPlayer(spies[2], player_select[2], 2, other_spy[2]);
			Player p_four = factory.getPlayer(spies[3], player_select[3], 3, other_spy[3]);
			Player p_five = factory.getPlayer(spies[4], player_select[4], 4, other_spy[4]);
			Player[] players = {p_one, p_two, p_three, p_four, p_five};

			//Initialize the Mission data structures.
			Mission m_one = new Mission(1);
			Mission m_two = new Mission(2);
			Mission m_three = new Mission(3);
			Mission m_four = new Mission(4);
			Mission m_five = new Mission(5);
			Mission[] missions = {m_one,m_two,m_three,m_four,m_five};
			
			//Initialize the VotesForMissionMembers data structures.
			VotesForMissionMembers vote_one = new VotesForMissionMembers();
			VotesForMissionMembers vote_two = new VotesForMissionMembers();
			VotesForMissionMembers vote_three = new VotesForMissionMembers();
			VotesForMissionMembers vote_four = new VotesForMissionMembers();
			VotesForMissionMembers vote_five = new VotesForMissionMembers();
			VotesForMissionMembers[] votes = {vote_one,vote_two,vote_three,vote_four,vote_five};
			
			//Initialize the GameState.
			GameState g_state = new GameState(players, missions, votes);
			

			
			//System.out.println("Player "+ (spy_one+1) +" is a filthy spy!");
			
			//System.out.println("Player "+ (spy_two+1) +" is a filthy spy!");
			
			return g_state;
			
		}
		

		
		private static int ScanForPlayers(int playernumber, Scanner scan){
			
			System.out.println("Please select player " + (playernumber + 1) + " as one of the following:");
			System.out.println("Type 1 for human control.");
			System.out.println("Type 2 for the SimpleAI bot.");
			
			boolean selection_made = false;
			
			do {
				
	            try {

	                int user_imput = scan.nextInt();
	                
	                if(user_imput == 1){
	                	
	                    System.out.println("Player " + (playernumber + 1) + " is human.");
	                    System.out.println("");
	                    
	                    selection_made = true;
	                    
	                    return user_imput;
	                    
	                }else if(user_imput == 2){
	                	
	                    System.out.println("Player " + (playernumber + 1) + " is controlled by the SimpleAI bot.");
	                    System.out.println("");
	                    
	                    selection_made = true;
	                    
	                    return user_imput;
	                    
	                }
	                
	                else System.out.println("Invalid input! Enter a number from 1 to 2.");
	                
	            } catch (InputMismatchException e) {
	            	
	                System.out.println("Invalid input! Enter a number from 1 to 2.");
	                
	            }
	            
	        } while (!selection_made);
			
			return -1;
			
		}
		

}



