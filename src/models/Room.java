package models;

import java.util.Random;

/*
 *  Created by Maxwell Francis (BOI) on 1/04/2017.
 */
public class Room extends Map {

	private int roomNum;
	private String desc;
        private String img;
	private boolean item;
	private int[] connectedRooms;
	boolean monster;

	// initialization for a new room
	public Room(int roomNum, String desc, boolean item, int[] connectedRooms, boolean monsterCheck, String img) {
		this.desc = desc;
		this.roomNum = roomNum;
		this.item = item;
		this.connectedRooms = connectedRooms;
		this.monster = monsterCheck;
                this.img = img;
	}

	// prints information about the room
	public String printInfo() {
		System.out.println("Observation: " + desc + "\nConnected rooms:");
		for (int i = 0; i < connectedRooms.length; i++) {
			System.out.print(connectedRooms[i] + " ");
		}
		System.out.println();
		return "Observation: " + desc + "\nConnected rooms:";
	}

	public int[] getConnectedRooms() {
		return connectedRooms;
	}

	public String getDesc() {
		return desc;
	}
        
        public String getImg() {
            return img;
        }

	public boolean getMonster() {
		return monster;
	}
	
	public void setMonster(boolean isAlive){
		this.monster = isAlive;
	}
}
