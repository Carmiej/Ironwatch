package models;

import java.util.Scanner;
import javax.swing.JLabel;

import javax.swing.JTextPane;

import views.ExplorePanel;

/**
 * Created by blake on 10/03/2017.
 */
public class Player {

	private String PlayerName = null;
	private int PlayerLevel = 1;
	private int PlayerXp = 0;
	private int PlayerDamage = 10;
	private int PlayerArmor = 0;
	private int PlayerGold = 10;
	private int KillCount = 0;
	private int PlayerLocation = 1;
	private int PlayerMaxHealth = 100;
	private int PlayerCurrentHealth = PlayerMaxHealth;

        
        //Basic getters and setters for the player class.
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
		this.PlayerLocation = playerLocation;
	}
	
	public void setPlayerLocation(int playerLocation, int[] is, JTextPane textPane) {

		for (int x = 0; x < is.length; ++x) {
			if (playerLocation == is[x]) {
				PlayerLocation = playerLocation;
				textPane.setText("You have entered another room!");
				return;
			}
			else{
				textPane.setText("You have made an invalid room entry!");
			}
		}
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

	public void takeDamage(int damage) {
		PlayerCurrentHealth = PlayerCurrentHealth - (damage - PlayerArmor);
	}

	public boolean checkLevelUp() {
		if (PlayerXp >= (PlayerLevel * 10 + (PlayerLevel + 2)*3)) {
			PlayerLevel++;
			PlayerMaxHealth += (1 + PlayerLevel);
			PlayerCurrentHealth = PlayerCurrentHealth + (PlayerMaxHealth / 5);
			if(PlayerLevel % 2 == 0){
				PlayerArmor++;
			}
			else if(PlayerLevel % 1 == 0){
				PlayerDamage++;
			}
			return true;
		}
		return false;
	}

	public String getPlayerInformation() {
		return "Hero name: " + PlayerName + "             Level: " + PlayerLevel + "\nHealth: " + PlayerCurrentHealth + "/"
				+ PlayerMaxHealth + "             Gold: " + PlayerGold + "\nExp: " + PlayerXp + "                     KillCount: "
				+ KillCount + "\nDamage: " + PlayerDamage + "               Armour: "+PlayerArmor;
	}

}
