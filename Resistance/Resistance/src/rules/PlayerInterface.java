package rules;

import java.util.Scanner;

public interface Player {
	void updateGameState(Mission[] missions,int current_round,int current_vote_number,int wins_for_spies,VotesForMissionMembers[] all_votes);
	int getPlayer_id();
	void setSpy(boolean spy_init, int otherspy_init);
	void setOn_mission(boolean on_mission, int round_number);
	boolean voteFailure(Scanner scan);
	Player[] selectForTwo(Player[] all_players, Scanner scan);
	Player[] selectForThree(Player[] all_players, Scanner scan);
	boolean voteForSelection(Player[] for_vote, Scanner scan);
}
