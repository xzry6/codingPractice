package com.codingPractice.app.pocketGemsCoding.example;

import java.util.ArrayList;
import java.util.List;

// Given a list of Rooms, find out if they are connected.
public class ConnectedRooms {

	public static void main(String[] args) {
		ConnectedRooms connectedRoom = new ConnectedRooms();
		int height = 5;
		int width = 8;
		List<Room> rooms = new ArrayList<Room>();
		Room r1 = new Room(1, 1, 2, 2);
		Room r2 = new Room(3, 1, 4, 1);
		Room r3 = new Room(6, 1, 2, 2);
		Room r4 = new Room(3, 0, 1, 4);
		Room r5 = new Room(5, 4, 1, 2);
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		rooms.add(r5);

	
		System.out.println(connectedRoom.isConnected(height, width, rooms));
	}

	private int isConnected(int height, int width, List<Room> rooms) {
		// Deal with null and empty first.
		if(rooms == null || rooms.size() == 0)
			return 0;
		// Variables.
		int sum = 0;
		int oneX = -1;
		int oneY = -1;
		boolean[][] map = new boolean[height][width];

		// Read the list and fill the border.
		for(Room room:rooms) {
			if(!preCheck(height, width, room)) return 0;
			drawBorder(room, map);
			oneX = room.x;
			oneY = room.y;
			sum += room.height == 1 || room.width == 1
				 ? room.height * room.width
			     : (room.height+room.width)*2-4;
		}
		// Traverse again and calculate connected area.
		int connectedSum = checkConnected(oneX, oneY, map);

		// Return.
		return sum - connectedSum;
	}

	private boolean preCheck(int height, int width, Room room) {
		if(room.x >= width || room.y >= height) return false;
		if(room.x + room.width > width) return false;
		if(room.y + room.height > height) return false;
		return true;
	}

	private void drawBorder(Room room, boolean[][] map) {
		for(int x=room.x; x<room.x+room.width; ++x) {
			map[room.y][x] = true;
			map[room.y+room.height-1][x] = true;
		}

		for(int y=room.y; y<room.y+room.height; ++y) {
			map[y][room.x] = true;
			map[y][room.x+room.width-1] = true;
		}
	}

	private int checkConnected(int x, int y, boolean[][] map) {
		if(x < 0 || x >= map[0].length) return 0;
		if(y< 0 || y >= map.length) return 0;
		if(!map[y][x]) return 0;

		map[y][x] = false;
		return checkConnected(x-1, y, map)
			 + checkConnected(x+1, y, map)
			 + checkConnected(x, y-1, map)
			 + checkConnected(x, y+1, map)
			 + 1;
	}
}


class Room {  
	int x;
	int y;
	int height;
	int width;

	public Room(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
}
