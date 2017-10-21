package BreadPos;

import java.util.ArrayList;

import DB.Bread;
import DB.BreadInfoDAO;
import DB.Member;
import DB.MemberInfoDAO;
import DB.Office;
import DB.OfficeDAO;
import DB.Product;
import DB.ProductDAO;

public class Management {
	private BreadInfoDAO bread = new BreadInfoDAO();
	private OfficeDAO office = new OfficeDAO();
	private MemberInfoDAO member = new MemberInfoDAO();
	private ProductDAO product = new ProductDAO();

	public int officeNumIdPw(String input_id, String input_pw) {
		ArrayList<Office> list = office.select_office();
		
		int office_num = 0;
		
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getOffice_ID();
			String pw = list.get(i).getOffice_pass();
			if (input_id.equals(id) && input_pw.equals(pw)) {
				office_num = list.get(i).getOffice_num();
			}

		}

		return office_num;
	}

	public ArrayList<Bread> breadKind(String kind) {
		ArrayList<Bread> list = bread.selectKind(kind);
		return list;
	}

	public int[] name(ArrayList<Integer> payMoney, int percent) {
		int[] money = new int[3];

		int sumMoney = 0;

		for (int i = 0; i < payMoney.size(); i++) {
			sumMoney += payMoney.get(i);
		}
		
		float per = percent / 100f;
		
		
		
		int discountMoney = (int)(sumMoney * per);
		
		
		int totalMoney = sumMoney - discountMoney;
		
		money[0] = sumMoney; //결제금액
		money[1] = discountMoney; //할인금액
		money[2] = totalMoney; //최종금액

		return money;
	}

	public void memberMoney(String name, String phone, int inputMoney) {
		int oldMoney = member.selectMoney(name, phone);
		int totalMoney = oldMoney + inputMoney;
		member.member_updateMoney(phone, name, totalMoney);
	}
	
	public int plusBread(String breadName, String breadKind, int breadPrice) {
		Bread insertBread = new Bread(breadName, breadPrice, breadKind); //생성자를 씀
		int count = bread.bread_insert(insertBread);
		return count; //0이 아닐경우 추가됨
	}

	public int modifyBread(String breadName, String breadKind, int breadPrice) {
		Bread updateBread = new Bread(breadName, breadPrice, breadKind);
		int count = bread.bread_update(updateBread);
		return count;
	}
	
	public int deleteBread(String breadName) {
		int count = bread.delete(breadName);
		return count;
	}
	
	public int modifyOffice(String change_pass, String ID, int num) {
		int count = office.office_update(change_pass, ID, num);
		return count;
	}
	
	public int addMember(String phoneNum, String name) {
		Member addmember = new Member(phoneNum, name);
		int count = member.member_insert(addmember);
		return count;	
	}
	
	public int updateMember(String newPhone, String newName, String phone, String name) {
		int count = member.member_update(newPhone, newName, phone, name);
		return count;
	}
	
	public int deleteMember(String name, String phone) {
		int count = member.delete(name, phone);
		return count;
	}
	
	public int discount(int num, String string) {
		int dis = 0;
		
		if(num == 1) {
			int money = member.selectMoney(string);
			dis = money >= 100000 ? 10 : 5;
		} else if(num == 2) {
			if(string.equals("kt")) {
				dis = 7;
			} else if(string.equals("sk")) {
				dis = 10;
			} else if(string.equals("u+")) {
				dis = 5;
			}
		}
		
		return dis;
	}
	
	public void addProduct(Product pro) {
		int count = 0;
		ArrayList<Product> list = product.product_select();
		boolean ok = true;
		String Mname = "";
		int oldAmount = 0;
		int oldPrice = 0;
		for (int i = 0; i < list.size(); i++) {
			String pname = list.get(i).getPname();
			if(pro.getPname().equals(pname)) {
				ok = false;
				Mname = pname;
				oldAmount = list.get(i).getAmount();
				oldPrice = list.get(i).getPrice();
			}
		}
		if(ok) {
			count = product.product_insert(pro);
		} else {
			int newAmount = oldAmount + pro.getAmount();
			int newPrice = oldPrice + pro.getPrice();
			Product newPro = new Product(Mname, newAmount, newPrice);
			count = product.product_update(newPro);
		}
	}
	
	public ArrayList<Product> selectProduct() {
		ArrayList<Product> Sproduct = product.product_select();
		return Sproduct;
	}
	
	public void deleteProduct() {
		product.product_delete();
	}
}
