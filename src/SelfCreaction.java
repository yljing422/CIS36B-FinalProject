/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public class SelfCreaction extends BasicSalad {
	ArrayList<Ingredient> selfIngredient;
	
	private String[] organicGreen; //= {"Spring Mix", "Spinach"};
	// the other 4 types
	
	public SelfCreaction() {
	
		selfIngredient = new ArrayList<>();
	}
	
	public String[] getOrganicGreen() {
		return organicGreen;
			
	}

	
	
	private void createType(ArrayList<Ingredient> indredients, String[] dishIng) {
		for (int i = 0; i < dishIng.length; i++) {
			for (int j = 0; j < indredients.size(); j++) {
				if (dishIng[i].equals(indredients.get(j).getName())) {
					Ingredient dishIngredients = new Ingredient(indredients.get(j));
					selfIngredient.add(dishIngredients);
					break;
				}
			}
		}
	}
	
}
