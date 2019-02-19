import java.util.ArrayList;

/*
 *  Created by Maxwell Francis (BOI) on 1/04/2017.
 */
public class Room extends Map{
	
	int roomNum;
	String desc;
	boolean item;
	int[] connectedRooms;
	boolean monster = true;
	
	public Room(int roomNum, String desc, boolean item, int[] connectedRooms){
		this.desc = desc;
		this.roomNum = roomNum;
		this.item = item;
		this.connectedRooms = connectedRooms;
	}
	
	public void printInfo(){
		System.out.println("\nRoom number:"+(roomNum+1)
				+"\nHas item?"+item
				+"\nDescription:"+desc
				+"\nConnected Rooms:");
		for (int i = 0; i < connectedRooms.length; i++) {
			System.out.print(connectedRooms[i]+" ");
		}
		System.out.println();
	}

	public int[] getConnectedRooms() {
		return connectedRooms;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public boolean getMonster()
	{
		return monster;
	}
	public void setMonster()
	{
		monster = false;
	}
}
