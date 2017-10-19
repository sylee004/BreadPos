package BreadPos;

import java.util.ArrayList;

import DB.BreadInfoDAO;
import DB.Office;
import DB.OfficeDAO;

public class Management {
	private BreadInfoDAO bread = new BreadInfoDAO();
	private OfficeDAO office = new OfficeDAO();
	
	public void bread_add() {
		
	}
	
	public int officeNumIdPw(String input_id, String input_pw) {
		ArrayList<Office> list = office.select_office();
		int office_num = 1;
		
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getOffice_ID();
			String pw = list.get(i).getOffice_pass();
			if(input_id.equals(id) && input_pw.equals(pw)) {
				office_num = list.get(i).getOffice_num();
			}
			
		}
		
		return office_num;
	}
	
	
}
