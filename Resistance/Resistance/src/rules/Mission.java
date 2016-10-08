package rules;

public class Mission {
	private int MissionNumber;
	private boolean SpyWin=false;
	private Player[] PlayersOnMission;
			
	public Mission(int missionNumber) {
		MissionNumber = missionNumber;
	}
	
	public int getMissionNumber() {
		return MissionNumber;
	}
	public void setMissionNumber(int missionNumber) {
		MissionNumber = missionNumber;
	}
	public boolean isSpyWin() {
		return SpyWin;
	}
	public void setSpyWin(boolean spyWin) {
		SpyWin = spyWin;
	}

	public Player[] getPlayersOnMission() {
		return PlayersOnMission;
	}

	public void setPlayersOnMission(Player[] playersOnMission) {
		PlayersOnMission = playersOnMission;
	}
}
