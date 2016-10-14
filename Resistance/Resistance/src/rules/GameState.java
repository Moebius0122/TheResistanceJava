package rules;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameState {
	private Player[] players = new Player[5];
	private Mission[] missions = new Mission[5];
	private VotesForMissionMembers[] all_votes = new VotesForMissionMembers[5];
	private int current_round = 0;
	private int current_vote_number = 0;
	private int wins_for_spies = 0;
	private boolean spy_win = false;
	
	Random rand= new Random();
	
	private int current_leader = rand.nextInt(5);
	
	
	private void UpdatePlayers(){
		
		for (int i=0;i<5;i++){
			
			players[i].updateGameState(missions,current_round,current_vote_number,wins_for_spies,all_votes);
			
		}
		
	}
	
	
	public GameState(Player[] PlayersFromInit, Mission[] MissionsFromInit) {
		
		players = PlayersFromInit;
		missions = MissionsFromInit;
		
	}

	
	public boolean PlayAGame(Scanner scan){
		System.out.println("Player "+ (current_leader+1) +" begins as the leader.");
		
		//Go through missions till the spies win or they run out of time.
		while(!spy_win && current_round < 5){
			
			
			UpdatePlayers();
			
			ArrayList<Player> current_vote = new ArrayList<Player>();;
			
			//Ruleset for missions with 2 players
			if (current_round == 0 || current_round == 2){
				
				current_vote=players[current_leader].selectForTwo(players, scan);
				
				System.out.println("Player " + (current_leader + 1) + " selected players " + (current_vote.get(0).getPlayer_id() + 1)
									+ " and " + (current_vote.get(1).getPlayer_id() + 1) + " for mission " + (current_round + 1)+".");
			} 
			
			//Ruleset for missions with 3 players
			else {
				current_vote=players[current_leader].selectForThree(players, scan);
				
				System.out.println("Player " + (current_leader + 1) + " selected players " + (current_vote.get(0).getPlayer_id() + 1) 
									+ ", " + (current_vote.get(1).getPlayer_id() + 1) + " and " + (current_vote.get(2).getPlayer_id() + 1) + " for mission " 
									+ (current_round + 1)+".");
			}
			
			int votes_in_favor = 0;
			
			boolean[] player_votes = new boolean[5];
			
			for (int i=0; i<5; i++){
				
				//Count players sabotaging and store the count.
				
				player_votes[i] = players[i].voteForSelection(current_vote, scan);
				
				if(player_votes[i]){
					
					System.out.println("Player " + (i + 1) + " voted in favor of this selection.");
					
					votes_in_favor = votes_in_favor+1;
				}
				
				else {
					
					System.out.println("Player " + (i + 1) + " voted against this selection.");
					
				}
				
			}
			
			//all_votes[current_round].UpdateVotes(current_round, current_leader, current_vote_number, player_votes);
			
			UpdatePlayers();
			
			if (votes_in_favor >= 3){
				
				//If the vote succeeds, advance the leader, update the missions with the voted players and set the players on mission.
				System.out.println("The vote succeeded. The selected players will go on the mission.");
				System.out.println("");
                
				current_leader = (current_leader + 1) % 5;
				
				UpdatePlayers();
				
				if(missions[current_round].runMission(current_vote, scan)){
					
					wins_for_spies = wins_for_spies + 1;
					
				}
				
				UpdatePlayers();
				
				if (wins_for_spies == 3){
					
					spy_win = true;
					
					System.out.println("The spies have won the game by failing the majority of the missions!");
					
					return true;
					
				}
				
			}
			
			else {
				
				//If the vote fails, the leader advances. The spies win if the vote fails 5 times.
				current_leader = (current_leader + 1) % 5;
				
				current_vote_number = current_vote_number + 1;
				
				UpdatePlayers();
				
				if(current_vote_number == 5){ 
					
					spy_win = true;
				
					System.out.println("The spies have won the game due to the indecisiveness of the loyalists.");
					
					scan.close();
					
				return true;
				
				}
				
			}
			
			if (current_round-wins_for_spies ==3 ){
				
				return false;
				
			}
			
			current_round = current_round + 1;
			
			UpdatePlayers();
			
			System.out.println();
			
		}
		
		return false;
		
	}
		
}
