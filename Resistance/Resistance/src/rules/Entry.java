package rules;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Entry {
	public static void main(String[] args) {

		final Scanner scan = new Scanner(System.in);
		
		GameState the_state = initGame(scan);
		
		boolean spy_win = the_state.PlayAGame(scan);
		
		if(!spy_win){
			
			System.out.println("The resistance succeeded! The filthy spies couldn't sabotage enough missions.");
			
		}
		
		scan.close();
		
	}

	
		public static GameState initGame(Scanner scan){
			
			

			//Set the spies and let them know of each other
			
			int spy_one, spy_two=0;
			
			Random rand = new Random();
			
			spy_one = rand.nextInt(5);
			
			while(spy_two == spy_one||spy_two == 0){
				
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
			

			
			MissionForTwo m_one = new MissionForTwo(1);
			MissionForThree m_two = new MissionForThree(2);
			MissionForTwo m_three = new MissionForTwo(3);
			MissionForThree m_four = new MissionForThree(4);
			MissionForThree m_five = new MissionForThree(5);
			Mission[] missions = {m_one,m_two,m_three,m_four,m_five};
			GameState g_state = new GameState(players,missions);
			

			
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
		

		
		//Deprecated, use playAGame in the GameState class instead
		
		
/*		public static void PlayAIGame(GameState TheState){
			//Go through missions till the spies win or they run out of time.
			while(!TheState.isSpyWin() && TheState.getRoundNumber()<5){
				//Ruleset for missions with 2 players
				Player[] CurrentVote;
				if (TheState.getRoundNumber()==0 || TheState.getRoundNumber()==2){
					CurrentVote=TheState.getPlayers()[TheState.getCurrentLeader()].SelectForTwo(TheState.getPlayers());
					System.out.println("Player " +(TheState.getCurrentLeader()+1) + " selected players " + (CurrentVote[0].getPosition()+1) 
										+ " and " + (CurrentVote[1].getPosition()+1) + " for mission " + (TheState.getRoundNumber()+1)+".");
				} 
				//Ruleset for missions with 3 players
				else {
					CurrentVote=TheState.getPlayers()[TheState.getCurrentLeader()].SelectForThree(TheState.getPlayers());
					System.out.println("Player " +(TheState.getCurrentLeader()+1) + " selected players " + (CurrentVote[0].getPosition()+1) 
										+ ", " + (CurrentVote[1].getPosition()+1) + " and " + (CurrentVote[2].getPosition()+1) + " for mission " 
										+ (TheState.getRoundNumber()+1)+".");
				}
				//boolean[] VoteResults = new boolean[5];
				int VoteMajority=0;
				for (int i=0; i<5;i++){
					if(TheState.getPlayers()[i].VoteForSelection(CurrentVote)==true){
						System.out.println("Player " +(i+1) + " voted in favor of this selection.");
						VoteMajority=VoteMajority+1;
					}
					else {
						System.out.println("Player " +(i+1) + " voted against this selection.");
					}
				}
				if (VoteMajority>=3){
					//If the vote succeeds, advance the leader, update the missions with the voted players and set the players on mission.
					System.out.println("The vote succeeded. The selected players will go on the mission.");
					TheState.setCurrentLeader((TheState.getCurrentLeader()+1)%5);
					TheState.getMissions()[TheState.getRoundNumber()].setPlayersOnMission(CurrentVote);
					Player[] OnMission =TheState.getMissions()[TheState.getRoundNumber()].getPlayersOnMission();
					int VoteFail=0;
					for (int j=0; j<OnMission.length;j++){
						OnMission[j].setOnMission(true, TheState.getRoundNumber());
						if (OnMission[j].VoteFailure()){
							VoteFail=VoteFail+1;
						}
					}
					if (VoteFail==0){
						System.out.println("Mission "+ (TheState.getRoundNumber()+1) +" was a full success!");
					}
					else{
						TheState.getMissions()[TheState.getRoundNumber()].setSpyWin(true);
						TheState.setSpyWins(TheState.getSpyWins()+1);
						System.out.println("Mission "+ (TheState.getRoundNumber()+1) +" failed! " + VoteFail + " player(s) on mission sabotaged it!");
					}
					VoteFail=0; //Reset VoteFail for next Mission
					if (TheState.getSpyWins()==3){
						TheState.setSpyWin(true);
						System.out.println("The spies have won the game by failing the majority of the missions!");
						break;
					}
				}
				else {
					//If the vote fails, the leader advances. The spies win if the vote fails 5 Times.
					TheState.setCurrentLeader((TheState.getCurrentLeader()+1)%5);
					TheState.setVoteNumber(TheState.getVoteNumber()+1);
					if(TheState.getVoteNumber()==5){ TheState.setSpyWin(true);
					System.out.println("The spies have won the game due to the indecisiveness of the loyalists.");
					break;
					}
				}
				TheState.setRoundNumber(TheState.getRoundNumber()+1);	
			}
		}*/
		

}



