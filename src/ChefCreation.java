/**
* @author Xinfang Zhang
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public class ChefCreation extends BasicSalad {
	ArrayList<Ingredient> chefIngredient;
	public static final String[] dishesName = {"CHICKEN CAESAR", "SOUTHWESTERN CHICKEN", "SPINACH BACON", "SPRING GREEN SALAD", "MEDITERRANEAN PASTA", "CHINESE CHICKEN"};
	public static final String[] chickenCaesar = {"Grilled Marinated Chicken", "Romaine Lettuce", "\nParmesan Shredded And Grated Cheese", "\nCrispy Croutons", "Caesar Dressing"};
	public static final String[] southwesternChicken = {"Grilled Marinated Chicken", "Avocado", "\nTomato", "Black Beans", "Corn", "\nParmesan Shredded And Grated Cheese", "\nTortilla Chips", "Romaine Lettuce", "\nCilantro Dressing", "Chipotle Dressing"};
	public static final String[] spinachBacon = {"Organic Baby Spinach", "Bacon", "Chopped Egg", "\nRoasted Peppers", "Carrot", "Mandarin Oranges", "\nBean Sprouts", "Sesame Dressing"};
	public static final String[] springGreenSalad = {"Spring Mix", "Candied Walnuts", "Dried Cranberries", "\nApples", "Grilled Marinated Chicken", "\nMushrooms", "Balsamic Vinegar"};
	public static final String[] mediterraneanPasta = {"Spring Mix", "Pasta", "Roasted Peppers", "\nOlives", "Garbanzos Beans", "Cucumbers", "\nFeta Cheese", "Pesto Dressing"};
	public static final String[] chineseChicken = {"Grilled Marinated Chicken", "IceBerg Lettuce", "\nCilantro", "Green Onion", "Fried Noodles", "\nPeanuts", "Sesame Dressing"};
	
	
	public ChefCreation() {
		super();
		chefIngredient = new ArrayList<>();
	}
	
	public ChefCreation(String name, String size) {
		super(name, size);
		chefIngredient = new ArrayList<Ingredient>();
	}
	
	public void setIngredient(ArrayList<Ingredient> in) {
		for (int i = 0; i < in.size(); i++) {
			chefIngredient.add(in.get(i));
		}
	}
	
	@Override
	public void add(Ingredient in) {
		chefIngredient.add(in);
	}
	
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

