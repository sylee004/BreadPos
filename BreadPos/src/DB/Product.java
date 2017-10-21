package DB;

public class Product {
	private String Pname;
	private int amount;
	private int price;
	
	public Product(String pname, int amount, int price) {
		super();
		Pname = pname;
		this.amount = amount;
		this.price = price;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
