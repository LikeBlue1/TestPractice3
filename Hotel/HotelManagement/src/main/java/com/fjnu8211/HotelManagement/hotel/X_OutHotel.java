package com.fjnu8211.HotelManagement.hotel;

/*
 * 修改OutHotel类
 */
public class X_OutHotel {
	
	IData iData;
	private HotelConstant hc = new HotelConstant();
	
	public X_OutHotel(IData iData) {
		this.iData = iData;
	}
	
	public X_OutHotel() {
		
	}
	
	public String out(int roomNo) {
		return iData.in_Out_Room(roomNo, hc.EMPTY);
	}

}
