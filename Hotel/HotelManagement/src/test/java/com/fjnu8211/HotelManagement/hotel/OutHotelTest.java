package com.fjnu8211.HotelManagement.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

@SuppressWarnings("static-access")
public class OutHotelTest {

	private MainRun mr = new MainRun();
	private InHotel ih = new InHotel();
	private OutHotel oh = new OutHotel();
	
	@Test
	public void testOutSuccess() {
		mr.initRooms();
		ih.in(901, "John");
		assertThat("901退房成功！", is(oh.out(901)));
	}
	
	@Test
	public void testOutFail() {
		mr.initRooms();
		assertThat("该房间没有客人入住，退房失败！", is(oh.out(801)));
	}

}
