package DB;

public class sale {
	   private String name;
	   private double sale;
	   private float month;
	   
	   public sale(String name, double sales, int month) {
	      
	      this.name = name;
	      this.sale = sales;
	      this.month = month;
	   }

	   public sale(float month) {
	      super();
	      this.month = month;
	   }

	   public sale(String name1, double sales2) {
	      // TODO Auto-generated constructor stub
	   }

	   public sale(double sale) {
	      this.sale = sale;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public double getSales() {
	      return sale;
	   }

	   public void setSales(int sales) {
	      this.sale = sales;
	   }

	   public double getMonth() {
	      return month;
	   }

	   public void setMonth(int month) {
	      this.month = month;
	   }
	   
	   
	   
	}