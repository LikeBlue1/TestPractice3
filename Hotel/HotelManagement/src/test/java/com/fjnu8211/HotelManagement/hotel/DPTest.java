package com.fjnu8211.HotelManagement.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DPTest {

	private DP dp = new DP();
	
	@Before
	public void setUp() throws Exception {
		dp.iniRooms();
	}

	/*
	 * 成功入住
	 */
	@Test
	public void testIn_Room() {
		assertThat("Marry成功入住901房间！", is(dp.in_Out_Room(901, "Marry")));
	}
	
	/*
	 * 已经有人入住
	 */
	@Test
	public void testIn_RoomFail() {
		dp.in_Out_Room(901, "Marry");
		assertThat("该房间已经有客人入住！", is(dp.in_Out_Room(901, "John")));
	}
	
	/*
	 * 退房
	 */
	@Test
	public void testOut_Room() {
		dp.in_Out_Room(901, "Marry");
		assertThat("901退房成功！", is(dp.in_Out_Room(901, "EMPTY")));
	}
	
	/*
	 * 退房失败
	 */
	@Test
	public void testOut_RoomFail() {
		assertThat("该房间没有客人入住，退房失败！", is(dp.in_Out_Room(901, "EMPTY")));
	}

}
