package rules;

import java.util.Random;

public class Entry {
	public static void main(String[] args) {
	
		//System.out.println(State.isSpyWin());
		//PlayAIGame(InitGame());
		//GameState the_state=initAIGame();
		GameState the_state=initOnePlayerGame();
		boolean spy_win=the_state.PlayAGame();
		if(!spy_win){
			System.out.println("The resistance succeeded! The filthy spies couldn't sabotage enough missions.");
		}
	}
	
		public static GameState initAIGame(){
			//Initialize all needed data structures
			SimpleAI p_one=new SimpleAI(0);
			SimpleAI p_two=new SimpleAI(1);
			SimpleAI p_three=new SimpleAI(2);
			SimpleAI p_four=new SimpleAI(3);
			SimpleAI p_five=new SimpleAI(4);
			Player[] players= {p_one,p_two,p_three,p_four,p_five};			
			MissionForTwo m_one=new MissionForTwo(1);
			MissionForThree m_two=new MissionForThree(2);
			MissionForTwo m_three=new MissionForTwo(3);
			MissionForThree m_four=new MissionForThree(4);
			MissionForThree m_five=new MissionForThree(5);
			Mission[] missions={m_one,m_two,m_three,m_four,m_five};
			GameState g_state=new GameState(players,missions);

			int spy_one, spy_two=0;
		
			//Set the spies and let them know of each other
			Random rand= new Random();
			spy_one = rand.nextInt(5);
			while(spy_two==spy_one||spy_two==0){
				spy_two = rand.nextInt(5);
			}
			System.out.println("Player "+ (spy_one+1) +" is a filthy spy!");
			System.out.println("Player "+ (spy_two+1) +" is a filthy spy!");
			players[spy_one].setSpy(true,spy_two);
			players[spy_two].setSpy(true,spy_one);
			
			return g_state;
		}

		public static GameState initOnePlayerGame(){
			//Initialize all needed data structures
			UserPlayer p_one=new UserPlayer(0);
			SimpleAI p_two=new SimpleAI(1);
			SimpleAI p_three=new SimpleAI(2);
			SimpleAI p_four=new SimpleAI(3);
			SimpleAI p_five=new SimpleAI(4);
			Player[] players= {p_one,p_two,p_three,p_four,p_five};			
			MissionForTwo m_one=new MissionForTwo(1);
			MissionForThree m_two=new MissionForThree(2);
			MissionForTwo m_three=new MissionForTwo(3);
			MissionForThree m_four=new MissionForThree(4);
			MissionForThree m_five=new MissionForThree(5);
			Mission[] missions={m_one,m_two,m_three,m_four,m_five};
			GameState g_state=new GameState(players,missions);

			int spy_one, spy_two=0;
		
			//Set the spies and let them know of each other
			Random rand= new Random();
			spy_one = rand.nextInt(5);
			while(spy_two==spy_one||spy_two==0){
				spy_two = rand.nextInt(5);
			}
			//System.out.println("Player "+ (spy_one+1) +" is a filthy spy!");
			//System.out.println("Player "+ (spy_two+1) +" is a filthy spy!");
			players[spy_one].setSpy(true,spy_two);
			players[spy_two].setSpy(true,spy_one);
			
			return g_state;
		}

		
		//Deprecated, use playAGame in the GameState class instead
		
/*		public static void PlayAIGame(GameState TheState){
			//Go through missions till the spies win or they run out of time.
			while(!TheState.isSpyWin() && TheState.getRoundNumber()<5){
				//Ruleset for missions with 2 players
				Player[] CurrentVote;
				if (TheState.getRoundNumber()==0 || TheState.getRoundNumber()==2){
					CurrentVote=TheState.getPlayers()[TheState.getCurrentLeader()].SelectForTwo(TheState.getPlayers());
					System.out.println("Player " +(TheState.getCurrentLeader()+1) + " selected players " + (CurrentVote[0].getPosition()+1) 
										+ " and " + (CurrentVote[1].getPosition()+1) + " for mission " + (TheState.getRoundNumber()+1)+".");
				} 
				//Ruleset for missions with 3 players
				else {
					CurrentVote=TheState.getPlayers()[TheState.getCurrentLeader()].SelectForThree(TheState.getPlayers());
					System.out.println("Player " +(TheState.getCurrentLeader()+1) + " selected players " + (CurrentVote[0].getPosition()+1) 
										+ ", " + (CurrentVote[1].getPosition()+1) + " and " + (CurrentVote[2].getPosition()+1) + " for mission " 
										+ (TheState.getRoundNumber()+1)+".");
				}
				//boolean[] VoteResults = new boolean[5];
				int VoteMajority=0;
				for (int i=0; i<5;i++){
					if(TheState.getPlayers()[i].VoteForSelection(CurrentVote)==true){
						System.out.println("Player " +(i+1) + " voted in favor of this selection.");
						VoteMajority=VoteMajority+1;
					}
					else {
						System.out.println("Player " +(i+1) + " voted against this selection.");
					}
				}
				if (VoteMajority>=3){
					//If the vote succeeds, advance the leader, update the missions with the voted players and set the players on mission.
					System.out.println("The vote succeeded. The selected players will go on the mission.");
					TheState.setCurrentLeader((TheState.getCurrentLeader()+1)%5);
					TheState.getMissions()[TheState.getRoundNumber()].setPlayersOnMission(CurrentVote);
					Player[] OnMission =TheState.getMissions()[TheState.getRoundNumber()].getPlayersOnMission();
					int VoteFail=0;
					for (int j=0; j<OnMission.length;j++){
						OnMission[j].setOnMission(true, TheState.getRoundNumber());
						if (OnMission[j].VoteFailure()){
							VoteFail=VoteFail+1;
						}
					}
					if (VoteFail==0){
						System.out.println("Mission "+ (TheState.getRoundNumber()+1) +" was a full success!");
					}
					else{
						TheState.getMissions()[TheState.getRoundNumber()].setSpyWin(true);
						TheState.setSpyWins(TheState.getSpyWins()+1);
						System.out.println("Mission "+ (TheState.getRoundNumber()+1) +" failed! " + VoteFail + " player(s) on mission sabotaged it!");
					}
					VoteFail=0; //Reset VoteFail for next Mission
					if (TheState.getSpyWins()==3){
						TheState.setSpyWin(true);
						System.out.println("The spies have won the game by failing the majority of the missions!");
						break;
					}
				}
				else {
					//If the vote fails, the leader advances. The spies win if the vote fails 5 Times.
					TheState.setCurrentLeader((TheState.getCurrentLeader()+1)%5);
					TheState.setVoteNumber(TheState.getVoteNumber()+1);
					if(TheState.getVoteNumber()==5){ TheState.setSpyWin(true);
					System.out.println("The spies have won the game due to the indecisiveness of the loyalists.");
					break;
					}
				}
				TheState.setRoundNumber(TheState.getRoundNumber()+1);	
			}
		}*/
		

}



