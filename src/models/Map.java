package models;

/**
 * Created by Maxwell Francis (BOI) on 14/03/2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import views.*;

public class Map {

	static int numRooms = 0;
	// The ArrayList for the rooms
	ArrayList<Room> rooms = new ArrayList<>();

	Path roomfile = Paths.get("inputs/RoomDatabase.txt");
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	// Reads in the RoomDatabase.txt file and populates the map with data from
	// the file
	public void readFile() {
	
		// room temporary storage information
		String desc = "";
                String img = "";
		boolean item = true;
		int[] connectedRooms;
		String tempConnectedRooms;
		boolean monsterCheck;

		// try statement
		try (BufferedReader reader = Files.newBufferedReader(roomfile)) {
			String line = "";

			/*
			 * This for loop is designed to read in the file line by line and
			 * intelligently store each rooms information as a new Room
			 */
			for (int x = 0; (line = reader.readLine()) != null;) {
				if (line.contains("*")) {
					Integer.parseInt(reader.readLine());
					desc = reader.readLine();
					item = Boolean.parseBoolean(reader.readLine());
					tempConnectedRooms = reader.readLine();
					connectedRooms = toIntegerArray(tempConnectedRooms);
					monsterCheck = Boolean.parseBoolean(reader.readLine());
                                        img = reader.readLine();
					rooms.add(new Room(x, desc, item, connectedRooms, monsterCheck, img));
					++x;
				}
			}
			// catch statement
		} catch (IOException x) {
			System.err.printf("IOException: %s", x);
		}
	}
	
	public void repopulate() {
		try (BufferedReader reader = Files.newBufferedReader(roomfile)) {
			String line = "";

			for (int x = 0; (line = reader.readLine()) != null;) {
				if (line.contains("*")) {
					for(int y = 0; y<4;++y){
						reader.readLine();
					}
					rooms.get(x).monster = Boolean.parseBoolean(reader.readLine());
					++x;
				}
			}
			// catch statement
		} catch (IOException x) {
			System.err.printf("IOException: %s", x);
		}
	}

	// Converts the connectedRooms String to the integer array @connectedRooms
	public static int[] toIntegerArray(String input) {
		String numberLine = input;
		String[] tokens = numberLine.split(" ");
		int[] numbers;
		numbers = new int[tokens.length];

		for (int i = 0; i < tokens.length; i++) {
			numbers[i] = new Integer(tokens[i]).intValue();
		}
		return numbers;
	}

	// Prints the current number room the player is in
	public String printRoom(Player player) {
		return "You are in room: " + player.getPlayerLocation();
	}

	// prints details about the room the player is in
	public String printRoomDetails(Player player) {
		return rooms.get(player.getPlayerLocation() - 1).getDesc();
	}

	// returns the connected rooms of the room that the player is currently
	// residing in
	public int[] connectedRooms(int playerLocation) {
		int[] connectedRooms = rooms.get(playerLocation - 1).getConnectedRooms();
		return connectedRooms;
	}
}
