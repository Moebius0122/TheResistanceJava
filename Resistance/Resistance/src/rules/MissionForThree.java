package rules;

public class MissionForThree extends Mission {
	
	private Player[] PlayersOnMission=new Player[3];
	
	
	public MissionForThree(int missionNumber) {
		
		super(missionNumber);
		
	}

	
	@Override
	public Player[] getPlayersOnMission() {
		
		return PlayersOnMission;
		
	}

}

