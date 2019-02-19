import java.util.Scanner;

/**
 * Created by blake on 10/03/2017.
 */
public class Player {

    private String PlayerName = null;
    private int PlayerLevel = 1;
    private int PlayerXp = 0;
    private int PlayerDamage = 2;
    private int PlayerArmor = 2;
    private int PlayerGold = 10;
    private int KillCount = 0;
    private int PlayerLocation = 1;
    private int PlayerMaxHealth = 100;
    private int PlayerCurrentHealth = PlayerMaxHealth;
    private int PlayerScore = 0;

	public Player()
    {

    }
	public void PlayerCreate()
    {
		System.out.println("~Welcome Adventurer to IronWatch~");
		System.out.println("To begin please enter your name:");
		System.out.print(">");
		Scanner scan = new Scanner(System.in);
		this.PlayerName = scan.next();
    }

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public int getPlayerLevel() {
		return PlayerLevel;
	}

	public void setPlayerLevel(int playerLevel) {
		PlayerLevel = playerLevel;
	}

	public int getPlayerXp() {
		return PlayerXp;
	}

	public void setPlayerXp(int playerXp) {
		PlayerXp = playerXp;
	}

	public int getPlayerDamage() {
		return PlayerDamage;
	}

	public void setPlayerDamage(int playerDamage) {
		PlayerDamage = playerDamage;
	}

	public int getPlayerArmor() {
		return PlayerArmor;
	}

	public void setPlayerArmor(int playerArmor) {
		PlayerArmor = playerArmor;
	}

	public int getPlayerGold() {
		return PlayerGold;
	}

	public void setPlayerGold(int playerGold) {
		PlayerGold = playerGold;
	}

	public int getKillCount() {
		return KillCount;
	}

	public void setKillCount(int killCount) {
		KillCount = killCount;
	}

	public int getPlayerLocation() {
		return PlayerLocation;
	}

	public void setPlayerLocation(int playerLocation) {
		PlayerLocation = playerLocation;
	}

	public int getPlayerMaxHealth() {
		return PlayerMaxHealth;
	}

	public void setPlayerMaxHealth(int playerMaxHealth) {
		PlayerMaxHealth = playerMaxHealth;
	}

	public int getPlayerCurrentHealth() {
		return PlayerCurrentHealth;
	}

	public void setPlayerCurrentHealth(int playerCurrentHealth) {
		PlayerCurrentHealth = playerCurrentHealth;
	}

	public int getPlayerScore() {
		return PlayerScore;
	}

	public void setPlayerScore(int playerScore) {
		PlayerScore = playerScore;
	}
	public void printPlayerDetails() {
		System.out.println("Player Name:"+ PlayerName
						+"\nPlayer Health:"+PlayerCurrentHealth+"/"+PlayerMaxHealth
						+"\nPlayer Score:"+PlayerScore
						+"\nPlayer Kill Count:"+KillCount);
		
	}


}
