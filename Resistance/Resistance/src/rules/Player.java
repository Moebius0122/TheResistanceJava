package rules;

public interface Player {
	void updateGameState(Mission[] missions,int current_round,int current_vote_number,int wins_for_spies);
	int getPlayer_id();
	void setSpy(boolean spy_init, int otherspy_init);
	void setOn_mission(boolean on_mission, int round_number);
	boolean voteFailure();
	Player[] selectForTwo(Player[] all_players);
	Player[] selectForThree(Player[] all_players);
	boolean voteForSelection(Player[] for_vote);
}
