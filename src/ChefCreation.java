/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public class ChefCreation extends BasicSalad {
	String dishName;
	ArrayList<Ingredient> chefIngredient;
	//the other 5 variable
	String[] chickenCaesar = {"Marinated Chicken", "Romaine Lettuce", "Shredded N Grated"};
	
	public ChefCreation(ArrayList<Ingredient> i, String name) {
		dishName = name;
		chefIngredient = new ArrayList<Ingredient>();
		switch (name) {
			case "CHIKEN CAESAR":
				createDish(i, chickenCaesar);
				break;
			case "ABC":
				//TODO goes here for other dish
		}
	}
	
	public void add(ArrayList<Ingredient> i, String ingredient) {
		
	}
	
	//
	private void createDish(ArrayList<Ingredient> indredients, String[] dishIng) {
		for (int i = 0; i < dishIng.length; i++) {
			for (int j = 0; j < indredients.size(); j++) {
				if (dishIng[i].equals(indredients.get(j).getName())) {
					Ingredient dishIngredients = new Ingredient(indredients.get(j));
					chefIngredient.add(dishIngredients);
					break;
				}
			}
		}
	}
}
