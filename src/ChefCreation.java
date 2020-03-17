/**
* @author Xinfang Zhang
* @author Yunjing Mai
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public class ChefCreation extends BasicSalad {
	ArrayList<Ingredient> chefIngredient;
	public static final String[] dishesName = {"CHICKEN CAESAR", "SOUTHWESTERN CHICKEN", "SPINACH BACON", "SPRING GREEN SALAD", "MEDITERRANEAN PASTA", "CHINESE CHICKEN"};
	public static final String[] chickenCaesar = {"Grilled Marinated Chicken", "Romaine Lettuce", "Parmesan Shredded And Grated Cheese", "Crispy Croutons", "Caesar Dressing"};
	public static final String[] southwesternChicken = {"Grilled Marinated Chicken", "Avocado", "Tomato", "Black Beans", "Corn", "Parmesan Shredded And Grated Cheese", "Tortilla Chips", "Romaine Lettuce", "Cilantro Dressing", "Chipotle Dressing"};
	public static final String[] spinachBacon = {"Organic Baby Spinach", "Bacon", "Chopped Egg", "Roasted Peppers", "Carrot", "Mandarin Oranges", "Bean Sprouts", "Sesame Dressing"};
	public static final String[] springGreenSalad = {"Spring Mix", "Candied Walnuts", "Dried Cranberries", "Apples", "Grilled Marinated Chicken", "Mushrooms", "Balsamic Vinegar"};
	public static final String[] mediterraneanPasta = {"Spring Mix", "Pasta", "Roasted Peppers", "Olives", "Garbanzos Beans", "Cucumbers", "Feta Cheese", "Pesto Dressing"};
	public static final String[] chineseChicken = {"Grilled Marinated Chicken", "IceBerg Lettuce", "Cilantro", "Green Onion", "Fried Noodles", "Peanuts", "Sesame Dressing"};
	
	
	/**
	 * Default constructor for ChefCreation.
	 * Set the price and size to default value  
	 * Declare a ArrayList for all ingredients for the Chefcreations
	 */
	public ChefCreation() {
		super();
		chefIngredient = new ArrayList<>();
	}
	
	/**
	 * Two-arguments constructor for ChefCreation. 
	 * Set the price and size to default value  
	 * Declare a ArrayList for all ingredients for the Chefcreations
	 */
	public ChefCreation(String name, String size) {
		super(name, size);
		chefIngredient = new ArrayList<Ingredient>();
	}
	
	/**
	 * Copy the ingredients into the ArrayList chefcreations
	 * @param in the list of ingredients for chefcreation
	 */
	public void setIngredient(ArrayList<Ingredient> in) {
		for (int i = 0; i < in.size(); i++) {
			chefIngredient.add(in.get(i));
		}
	}
	
	
	/**
	 * Returns the list of the ingredients for chefCreation
	 * @return the list of the ingredients 
	 */
	public ArrayList<Ingredient> getIngredient (){
		return this.chefIngredient;
	}
	/**
	 * Add a new ingredient to the salad
	 * @param i new ingredient
	 */
	@Override
	public void add(Ingredient in) {
		chefIngredient.add(in);
	}
	
	/**
	 * Remove the ingredient from the salad
	 * @param i the ingredient need to remove 
	 */
	@Override
	public void remove(String in) {
		for (int i = 0; i < chefIngredient.size(); i++) {
			if (chefIngredient.get(i).getName().equalsIgnoreCase(in)) {
				chefIngredient.remove(i);
				break;
			}
		}
		removePrice();
	}
	
	/**
	 * Calculate the total calories for all ingredients within a salad
	 */
	@Override 
	public int totalCalories() {
		for (int i = 0 ; i < this.chefIngredient.size() ; i++) {
			super.setCalories(super.getCalories() + this.chefIngredient.get(i).getCalories());
		}
		if(super.getSize().equalsIgnoreCase("small")) {
			return (int)( super.getCalories()*0.6);
		}else {
			return super.getCalories();
		}
		
	}

	/**
	 * print ingredient in the selfIngredient;
	 */
	public String printIngredient() {
		String in = "\n";
		for (int i = 0; i < chefIngredient.size() - 1; i++) {
			in += chefIngredient.get(i).getName() + ", ";
		}
		in += chefIngredient.get(chefIngredient.size() - 1).getName();
		return in;
	}
	
	/**
	 * call printIngredient()
	 */
	@Override public String toString() {
		return "\n\nYour choice: " + getName() + printIngredient() + "\nCalorie: " + this.totalCalories() + " calories" + super.toString();
	}
}



