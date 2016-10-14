package rules;

import java.util.ArrayList;
import java.util.Scanner;

public class YourAI extends Player {

	
 	public YourAI(boolean isspy, int playerid, int otherspy) {
 		
		super(isspy, playerid, otherspy);
		
	}

	//Here you need to specify the rules for your AI. The current game state is constantly updated into the variables above.
	
	
	//This method determines the vote should the AI be on a mission.
	@Override
	public boolean voteFailure(Scanner scan){
		
		return true;
		
	}
	
	
	//This method selects 2 Players if the AI is the Leader for Mission 1 or 3. Make sure you are not selecting the same player twice. 
	//The Array AllPlayers goes from 0 to 4.
	@Override
	public ArrayList<Player> selectForTwo(Player[] AllPlayers, Scanner scan) {
		
		ArrayList<Player> selection_for_mission = new ArrayList<Player>(2);
		
		selection_for_mission.add(this);
		
		selection_for_mission.add(AllPlayers[-1]);
		
		return selection_for_mission;
		
	}
	
	
	//This method selects 3 Players if the AI is the Leader for Mission 2, 4 or 5.
	@Override
	public ArrayList<Player> selectForThree(Player[] AllPlayers, Scanner scan) {
		
		ArrayList<Player> selection_for_mission = new ArrayList<Player>(3);
		
		selection_for_mission.add(this);
		
		selection_for_mission.add(AllPlayers[-1]);
		
		selection_for_mission.add(AllPlayers[-1]);
		
		return selection_for_mission;
		
	}
	
	
	//This method determines whether or not the AI agrees with the selected players for the current mission.
	@Override
	public boolean voteForSelection(ArrayList<Player> ForVote, Scanner scan) {
		
		return true;
		
	}


}
