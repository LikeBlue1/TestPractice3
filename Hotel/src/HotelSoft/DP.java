package HotelSoft;



public class DP implements IData{

	private static String[][] rooms;	//表示房间
	MainRun mr = new MainRun();

	public void iniRooms() {
		rooms = new String[12][12];
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				rooms[i][j] = "EMPTY";
			}
		}
	}

	public int roomNo(int roomNo) {
		if("EMPTY".equals(rooms[(roomNo/100)-1][(roomNo%100)-1])) {		//表示房间为空
			return roomNo;
		}else {		//表示房间有人入住
			return 0;
		}
	}

	public String getStation(int roomNo) {
		return rooms[(roomNo/100)-1][(roomNo%100)-1];
	}
	
	public String in_Out_Room(int roomNo, String name) {
		//当name=""表示退房
		if(name.equals("EMPTY")) {
			if(roomNo(roomNo) == 0) {
				rooms[(roomNo/100)-1][(roomNo%100)-1] = name;
				return roomNo + "退房成功!";
			}else {
				return "该房间没有客人入住，退房失败!";
			}
		}else {
			if(roomNo(roomNo) == 0) {
				return "该房间已经有客人入住!";
			}else {
				rooms[(roomNo/100)-1][(roomNo%100)-1] = name;
				return name + "成功入住" + roomNo + "房间!";
			}
		}
	}
	
}
