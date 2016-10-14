package rules;

import java.util.Random;
import java.util.Scanner;

public class SimpleAI extends Player {
	
	public SimpleAI(boolean isspy, int playerid, int otherspy) {
		
		super(isspy, playerid, otherspy);
		
	}
	
	
	@Override
	public boolean voteFailure(Scanner scan){
		
		if(is_spy) return true;
		
		return false;
		
	}

	
	@Override
	public Player[] selectForTwo(Player[] AllPlayers, Scanner scan) {
		
		Player[] ForMission = new Player[2];
		
		ForMission[0] = this;
		
		int SecondPlayer = -1;
		
		Random rand = new Random();
		
		if (is_spy){
			
			do{//Nominate a random non-spy.
				
				SecondPlayer = rand.nextInt(5);
				
			}while(other_spy == SecondPlayer || SecondPlayer == -1 || SecondPlayer == player_id);
			
		}
		
			else{ //Change to logic for determining spies eventually.
				
			do{
				
				SecondPlayer = rand.nextInt(5);
				
			}while(SecondPlayer == -1 || SecondPlayer == player_id);
			
		}
		
		ForMission[1] = AllPlayers[SecondPlayer];
		
		return ForMission;
		
	}

	
	@Override
	public Player[] selectForThree(Player[] AllPlayers, Scanner scan) {
		
		Player[] ForMission = new Player[3];
		
		ForMission[0] = this;
		
		int SecondPlayer = -1;
		
		int ThirdPlayer = -1;
		
		Random rand= new Random();
		
		if (is_spy){
			
			do{//Nominate a random non-spy.
				
				SecondPlayer = rand.nextInt(5);
				
			}while(other_spy == SecondPlayer||SecondPlayer==-1|| SecondPlayer==player_id);
				//Nominate a different random non-spy.
			do{
				
				ThirdPlayer = rand.nextInt(5);
				
			}while(other_spy == SecondPlayer || SecondPlayer ==-1 || SecondPlayer == player_id || ThirdPlayer == player_id || SecondPlayer == ThirdPlayer);
		}
		else{ //Change to logic for determining spies eventually.
			do{
				
			SecondPlayer = rand.nextInt(5);
			
			}while(SecondPlayer ==-1 || SecondPlayer == player_id);
		
			do{
				
				ThirdPlayer = rand.nextInt(5);
				
			}while(ThirdPlayer ==-1 || SecondPlayer == player_id || ThirdPlayer == player_id || SecondPlayer == ThirdPlayer);
		
		}
		
		ForMission[1] = AllPlayers[SecondPlayer];
		
		ForMission[2] = AllPlayers[ThirdPlayer];
		
		return ForMission;
		
	}

	
	@Override
	public boolean voteForSelection(Player[] ForVote, Scanner scan) {
		
		return true;
		
	}

}
