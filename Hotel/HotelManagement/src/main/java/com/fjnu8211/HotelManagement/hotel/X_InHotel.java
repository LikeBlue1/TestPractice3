package com.fjnu8211.HotelManagement.hotel;

/*
 * 修改InHotel类
 */
public class X_InHotel {

	private IData iData;
	
	public X_InHotel(IData iData) {
		this.iData = iData;
	}
	
	public X_InHotel() {
		
	}
	
	public String in(int roomNo, String name) {
		return iData.in_Out_Room(roomNo, name);
	}
	
}
