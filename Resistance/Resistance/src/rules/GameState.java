package rules;

import java.util.Random;

public class GameState {
	private Player[] players= new Player[5];
	private Mission[] missions= new Mission[5];
	private VotesForMissionMembers[] all_votes=new VotesForMissionMembers[5];
	private int current_round=0;
	private int current_vote_number=0;
	private int wins_for_spies=0;
	private boolean spy_win=false;
	
	Random rand= new Random();
	private int current_leader=rand.nextInt(5);
	
	private void UpdatePlayers(){
		for (int i=0;i<5;i++){
			players[i].updateGameState(missions,current_round,current_vote_number,wins_for_spies,all_votes);
		}
	}
	
	public GameState(Player[] PlayersFromInit, Mission[] MissionsFromInit) {
		players= PlayersFromInit;
		missions= MissionsFromInit;
	}

	
	public boolean PlayAGame(){
		System.out.println("Player "+ (current_leader+1) +" begins as the leader.");
		//Go through missions till the spies win or they run out of time.
		while(!spy_win && current_round<5){
			//Ruleset for missions with 2 players
			UpdatePlayers();
			Player[] current_vote;
			if (current_round==0 || current_round==2){
				current_vote=players[current_leader].selectForTwo(players);
				System.out.println("Player " +(current_leader+1) + " selected players " + (current_vote[0].getPlayer_id()+1) 
									+ " and " + (current_vote[1].getPlayer_id()+1) + " for mission " + (current_round+1)+".");
			} 
			//Ruleset for missions with 3 players
			else {
				current_vote=players[current_leader].selectForThree(players);
				System.out.println("Player " +(current_leader+1) + " selected players " + (current_vote[0].getPlayer_id()+1) 
									+ ", " + (current_vote[1].getPlayer_id()+1) + " and " + (current_vote[2].getPlayer_id()+1) + " for mission " 
									+ (current_round+1)+".");
			}
			//boolean[] VoteResults = new boolean[5];
			int vote_majority=0;
			boolean[] player_votes= new boolean[5];
			for (int i=0; i<5;i++){
				//Store the player votes for updating the players and count players in favor.
				player_votes[i]=players[i].voteForSelection(current_vote);
				if(players[i].voteForSelection(current_vote)){
					System.out.println("Player " +(i+1) + " voted in favor of this selection.");
					vote_majority=vote_majority+1;
				}
				else {
					System.out.println("Player " +(i+1) + " voted against this selection.");
				}
			}
			all_votes[current_round].UpdateVotes(current_round, current_leader, current_vote_number, player_votes);
			UpdatePlayers();
			if (vote_majority>=3){
				//If the vote succeeds, advance the leader, update the missions with the voted players and set the players on mission.
				System.out.println("The vote succeeded. The selected players will go on the mission.");
				current_leader=(current_leader+1)%5;
				UpdatePlayers();
				missions[current_round].setPlayersOnMission(current_vote);
				Player[] players_on_mission =missions[current_round].getPlayersOnMission();
				int votes_for_failure=0;
				for (int j=0; j<players_on_mission.length;j++){
					players_on_mission[j].setOn_mission(true, current_round);
					if (players_on_mission[j].voteFailure()){
						votes_for_failure=votes_for_failure+1;
					}
				}
				if (votes_for_failure==0){
					System.out.println("Mission "+ (current_round+1) +" was a full success!");
				}
				else{
					missions[current_round].setSpyWin(true);
					wins_for_spies=wins_for_spies+1;
					System.out.println("Mission "+ (current_round+1) +" failed! " + votes_for_failure + " player(s) on mission sabotaged it!");
					UpdatePlayers();
				}
				votes_for_failure=0; //Reset VoteFail for next Mission
				if (wins_for_spies==3){
					spy_win=true;
					System.out.println("The spies have won the game by failing the majority of the missions!");
					return true;
				}
			}
			else {
				//If the vote fails, the leader advances. The spies win if the vote fails 5 times.
				current_leader=(current_leader+1)%5;
				current_vote_number=current_vote_number+1;
				UpdatePlayers();
				if(current_vote_number==5){ spy_win=true;
				System.out.println("The spies have won the game due to the indecisiveness of the loyalists.");
				return true;
				}
			}
			current_round=current_round+1;
			UpdatePlayers();
			System.out.println();
		}
		return false;
	}
	

	
}
