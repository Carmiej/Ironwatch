public class Main {

    public static void main(String[] args) {
    	boolean game = true;
    	Map map = new Map();
    	map.readFile();
    	Explore activeAdventure = new Explore();
    	Combat combat = new Combat();
    	Player player = new Player();
    	player.PlayerCreate();
    	
    	while(game == true){
    		activeAdventure.Exploration(map, player);
    	}
    }
}
