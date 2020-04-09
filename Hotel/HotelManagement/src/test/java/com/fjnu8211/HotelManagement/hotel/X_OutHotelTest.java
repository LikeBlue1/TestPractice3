package com.fjnu8211.HotelManagement.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class X_OutHotelTest {

	private Mockery context = new Mockery();
	private IData iData = null;
	private X_OutHotel xoh = null;
	
	@Before
	public void setUp() throws Exception {
		//用Mockery实例来构造一个模拟的IData对象
		iData = context.mock(IData.class);
		xoh = new X_OutHotel(iData);
		context.checking(new Expectations() {{
			oneOf(iData).in_Out_Room(701, "EMPTY");
			will(returnValue("701退房成功！"));
		}});
	}
	
	@Test
	public void testOut() {
		assertThat("701退房成功！", is(xoh.out(701)));
	}

}
