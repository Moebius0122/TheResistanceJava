package rules;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPlayer extends Player {
	public UserPlayer(boolean isspy, int playerid, int otherspy) {
		super(isspy, playerid, otherspy);
		if(is_spy){
			System.out.println("Player "+ (player_id+1) + ", you are a spy inside the resistance.");
			System.out.println("You and "+ (other_spy+1) + " must cause 3 missions to fail, or delay the loyalist in their decision progress 5 times.");
			System.out.println("Good luck!");
		}else{
			System.out.println("Player "+ (player_id+1) + ", you are a loyal member of the resistance.");
			System.out.println("We know that two spies have managed to infiltrate our cell and are looking to sabotage our missions.");
			System.out.println("Make sure you succeed in at least 3 missions!");
			System.out.println("Also, if you take more than 5 attempts to form a team for a missions, our cover will be blown and we will loose the fight!");
			System.out.println("Good luck!");
		}
	}


	public boolean voteFailure(Scanner scan) {
		if(is_spy){
			boolean selection_made = false;
			do {
	            try {
	            	System.out.println("You fooled the loyalists and are on the mission. Do you feel it prudent to sabotage it? Enter 1 for sabotage, 0 for success.");
	                int player_decision = scan.nextInt();
	                if (player_decision==1) {
	                    System.out.println("You decided to sabotage the mission.");
	                    selection_made=true;
	                    return true;
	                } else if (player_decision==0) {
	                	System.out.println("You decided not to sabotage the mission.");
	                	selection_made=true;
	                	return false;
	                }
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
                else System.out.println("Invalid input! Enter 1 for yes, 0 for no.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter 1 for yes, 0 for no.");
            }
        }
		return false;
	}

}
