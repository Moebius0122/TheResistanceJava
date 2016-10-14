package rules;

import java.util.ArrayList;
import java.util.Scanner;

public class Mission {
	
	private final int mission_number;
	private boolean spy_win = false;
	private ArrayList<Player> players_on_mission = new ArrayList<Player>();
	

	
	public Mission(int missionnumber) {
		
		mission_number = missionnumber;
		
	}
	

	
	public int getMission_Number() {
		
		return mission_number;
		
	}
	
	public boolean isSpyWin() {
		
		return spy_win;
		
	}
	
	public ArrayList<Player> getPlayersOnMission() {
		
		return players_on_mission;
		
	}
	

	
	public boolean runMission(ArrayList<Player> on_mission, Scanner scan){
		
		players_on_mission = on_mission;
		
		int votes_for_failure = 0;
		
		for (int j = 0; j < players_on_mission.size(); j++){
			
			if (players_on_mission.get(j).voteFailure(scan)){
				
				votes_for_failure = votes_for_failure + 1;
				
			}
			
		}
		
		if (votes_for_failure == 0){
			
			System.out.println("Mission " + (mission_number) + " was a full success!");
            System.out.println("");
            
			return false;
			
		}
		
		else{
			
			spy_win=true;
			
			System.out.println("Mission " + (mission_number) + " failed! " + votes_for_failure + " player(s) on mission sabotaged it!");
            System.out.println("");
            
			return true;
			
		}
		
	}
	

	
}
