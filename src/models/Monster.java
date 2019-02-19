package models;

/**
 * Created by blake on 10/03/2017.
 */
public class Monster {

	private String name;
	private int health;
	private int damage;
	private int Exp;
	private int gold;
	private int level;
	private String emote;
        private String imageLink;

	// initialization for the monster object
	public Monster(String name, int health, int damage, int exp, int gold, int level, String emote, String imageLink) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.Exp = exp;
		this.gold = gold;
		this.level = level;
                this.imageLink = imageLink;
	}

	public String getName() {
		return name;
	}

	public void printName() {
		System.out.println(this.name);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void takeDamage(int damage) {
		this.health = this.health - damage;
	}

	public int getDamage() {
		return damage;
	}

	public int getExp() {
		return Exp;
	}

	public int getGold() {
		return gold;
	}

	public int getLevel() {
		return level;
	}

        public String getImageLink() {
		return imageLink;
	}
}
