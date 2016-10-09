package rules;

public class UserPlayer implements Player {

	// DON'T CHANGE THE IMPLEMENTATION OF THE CORE FEATURES
			//Own variables
	private boolean spy=false;
	private int other_spy=-1;
	private boolean[] on_mission={false,false,false,false,false};
	private int player_id;
	
	//State of the Game
	private Player[] players= new Player[5];
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

	public UserPlayer(int position) {
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

	@Override
	public boolean voteFailure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player[] selectForTwo(Player[] all_players) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player[] selectForThree(Player[] all_players) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean voteForSelection(Player[] for_vote) {
		// TODO Auto-generated method stub
		return false;
	}

}
