package rules;

public class MissionForThree extends Mission {
	private Player[] PlayersOnMission=new Player[3];
	
	public MissionForThree(int missionNumber) {
		super(missionNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Player[] getPlayersOnMission() {
		return PlayersOnMission;
	}

	public void setPlayersOnMission(Player[] playersOnMission) {
		PlayersOnMission = playersOnMission;
	}

}

