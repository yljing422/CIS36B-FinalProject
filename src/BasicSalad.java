/**
* @author 
* @author 
* CIS 36B, Final Project
*/

public abstract class BasicSalad {
	private final double SMALL_PRICE = 6.45;
	private final double LARGE_PRICE = 7.65;
	private String name;
	private String size;
	private double price;
	private int calories;
	
	public BasicSalad() {
		name = "Unknow name";
		price = SMALL_PRICE;
		size = "small";
	}
	
	public BasicSalad(String name, String size) {
		this.name = name;
		this.size = size;
		if (size.equals("small")) {
			price = SMALL_PRICE;
		} else {
			price = LARGE_PRICE;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice() {
		if (size.equals("small")) {
			price = SMALL_PRICE;
		} else {
			price = LARGE_PRICE;
		}
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public void addPrice() {
		price += 0.25;
	}
	
	public void removePrice() {
		price -= 0.25;
	}
	
	public abstract void add(Ingredient i);

	public abstract void remove(String i);
	
	public abstract String printIngredient();
	
	public abstract int totalCalories(); // 
	
	@Override public String toString() {
		return "\nSize: " + size + "\nPrice: " + price; 
	}
	
	
}

