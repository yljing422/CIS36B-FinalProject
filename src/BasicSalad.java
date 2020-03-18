/**
* @author Yunjing Mai
* @author Xinfang Zhang
* @author Jing Yang
* CIS 36B, Final Project
*/

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class BasicSalad {
	ArrayList<Ingredient> dishIngredient;
	private final double SMALL_PRICE = 6.45;
	private final double LARGE_PRICE = 7.65;
	private String size;
	private double price;
	private int calories;
	
	public BasicSalad() {
		price = SMALL_PRICE;
		size = "small";
		dishIngredient = new ArrayList<>();
	}

	public ArrayList<Ingredient> getDishIngredient() {
		return dishIngredient;
	}

	public void setDishIngredient(ArrayList<Ingredient> dishIngredient) {
		this.dishIngredient = dishIngredient;
	}

	public BasicSalad(String size) {
		dishIngredient = new ArrayList<>();
		this.size = size;
		if (size.equals("small")) {
			price = SMALL_PRICE;
		} else {
			price = LARGE_PRICE;
		}
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(String size) {
		if (size.equalsIgnoreCase("large")){
			price = LARGE_PRICE;
		} else {
			price = SMALL_PRICE;
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

	public void add(Ingredient in) {
		for (int i = 0; i < dishIngredient.size(); i++) {
			if (dishIngredient.get(i).getName().equalsIgnoreCase(in.getName())){
				dishIngredient.get(i).setNumber(dishIngredient.get(i).getNumber() + 1);
				//change price?? TODO
				return;
			}
		}
		dishIngredient.add(new Ingredient(in.getType(), in.getName(), 1, in.getCalories()));
		if (!in.getType().equalsIgnoreCase("Dressing")) {
			addPrice();
		}
	}

	public void remove(Ingredient in) {
		for (int i = 0; i < dishIngredient.size(); i++) {
			Ingredient currentIngredient = dishIngredient.get(i);
			if (currentIngredient.getName().equalsIgnoreCase(in.getName())) {
				if (currentIngredient.getNumber() == 1) {
					dishIngredient.remove(i);
				} else {
					currentIngredient.setNumber(currentIngredient.getNumber() - 1);
				}
				break;
			}
		}
		if (!in.getType().equalsIgnoreCase("Dressing")) {
			removePrice();
		}
	}

	public int findIngredientNumber(String name) {
		for (int i = 0; i < dishIngredient.size(); i++) {
			if (dishIngredient.get(i).getName().equalsIgnoreCase(name)) {
				return dishIngredient.get(i).getNumber();
			}
		}
		return 0;
	}

	/**
	 * print ingredient in the selfIngredient;
	 */
	public String printIngredient() {
		String in = "\n";
		for (int i = 0; i < dishIngredient.size() - 1; i++) {
			in += dishIngredient.get(i).getName() + ", ";
		}
		in += dishIngredient.get(dishIngredient.size() - 1).getName();
		return in;
	}
	
	public abstract int totalCalories(); // 
	
	@Override public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "\nSize: " + size + "\nPrice: " + df.format(price); 
	}
	
	
}

