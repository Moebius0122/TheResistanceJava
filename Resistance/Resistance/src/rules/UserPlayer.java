package rules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPlayer implements Player {

	// DON'T CHANGE THE IMPLEMENTATION OF THE CORE FEATURES
			//Own variables
	private boolean spy=false;
	private int other_spy=-1;
	private boolean[] on_mission={false,false,false,false,false};
	private int player_id;
	
	//State of the Game
	private Mission[] current_missions= new Mission[5];
	private int current_round=0;
	private int current_vote_number=0;
	private int wins_for_spies=0;
	
	/*A quasi 3D-Array. Contains entries in the form mission number (int), Leader (int, based on player_id, NOT the vote round number), Vote Round (int)
	  and player votes (array of booleans, sorted by player_id). Access the values by the methods
	  VotesForMissionMembers[roundnumber].getMission_mumber()
	  VotesForMissionMembers[roundnumber].getLeader()
	  VotesForMissionMembers[roundnumber].getVote_round()
	  VotesForMissionMembers[roundnumber].getPlayer_votes()
	*/
	private VotesForMissionMembers[] all_votes=new VotesForMissionMembers[5];
	
	public void updateGameState(Mission[] missions,int currentround,int currentvotenumber,int winsforspies,VotesForMissionMembers[] allvotes){
		current_missions= missions;
		current_round=currentround;
		current_vote_number=currentvotenumber;
		wins_for_spies=winsforspies;
		all_votes=allvotes;
	}

	public UserPlayer(int position) {
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

	@Override
	public boolean voteFailure(Scanner scan) {
		if(spy){
			boolean selection_made = false;
			do {
	            try {
	            	System.out.println("You fooled the loyalists and are on the mission. Do you feel it prudent to sabotage it? Enter 1 for sabotage, 0 for success.");
	                Scanner n = new Scanner(System.in);
	                int bn = n.nextInt();
	                if (bn==1) {
	                    System.out.println("You decided to sabotage the mission.");
	                    selection_made=true;
	                    //n.close();
	                    return true;
	                } else if (bn==0) {
	                	System.out.println("You decided not to sabotage the mission.");
	                	selection_made=true;
	                	//n.close();
	                	return false;
	                }
	                //n.close();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input! Enter 1 for sabotage, 0 for success.");
	            }
	        } while (!selection_made);
		}
		else {
			System.out.println("Since you are loyal to the cause, you did your best for the mission to succeed.");
			return false; //Loyalists may not sabotage a mission.
		}
		return false;
	}
	
	private int selectScanner(Player[] all_players, Scanner scan){
		boolean selection_made = false;
		do {
            try {
                int user_imput = scan.nextInt();
                if(user_imput>=1 && user_imput<=5){
                    System.out.println("You decided to nomitate player " + user_imput + " for the mission.");
                    selection_made = true;
                    return user_imput;
                }
                else System.out.println("Invalid input! Select player 1-5 by entering a number from 1 to 5.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Select player 1-5 by entering a number from 1 to 5.");
            }
        } while (!selection_made);
		return -1;
	}

	@Override
	public Player[] selectForTwo(Player[] all_players, Scanner scan) {
		System.out.println("You are the current leader and must nominate 2 members of the resistance. Who is your first nominee? Select player 1-5 by entering a number from 1 to 5.");
		Player[] selection_for_mission= new Player[2];
		selection_for_mission[0]= all_players[selectScanner(all_players, scan)];
		System.out.println("Who is your second nominee? Select player 1-5 by entering a number from 1 to 5.");
		selection_for_mission[1]= all_players[selectScanner(all_players, scan)];
		return selection_for_mission;
	}

	@Override
	public Player[] selectForThree(Player[] all_players, Scanner scan) {
		System.out.println("You are the current leader and must nominate 2 members of the resistance. Who is your first nominee? Select player 1-5 by entering a number from 1 to 5.");
		Player[] selection_for_mission= new Player[3];
		selection_for_mission[0]= all_players[selectScanner(all_players, scan)];
		System.out.println("Who is your second nominee? Select player 1-5 by entering a number from 1 to 5.");
		selection_for_mission[1]= all_players[selectScanner(all_players, scan)];
		System.out.println("Who is your third nominee? Select player 1-5 by entering a number from 1 to 5.");
		selection_for_mission[2]= all_players[selectScanner(all_players, scan)];
		return selection_for_mission;
	}

	@Override
	public boolean voteForSelection(Player[] for_vote, Scanner scan) {
		boolean selection_made = false;
		while (!selection_made) {
            try {
            	System.out.println("Do you approve the leaders selection for the next mission? Enter 1 for yes, 0 for no.");
                int user_input = scan.nextInt();
                if (user_input==1) {
                    System.out.println("You decided to approve the leaders selection.");
                    selection_made=true;
                    return true;
                } else if (user_input==0) {
                	System.out.println("You decided not to approve the leaders selection.");
                	selection_made=true;
                	return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter 1 for yes, 0 for no.");
            }
        }
		return false;
	}

}
