package DB;

public class Member {
	private String member_phone;
	private String member_name;
	private int member_Money;
	public Member(String member_phone, String member_name, int member_Money) {
		super();
		this.member_phone = member_phone;
		this.member_name = member_name;
		this.member_Money = member_Money;
	}
	
	
	public Member(String member_phone, String member_name) {
		super();
		this.member_phone = member_phone;
		this.member_name = member_name;
	}


	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		member_phone = member_phone;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		member_name = member_name;
	}
	public int getMember_Money() {
		return member_Money;
	}
	public void setMember_Money(int member_Money) {
		member_Money = member_Money;
	}
	
	
}
