package com.fjnu8211.HotelManagement.hotel;

/*
 * InHotel:客人入住酒店类
 */
public class InHotel extends Empty {

	private int room;
	
	public String in(int roomNo, String name) {
		MainRun mr = new MainRun();
		room = (roomNo%100)-1;
		if(isEmpty(roomNo)) {
			mr.getRoom()[(roomNo/100)-1][room] = name;
			return name + "成功入住" + roomNo + "房间！";
		}else {
			return "该房间已经有客人入住！";
		}
	}
	
	public boolean isEmpty(int roomNo) {
		String room = mr.getRoom()[(roomNo/100)-1][(roomNo%100)-1];
		if("EMPTY".equals(room)) {
			return true;
		}else {
			return false;
		}
	}

}
