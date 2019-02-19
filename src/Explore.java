import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Maxwell Francis (BOI) on 1/04/2017.
 */
public class Explore {

	Monster monster;
	
	public void Exploration(Map map,Player player){
		System.out.println("room number: "+player.getPlayerLocation());
		System.out.println(map.rooms.get(player.getPlayerLocation()).getDesc());
		Combat combat = new Combat();
		if (map.rooms.get(player.getPlayerLocation()).getMonster())
		{
			GenerateMonsters mon = new GenerateMonsters();
			monster = mon.generate();
			combat.battle(player, monster);
			map.rooms.get(player.getPlayerLocation()).setMonster();
			System.out.println("-----------------------------------------------------------");
			System.out.println("room number: "+player.getPlayerLocation());
			System.out.println(map.rooms.get(player.getPlayerLocation()).getDesc());
		}
		Scanner scan = new Scanner(System.in);
		String command;
		command = scan.next();
		
		if(command.equalsIgnoreCase("help")){
			System.out.println("Following Commands you can type to aid you:"
					+ "\n\"Help\" : displays this help menu with the avaliable commands"
					+ "\n\"Room\" : displays the current room you are in"
					+ "\n\"Enter\" : queries which room to enter"
					+ "\n\"Search\" : searches around the room and displays a report"
					+ "\n\"Status\" : displays the status of player character");
		}
		
		else if(command.equalsIgnoreCase("room")){
			map.printRoom(player);
		}
		
		else if(command.equalsIgnoreCase("enter")){
			System.out.println("Please enter a new room to enter:");
			System.out.print(">");
			command = scan.next();
			boolean valid = false;
			try{
				int roomSelection = Integer.parseInt(command);
				int[]rooms = map.connectedRooms(player.getPlayerLocation());
				for (int i = 0; i < rooms.length; i++) {
					if(rooms[i] == roomSelection){
						player.setPlayerLocation(roomSelection);
						valid = true;
					}
				}
				if(valid){
					System.out.println("You enter a new Room!");
				}
				else{
					System.out.println("Invalid Input!");
				}
			}
			catch(Exception e){
				System.out.println("Incorrect input try again "+player.getPlayerName()+"!");
			}
		}
		
		else if(command.equalsIgnoreCase("search")){
			map.printRoomDetails(player.getPlayerLocation());
		}
		
		else if(command.equalsIgnoreCase("status")){
			player.printPlayerDetails();
		}
	}
}