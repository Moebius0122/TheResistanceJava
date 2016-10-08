package rules;

import java.util.Random;

public class SimpleAI implements Player {
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

	public void updateGameState(Mission[] missions,int currentround,int currentvotenumber,int winsforspies){
		current_missions= missions;
		current_round=currentround;
		current_vote_number=currentvotenumber;
		wins_for_spies=winsforspies;
	}
	
	public SimpleAI(int position) {
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

	public boolean voteFailure(){
		//if(spy) return true;
		return false;
	}

	public Player[] selectForTwo(Player[] AllPlayers) {
		Player[] ForMission=new Player[2];
		ForMission[0]=this;
		int SecondPlayer = 0;
		Random rand= new Random();
		if (spy){
			while(other_spy==SecondPlayer||SecondPlayer==0|| SecondPlayer==player_id){//Nominate a random non-spy.
				SecondPlayer = rand.nextInt(5);
			}
		}
			else{ //Change to logic for determining spies eventually.
			while(SecondPlayer==0 && SecondPlayer==player_id){
				SecondPlayer = rand.nextInt(5);
				}
		}
		ForMission[1]=AllPlayers[SecondPlayer];
		return ForMission;
	}

	public Player[] selectForThree(Player[] AllPlayers) {
		Player[] ForMission=new Player[3];
		ForMission[0]=this;
		int SecondPlayer = 0;
		int ThirdPlayer = 0;
		Random rand= new Random();
		if (spy){
			while(other_spy==SecondPlayer||SecondPlayer==0|| SecondPlayer==player_id){//Nominate a random non-spy.
				SecondPlayer = rand.nextInt(5);
			}//Nominate a different random non-spy.
			while(other_spy==SecondPlayer||SecondPlayer==0|| SecondPlayer==player_id || ThirdPlayer==player_id || SecondPlayer==ThirdPlayer){
				ThirdPlayer = rand.nextInt(5);
			}
		}
		else{ //Change to logic for determining spies eventually.
			while(SecondPlayer==0 || SecondPlayer==player_id){
			SecondPlayer = rand.nextInt(5);
			}
		
			while(SecondPlayer==0 || SecondPlayer==player_id || ThirdPlayer==player_id || SecondPlayer==ThirdPlayer){
				ThirdPlayer = rand.nextInt(5);
			}
		
		}
		ForMission[1]=AllPlayers[SecondPlayer];
		ForMission[2]=AllPlayers[ThirdPlayer];
		return ForMission;
	}

	public boolean voteForSelection(Player[] ForVote) {
		return true;
	}

}
