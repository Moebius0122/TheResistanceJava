package rules;

import java.util.ArrayList;
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
	public ArrayList<Player> selectForTwo(Player[] AllPlayers, Scanner scan) {
		
		ArrayList<Player> ForMission = new ArrayList<Player>(2);
		
		ForMission.add(this);
		
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
		
		ForMission.add(AllPlayers[SecondPlayer]);
		
		return ForMission;
		
	}

	
	@Override
	public ArrayList<Player> selectForThree(Player[] AllPlayers, Scanner scan) {
		
		ArrayList<Player> ForMission = new ArrayList<Player>(3);
		
		ForMission.add(this);
		
		int SecondPlayer = -1;
		
		int ThirdPlayer = -1;
		
		Random rand= new Random();
		
		if (is_spy){
			
			do{//Nominate a random non-spy.
				
				SecondPlayer = rand.nextInt(5);
				
			}while(other_spy == SecondPlayer||SecondPlayer==-1|| SecondPlayer==player_id);
				
			do{//Nominate a different random non-spy.
				
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
		
		ForMission.add(AllPlayers[SecondPlayer]);
		
		ForMission.add(AllPlayers[ThirdPlayer]);
		
		return ForMission;
		
	}

	
	@Override
	public boolean voteForSelection(ArrayList<Player> ForVote, Scanner scan) {
		
		return true;
		
	}

}
