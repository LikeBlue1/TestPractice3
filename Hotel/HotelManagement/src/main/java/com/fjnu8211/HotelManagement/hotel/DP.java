package com.fjnu8211.HotelManagement.hotel;

public class DP implements IData {

	private static String[][] rooms;	//表示房间
	MainRun mr = new MainRun();
	private HotelConstant hc = new HotelConstant();
	
	public void iniRooms() {
		rooms = new String[hc.HOTEL_TOTAL_FLOOR][hc.HOTEL_ROOMS_EVERYFLOOR];
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				rooms[i][j] = hc.EMPTY;
			}
		}
	}

	public String in_Out_Room(int roomNo, String name) {
		//当name="EMPTY"表示退房
		if(name.equals(hc.EMPTY)) {
			if(roomNo(roomNo) == 0) {
				rooms[(roomNo/100)-1][(roomNo%100)-1] = name;
				return roomNo + "退房成功！";
			}else {
				return "该房间没有客人入住，退房失败！";
			}
		}else {
			if(roomNo(roomNo) == 0) {
				return "该房间已经有客人入住！";
			}else {
				rooms[(roomNo/100)-1][(roomNo%100)-1] = name;
				return name + "成功入住" + roomNo + "房间！";
			}
		}
	}

	public String getStation(int roomNO) {
		return rooms[(roomNO/100)-1][(roomNO%100)-1];
	}
	
	public int roomNo(int roomNo) {
		if(hc.EMPTY.equals(rooms[(roomNo/100)-1][(roomNo%100)-1])) {
			return roomNo;	//表示房间为空
		}else {
			return 0;		//表示房间有人入住
		}
	}

}
