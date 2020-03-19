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
	
	/**
	 * Default constructor, set size to small, 
	 * set price is small price, create a new ArrayList of dish
	 */
	public BasicSalad() {
		price = SMALL_PRICE;
		size = "small";
		dishIngredient = new ArrayList<>();
	}

	/**
	 * one argument constructor, set the size 
	 * and set price according size, small is 6.45, large is 7.65
	 * create a new ArrayList of dish
	 * @param size
	 */
	public BasicSalad(String size) {
		dishIngredient = new ArrayList<>();
		this.size = size;
		if (size.equals("small")) {
			price = SMALL_PRICE;
		} else {
			price = LARGE_PRICE;
		}
	}
	
	// Getters and Setters
	public ArrayList<Ingredient> getDishIngredient() {
		return dishIngredient;
	}

	public void setDishIngredient(ArrayList<Ingredient> dishIngredient) {
		this.dishIngredient = dishIngredient;
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
	
	/**
	 * Adjust price when add extra ingredient except add Dressing, each plus 0.25
	 */
	private void addPrice() {
		price += 0.25;
	}
	
	/**
	 * Adjust price when remove ingredient except remove Dressing, each minus 0.25
	 */
	private void removePrice() {
		price -= 0.25;
	}

	/**
	 * Add extra ingredient to the Salad object, adjust the number of ingredient in the salad and price
	 * @param in the ingredient need added
	 */
	public void add(Ingredient in) {
		for (int i = 0; i < dishIngredient.size(); i++) {
			if (dishIngredient.get(i).getName().equalsIgnoreCase(in.getName())){
				dishIngredient.get(i).setNumber(dishIngredient.get(i).getNumber() + 1);
				return;
			}
		}
		dishIngredient.add(new Ingredient(in.getType(), in.getName(), 1, in.getCalories()));
		if (!in.getType().equalsIgnoreCase("Dressing")) {
			addPrice();
		}
	}

	/**
	 * Remove ingredient from Salad object, adjust the number of ingredient in the salad and price
	 * @param in the ingredient need removed
	 */
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

	/**
	 * Check the number of each ingredient in salad object 
	 * @param name name of the ingredient
	 * @return the number of ingredient in salad
	 */
	public int findIngredientNumber(String name) {
		for (int i = 0; i < dishIngredient.size(); i++) {
			if (dishIngredient.get(i).getName().equalsIgnoreCase(name)) {
				return dishIngredient.get(i).getNumber();
			}
		}
		return 0;
	}

	/**
	 * print ingredient in the salad
	 */
	public String printIngredient() {
		StringBuilder sb = new StringBuilder("\n");
		for (int i = 0; i < dishIngredient.size(); i++) {
			sb.append(dishIngredient.get(i).getName()).append(", quantity: ").append(dishIngredient.get(i).getNumber()).append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Calculate the total calories for one dish
	 * @return
	 */
	public abstract int totalCalories();
	
	@Override public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "\nSize: " + size + "\nPrice: " + df.format(price); 
	}
}
