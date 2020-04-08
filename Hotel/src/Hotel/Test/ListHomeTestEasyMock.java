package Hotel.Test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import HotelSoft.HotelConstant;
import HotelSoft.IData;
import HotelSoft.ListHome;

public class ListHomeTestEasyMock {

		@Rule
		public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
		
		private IData iData = null;
		@Test
		public void testSearchWhenAllRoomIsEmpty(){
			iData = createMock("iData",IData.class);
			for(int i = 0 ;i<HotelConstant.total;i++){
				for(int j=0;j<HotelConstant.floor;j++){
					expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.Empty);
				}
			}
			replay(iData);
			
			ListHome lh = new ListHome(iData);
			lh.search();
			
			String lineSeperator= System.getProperty("line.separator");
			StringBuilder sb = new StringBuilder();
			for(int i =0;i<HotelConstant.total;i++){
				for(int j=0;j<HotelConstant.floor;j++){
					if(j+1<10){
						sb.append(i+1+"0"+(j+1)+"\t");
					}else{
						sb.append(i+1+""+(j+1)+"\t");
						
					}
					
				}
				sb.append(lineSeperator);
				for(int j=0;j<HotelConstant.floor;j++){
					sb.append(HotelConstant.Empty+"\t");
				}
				sb.append(lineSeperator);
			}
			assertEquals(sb.toString(), systemOutRule.getLog());
			verify(iData);
		}
		
		
}
