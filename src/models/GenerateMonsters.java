package models;

import java.math.*;
import java.util.Random;

/*
 * this class stores data on different monsters and generates a monster based on player data
 */
public class GenerateMonsters {

	public Monster generate(Player player) {
		int number = 1;
		Monster monster = null;
		Random rand = new Random();
		number = rand.nextInt(20) + 1;

		if (player.getPlayerLocation() >= 1 && player.getPlayerLocation() < 10) {
			if (number >= 1 && number <= 2) {
				monster = Slime();
			} else if (number >= 3 && number <= 7) {
				monster = Ghoul();
			} else if (number >= 10 && number <= 18) {
				monster = PrisonGuard();
			} else if (number >=8 && number <= 9) {
				monster = CrazedGuard();
			} else if (number >= 19 && number <= 20) {
				monster = Dog();
			}
		}else if(player.getPlayerLocation() == 10){
			monster = prisonWarden();
		}

		return monster;

	}

	private Monster prisonWarden() {
		Monster warden = new Monster("Prison Warden Gareth", 140, 10, 15, 20, 4,
				"Cell or death, You're not getting through!", "/warden.jpg");
		return warden;
	}

	private Monster Dog() {
		Monster dog = new Monster("dog", 40, 7, 5, 0, 1, "Bark! Bark!", "/dog.jpg");
		return dog;
	}

	private Monster CrazedGuard() {
		Monster crazedGuard = new Monster("(crazed) Prison Guard", 80, 15, 10, 8, 3,
				"Stop running! Take your judgement!", "/crazedprisonguard.jpg");
		return crazedGuard;
	}

	private Monster PrisonGuard() {
		Monster guard = new Monster("Prison Guard", 50, 9, 7, 8, 2, "Halt", "/prisonguard.jpg");
		return guard;
	}

	// Slime monster
	private Monster Slime() {
		Monster slime = new Monster("Slime", 20, 2, 1, 0, 0, "Sqwelch!", "/slime.jpg");
		return slime;
	}

	// Ghoul monster
	private Monster Ghoul() {
		Monster ghoul = new Monster("ghoul", 60, 6, 6, 5, 1, "Join US", "/ghoul.jpg");
		return ghoul;
	}

}
