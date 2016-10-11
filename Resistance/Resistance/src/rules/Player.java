package rules;

import java.util.Scanner;


//Abstract superclass that handles everything but the actual decision making.
public class Player implements PlayerInterface {
	
	//Own variables
	private final boolean is_spy;
	private final int other_spy;
	private final int player_id;
	private boolean[] on_mission={false,false,false,false,false};
	
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


	public Player(boolean isspy, int playerid, int otherspy) {
		is_spy=isspy;
		player_id=playerid;
		other_spy=otherspy;
	}

	@Override
	public void updateGameState(Mission[] missions, int currentround, int currentvotenumber, int winsforspies,
			VotesForMissionMembers[] allvotes) {
		current_missions= missions;
		current_round=currentround;
		current_vote_number=currentvotenumber;
		wins_for_spies=winsforspies;
		all_votes=allvotes;
	}

	@Override
	public int getPlayer_id() {
		// TODO Auto-generated method stub
		return player_id;
	}

	public boolean voteFailure(Scanner scan) {
		// TODO Auto-generated method stub
		return false;
	}

	public PlayerInterface[] selectForTwo(PlayerInterface[] all_players, Scanner scan) {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerInterface[] selectForThree(PlayerInterface[] all_players, Scanner scan) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean voteForSelection(PlayerInterface[] for_vote, Scanner scan) {
		// TODO Auto-generated method stub
		return false;
	}

}
