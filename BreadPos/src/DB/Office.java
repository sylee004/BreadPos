package DB;

public class Office {
	private int office_num;
	private String office_name;
	private String office_ID;
	private String office_pass;
	
	
	public Office(int office_num, String office_name, String office_ID, String office_pass) {
		super();
		this.office_num = office_num;
		this.office_name = office_name;
		this.office_ID = office_ID;
		this.office_pass = office_pass;
	}
	
	public Office(int office_num, String office_ID, String office_pass) {
		super();
		this.office_num = office_num;
		this.office_ID = office_ID;
		this.office_pass = office_pass;
	}
	
	public int getOffice_num() {
		return office_num;
	}
	public void setOffice_num(int office_num) {
		this.office_num = office_num;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_ID() {
		return office_ID;
	}
	public void setOffice_ID(String office_ID) {
		this.office_ID = office_ID;
	}
	public String getOffice_pass() {
		return office_pass;
	}
	public void setOffice_pass(String office_pass) {
		this.office_pass = office_pass;
	}
	
	
}