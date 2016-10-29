package rules;

import java.util.InputMismatchException;

public class PlayerFactory {

	public PlayerFactory() {
		// TODO Auto-generated constructor stub
	}

	public Player getPlayer(int spy, int selection, int player_id, int other_spy){

		boolean spy_boolean = false;
		
		if(spy == 1){
			
			spy_boolean = true;
			
		}
		
		if(selection == 1){
				
			return new UserPlayer(spy_boolean, player_id, other_spy);
				
		}else if(selection == 2){
				
			return new SimpleAI(spy_boolean, player_id, other_spy);
				
		}
		
		return null;
		
	}
	
}
