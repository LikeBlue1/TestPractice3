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
			oneOf(iData).in_Out_Room(101,"����");
			will(returnValue("�����ɹ���ס101���䣡"));
		}
		});
		String result = inHotel.in(101, "����");
		assertEquals("�����ɹ���ס101���䣡",result);
	}
	
	
	@Test
	public void testInFailure(){
		iData = context.mock(IData.class);
		InHotel inHotel = new InHotel(iData);
		context.checking(new Expectations(){{
			oneOf(iData).in_Out_Room(101,"����");
			will(returnValue("�÷����Ѿ��п�����ס��"));
		}
		});
		assertEquals(inHotel.in(101, "����"),"�÷����Ѿ��п�����ס��");
	}
	
}
