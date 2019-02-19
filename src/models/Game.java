package models;

public class Game {

	private Map map;
	Player player;
	private Monster monster;
	private GenerateMonsters obtainMonster;

	public void setUp() {
		this.map = new Map();
		map.readFile();
		this.player = new Player();
		this.obtainMonster = new GenerateMonsters();
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	public Player getPlayer() {
		return player;
	}

	public Map getMap() {
		return map;
	}

	public GenerateMonsters getObtainMonster() {
		return obtainMonster;
	} 
	
	
}
