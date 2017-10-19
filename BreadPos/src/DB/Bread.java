package DB;

public class Bread {
	private String name;
	private int price;
	private String kind;
	
	public Bread(String name, int price, String kind) {
		super();
		this.name = name;
		this.price = price;
		this.kind = kind;
	}
	
	public Bread(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
