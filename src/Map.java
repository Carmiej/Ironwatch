/**
 * Created by Maxwell Francis (BOI) on 14/03/2017.
 */
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Map {
	
	static int numRooms = 0;
	//The ArrayList for the rooms
	ArrayList<Room> rooms = new ArrayList<>();
	
	//Reads in the RoomDatabase.txt file and populates the map with data from the file
	public void readFile(){
		Path roomfile = Paths.get("RoomDatabase.txt");
		
		//room temporary storage information
		String desc = "";
		int roomNum = 0;
		boolean item = true;
		int[] connectedRooms;
		String tempConnectedRooms;
		
		//try statement
		try(BufferedReader reader =Files.newBufferedReader(roomfile)){
		String line = "";

		/*	This for loop is designed to read in the file line by line
		 * 	and intelligently store each rooms information as a new Room 
		 */
			    for (int x = 0;(line = reader.readLine()) != null;) {
			    	if(line.contains("*")){
						roomNum = Integer.parseInt(reader.readLine());  
						desc = reader.readLine();
						item = Boolean.parseBoolean(reader.readLine());
						tempConnectedRooms = reader.readLine();
						connectedRooms = toIntegerArray(tempConnectedRooms);
						rooms.add(new Room(x, desc, item, connectedRooms));
						++x;
			    	}
			    	else{
			    		System.out.println("INCORRECT FORMAT, CORRECTION OF DATABASE REQUIRED!");
			    	}
			    }
		//catch statement
		}catch (IOException x){
			System.err.printf("IOException: %s", x);
		}
	}
	
	//Converts the connectedRooms String to the integer array @connectedRooms
	public static int[] toIntegerArray(String input){
		String numberLine = input;
		String[] tokens = numberLine.split(" ");
		int[] numbers;
		numbers = new int[tokens.length];
		
		for(int i=0;i<tokens.length;i++){
			numbers[i] = new Integer(tokens[i]).intValue();
			}
		return numbers;
		}
	
	//Prints the current number room the player is in
	public void printRoom(Player player) {
		System.out.println("You are in room: "+player.getPlayerLocation());
	}

	//prints details about the room the player is in
	public void printRoomDetails(int playerLocation) {
		rooms.get(playerLocation-1).printInfo();
	}
	
	public int[] connectedRooms(int playerLocation) {
		int[]connectedRooms = rooms.get(playerLocation-1).getConnectedRooms();
		return connectedRooms;
	}
}
