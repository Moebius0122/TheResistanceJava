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
			
			Random rand = new Random();
			
			spy_one = rand.nextInt(5);
			
			while(spy_two == spy_one||spy_two == 0){ //Make sure the to not select the same player as a spy twice.
				
				spy_two = rand.nextInt(5);
				
			}

			//Select for each player the corresponding AI or designate it as a human player
			
			int[] player_select = new int[5];
			Player[] players = new Player[5];
			
			for (int i=0; i<5; i++){
				
				player_select[i]=ScanForPlayers(i,scan);
				
			}
			
			if (spy_one == 0){
				
				if(player_select[0] == 1){
					
					UserPlayer p_one = new UserPlayer(true, 0, spy_two);
					
					players[0] = p_one;
					
				}else if(player_select[1]==2){
					
					SimpleAI p_one = new SimpleAI(true, 0, spy_two);
					
					players[0] = p_one;
					
				}
				
			}else if (spy_two == 1){
				
					if(player_select[0] == 1){
						
						UserPlayer p_one = new UserPlayer(true, 0, spy_one);
						
						players[0] = p_one;
						
					}else if(player_select[1] == 2){
						
						SimpleAI p_one = new SimpleAI(true, 0, spy_one);
						
						players[0] = p_one;
						
					}
					
			}else{
				
				if(player_select[0] == 1){
					
					UserPlayer p_one = new UserPlayer(false, 0, -1);
					
					players[0] = p_one;
					
				}else if(player_select[1] == 2){
					
					SimpleAI p_one = new SimpleAI(false, 0, -1);
					
					players[0] = p_one;
					
				}
				
			}
			

			
			if (spy_one == 1){
				
				if(player_select[1] == 1){
					
					UserPlayer p_two = new UserPlayer(true, 1, spy_two);
					
					players[1] = p_two;
					
				}else if(player_select[1] == 2){
					
					SimpleAI p_two = new SimpleAI(true, 1, spy_two);
					
					players[1] = p_two;
					
				}
				
			}else if (spy_two == 1){
				
					if(player_select[1] == 1){
						
						UserPlayer p_two = new UserPlayer(true, 1, spy_one);
						
						players[1] = p_two;
						
					}else if(player_select[2] == 2){
						
						SimpleAI p_two  =new SimpleAI(true, 1, spy_one);
						
						players[1] = p_two;
						
					}
					
			}else{
				
				if(player_select[1] == 1){
					
					UserPlayer p_two = new UserPlayer(false, 1, -1);
					
					players[1] = p_two;
					
				}else if(player_select[2] == 2){
					
					SimpleAI p_two = new SimpleAI(false, 1, -1);
					
					players[1] = p_two;
					
				}
				
			}
			

			
			if (spy_one == 2){
				
				if(player_select[2] == 1){
					
					UserPlayer p_three = new UserPlayer(true, 2, spy_two);
					
					players[2] = p_three;
					
				}else if(player_select[3] == 2){
					
					SimpleAI p_three = new SimpleAI(true, 2, spy_two);
					
					players[2] = p_three;
					
				}
				
			}else if (spy_two == 2){
				
					if(player_select[2] == 1){
						
						UserPlayer p_three = new UserPlayer(true, 2, spy_one);
						
						players[2] = p_three;
						
					}else if(player_select[3] == 2){
						
						SimpleAI p_three = new SimpleAI(true, 2, spy_one);
						
						players[2] = p_three;
						
					}
					
			}else{
				
				if(player_select[2] == 1){
					
					UserPlayer p_three = new UserPlayer(false, 2, -1);
					
					players[2] = p_three;
					
				}else if(player_select[2] == 2){
					
					SimpleAI p_three = new SimpleAI(false, 2, -1);
					
					players[2] = p_three;
					
				}
				
			}
			

			
			if (spy_one == 3){
				
				if(player_select[3] == 1){
					
					UserPlayer p_four = new UserPlayer(true, 3, spy_two);
					
					players[3] = p_four;
					
				}else if(player_select[3] == 2){
					
					SimpleAI p_four = new SimpleAI(true, 3, spy_two);
					
					players[3] = p_four;
					
				}
				
			}else if (spy_two == 3){
				
					if(player_select[3] == 1){
						
						UserPlayer p_four = new UserPlayer(true, 3, spy_one);
						
						players[3] = p_four;
						
					}else if(player_select[3] == 2){
						
						SimpleAI p_four = new SimpleAI(true, 3, spy_one);
						
						players[3] = p_four;
						
					}
					
			}else{
				
				if(player_select[3] == 1){
					
					UserPlayer p_four = new UserPlayer(false, 3, -1);
					
					players[3] = p_four;
					
				}else if(player_select[4] == 2){
					
					SimpleAI p_four = new SimpleAI(false, 3, -1);
					
					players[3] = p_four;
					
				}
				
			}
			

			
			if (spy_one == 4){
				
				if(player_select[4] == 1){
					
					UserPlayer p_five = new UserPlayer(true, 4, spy_two);
					
					players[4] = p_five;
					
				}else if(player_select[4] == 2){
					
					SimpleAI p_five = new SimpleAI(true, 4, spy_two);
					
					players[4] = p_five;
					
				}
				
			}else if (spy_two == 4){
				
					if(player_select[4] == 1){
						
						UserPlayer p_five = new UserPlayer(true, 4, spy_one);
						
						players[4] = p_five;
						
					}else if(player_select[4] == 2){
						
						SimpleAI p_five=new SimpleAI(true, 4, spy_one);
						
						players[4] = p_five;
						
					}
					
			}else{
				
				if(player_select[4] == 1){
					
					UserPlayer p_five = new UserPlayer(false, 4, -1);
					
					players[4] = p_five;
					
				}else if(player_select[4] == 2){
					
					SimpleAI p_five = new SimpleAI(false, 4, -1);
					
					players[4] = p_five;
					
				}
				
			}
			

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
			
			System.out.println("Please select player " + (playernumber+1) + " as one of the following:");
			System.out.println("Type 1 for human control.");
			System.out.println("Type 2 for the SimpleAI bot.");
			
			boolean selection_made = false;
			
			do {
				
	            try {

	                int user_imput = scan.nextInt();
	                
	                if(user_imput == 1){
	                	
	                    System.out.println("Player " + (playernumber+1) + " is human.");
	                    System.out.println("");
	                    
	                    selection_made = true;
	                    
	                    return user_imput;
	                    
	                }else if(user_imput==2){
	                	
	                    System.out.println("Player " + (playernumber+1) + " is controlled by the SimpleAI bot.");
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



