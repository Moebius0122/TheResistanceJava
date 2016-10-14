package rules;

public class MissionForTwo extends Mission {
	
	private Player[] PlayersOnMission=new Player[2];
	
	
	public MissionForTwo(int missionNumber) {
		
		super(missionNumber);

	}

	
	@Override
	public Player[] getPlayersOnMission() {
		
		return PlayersOnMission;
		
	}

}
