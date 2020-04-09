package com.fjnu8211.HotelManagement.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class X_InHotelTest {
	
	private Mockery context = new Mockery();
	private IData iData = null;
	private X_InHotel ih = null;

	/*
	 * 测试一
	 */
	/*
	@Before
	public void setUp() throws Exception {
		iData = context.mock(IData.class);
		ih = new X_InHotel(iData);
		
		context.checking(new Expectations() {{
			oneOf(iData).in_Out_Room(901, "Marry");
			will(returnValue("Marry成功入住901房间!"));
		}});
	}
	
	@Test
	public void testIn() {
		String result = ih.in(901, "Marry");
		assertThat("Marry成功入住901房间!", is(result));
	}
	*/
	
	/*
	 * 测试二
	 */
	/*
	@Before
	public void setUp() throws Exception {
		iData = context.mock(IData.class);
		ih = new X_InHotel(iData);
		
		context.checking(new Expectations() {{
			atLeast(1).of(iData).in_Out_Room(901, "Marry");
			will(onConsecutiveCalls(returnValue("Marry成功入住901房间!"), returnValue("该房间已经有人入住")));
		}});
	}
	
	@Test
	public void testIn() {
		String result1 = ih.in(901, "Marry");
		String result2 = ih.in(901, "Marry");
		assertThat("Marry成功入住901房间!", is(result1));
		assertThat("该房间已经有人入住", is(result2));
	}
	*/
	
	/*
	 * 测试三
	 */
	@Before
	public void setUp() throws Exception {
		iData = context.mock(IData.class);
		ih = new X_InHotel(iData);
		
		context.checking(new Expectations() {{
			allowing(iData).in_Out_Room(901, "Marry");
			will(onConsecutiveCalls(returnValue("Marry成功入住901房间!"), returnValue("该房间已经有人入住")));
		}});
	}
	
	@Test
	public void testIn() {
		assertThat("Marry成功入住901房间!", is(ih.in(901, "Marry")));
		assertThat("该房间已经有人入住", is(ih.in(901, "Marry")));
	}
	

}
