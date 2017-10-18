package DB;

public class Daily {
	private int day;
	private int money;
	private int officeNum;
	
	public Daily(int day, int money, int officeNum) {
		super();
		this.day = day;
		this.money = money;
		this.officeNum = officeNum;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getOfficeNum() {
		return officeNum;
	}

	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}
	
}
