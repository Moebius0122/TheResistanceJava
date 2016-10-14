package rules;

import java.util.ArrayList;
import java.util.Scanner;

public interface PlayerInterface {
	
	
	void updateGameState(Mission[] missions,int current_round,int current_vote_number,int wins_for_spies,VotesForMissionMembers[] all_votes);
	
	
	int getPlayer_id();
	
	
	boolean voteFailure(Scanner scan);
	
	
	ArrayList<Player> selectForTwo(Player[] all_players, Scanner scan);
	
	
	ArrayList<Player> selectForThree(Player[] all_players, Scanner scan);
	
	
	boolean voteForSelection(ArrayList<Player> for_vote, Scanner scan);
	
}
