package rules;

import java.util.Scanner;

public class YourAI implements Player {
	
 	// DON'T CHANGE THE IMPLEMENTATION OF THE CORE FEATURES
	//Own variables
	private boolean spy=false;
	private int other_spy=-1;
	private boolean[] on_mission={false,false,false,false,false};
	private int player_id;
	
	//State of the Game
	private Mission[] current_missions= new Mission[5];
	private int current_round=0;
	private int current_vote_number=0;
	private int wins_for_spies=0;
	
	/*A quasi 3D-Array. Contains entries in the form mission number (int), Leader (int, based on player_id, NOT the vote round number), Vote Round (int)
	  and player votes (array of booleans, sorted by player_id). Access the values by the methods
	  VotesForMissionMembers[roundnumber].getMission_mumber()
	  VotesForMissionMembers[roundnumber].getLeader()
	  VotesForMissionMembers[roundnumber].getVote_round()
	  VotesForMissionMembers[roundnumber].getPlayer_votes()
	*/
	private VotesForMissionMembers[] all_votes=new VotesForMissionMembers[5];

	public void updateGameState(Mission[] missions,int currentround,int currentvotenumber,int winsforspies,VotesForMissionMembers[] allvotes){
		current_missions= missions;
		current_round=currentround;
		current_vote_number=currentvotenumber;
		wins_for_spies=winsforspies;
		all_votes=allvotes;
	}

	public YourAI(int position) {
		player_id = position;
	}
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setSpy(boolean spy_init, int otherspy_init) {
		spy = spy_init;
		other_spy=otherspy_init;
	}

	public void setOn_mission(boolean onmission, int roundnumber) {
		on_mission[roundnumber] = onmission;
	}

	
	
	//Here you need to specify the rules for your AI. The current game state is constantly updated into the variables above.
	
	
	//This method determines the vote should the AI be on a mission.
	public boolean voteFailure(Scanner scan){
		return true;
	}
	
	//This method selects 2 Players if the AI is the Leader for Mission 1 or 3. Make sure you are not selecting the same player twice. 
	//The Array AllPlayers goes from 0 to 4.
	public Player[] selectForTwo(Player[] AllPlayers, Scanner scan) {
		Player[] selection_for_mission=new Player[2];
		selection_for_mission[0]=this;
		selection_for_mission[1]=AllPlayers[-1];
		return selection_for_mission;
	}
	
	//This method selects 3 Players if the AI is the Leader for Mission 2, 4 or 5.
	public Player[] selectForThree(Player[] AllPlayers, Scanner scan) {
		Player[] selection_for_mission=new Player[3];
		selection_for_mission[0]=this;
		selection_for_mission[1]=AllPlayers[-1];
		selection_for_mission[2]=AllPlayers[-1];
		return selection_for_mission;
	}
	
	
	//This method determines whether or not the AI agrees with the selected players for the current mission.
	public boolean voteForSelection(Player[] ForVote, Scanner scan) {
		return true;
	}


}
