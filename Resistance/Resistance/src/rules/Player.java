package rules;

import java.util.ArrayList;
import java.util.Scanner;


//Abstract superclass that handles everything but the actual decision making.
abstract public class Player implements PlayerInterface {
	
	//Own variables
	protected final boolean is_spy;
	protected final int other_spy;
	protected final int player_id;
	
	
	//State of the Game
	protected Mission[] current_missions= new Mission[5];
	protected int current_round = 0;
	protected int current_vote_number = 0;
	protected int wins_for_spies = 0;
	
	
	/*A quasi 3D-Array. Contains entries in the form mission number (int), Leader (int, based on player_id, NOT the vote round number), Vote Round (int)
	  and player votes (array of booleans, sorted by player_id). Access the values by the methods
	  VotesForMissionMembers[roundnumber].getMission_mumber()
	  VotesForMissionMembers[roundnumber].getLeader()
	  VotesForMissionMembers[roundnumber].getVote_round()
	  VotesForMissionMembers[roundnumber].getPlayer_votes()
	*/
	protected VotesForMissionMembers[] all_votes = new VotesForMissionMembers[5];


	public Player(boolean isspy, int playerid, int otherspy) {
		
		is_spy = isspy;
		player_id = playerid;
		other_spy = otherspy;
		
	}

	@Override
	public void updateGameState(Mission[] missions, int currentround, int currentvotenumber, int winsforspies,
			VotesForMissionMembers[] allvotes) {
		
		current_missions = missions;
		current_round = currentround;
		current_vote_number = currentvotenumber;
		wins_for_spies = winsforspies;
		all_votes = allvotes;
		
	}

	//Every method down below needs to be implemented by the subclasses.
	
	
	@Override
	public int getPlayer_id() {
		
		return player_id;
		
	}

	
	@Override
	public boolean voteFailure(Scanner scan) {
		
		return false;
		
	}


	@Override
	public ArrayList<Player> selectForTwo(Player[] all_players, Scanner scan) {
		
		return null;
		
	}

	@Override
	public ArrayList<Player> selectForThree(Player[] all_players, Scanner scan) {
		
		return null;
		
	}

	@Override
	public boolean voteForSelection(ArrayList<Player> for_vote, Scanner scan) {
		
		return false;
		
	}

}
