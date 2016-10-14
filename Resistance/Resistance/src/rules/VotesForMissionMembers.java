package rules;

public class VotesForMissionMembers {

	private int mission_mumber = -1;
	
	private int leader = -1;
	
	private int vote_round = -1;
	
	private boolean[] player_votes = {false,false,false,false,false};

	
	public VotesForMissionMembers() {
		
	}
	
	
	public void UpdateVotes(int missionnumber, int currentleader, int currentvoteround, boolean[] playervotes){
		
		mission_mumber = missionnumber;
		
		leader = currentleader;
		
		vote_round = currentvoteround;
		
		player_votes = playervotes;
		
	}
	
	
	public int getMission_mumber() {
		
		return mission_mumber;
		
	}

	
	public int getLeader() {
		
		return leader;
		
	}

	
	public int getVote_round() {
		
		return vote_round;
		
	}

	
	public boolean[] getPlayer_votes() {
		
		return player_votes;
		
	}
	
}
