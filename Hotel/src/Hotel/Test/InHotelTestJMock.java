package Hotel.Test;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import HotelSoft.IData;
import HotelSoft.InHotel;

public class InHotelTestJMock {
	private Mockery context = new Mockery();
	private IData iData = null;
	
	@Test
	public void testInSuccess(){
		iData = context.mock(IData.class);
		InHotel inHotel = new InHotel(iData);
		context.checking(new Expectations(){{
			oneOf(iData).in_Out_Room(101,"张三");
			will(returnValue("张三成功入住101房间！"));
		}
		});
		String result = inHotel.in(101, "张三");
		assertEquals("张三成功入住101房间！",result);
	}
	
	
	@Test
	public void testInFailure(){
		iData = context.mock(IData.class);
		InHotel inHotel = new InHotel(iData);
		context.checking(new Expectations(){{
			oneOf(iData).in_Out_Room(101,"张三");
			will(returnValue("该房间已经有客人入住！"));
		}
		});
		assertEquals(inHotel.in(101, "张三"),"该房间已经有客人入住！");
	}
	
}
