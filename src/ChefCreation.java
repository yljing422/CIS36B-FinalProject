/**
* @author Xinfang Zhang
* @author Yunjing Mai
* CIS 36B, Final Project
*/

public class ChefCreation extends BasicSalad {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
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
	}
	
	/**
	 * Two-arguments constructor for ChefCreation. 
	 * Set the price and size to default value  
	 * Declare a ArrayList for all ingredients for the Chefcreations
	 */
	public ChefCreation(String name, String size) {
		super(size);
		this.name = name;
	}

	@Override 
	public int totalCalories() {
		for (int i = 0 ; i < dishIngredient.size() ; i++) {
			super.setCalories(super.getCalories() + dishIngredient.get(i).getCalories());
		}
		if(super.getSize().equalsIgnoreCase("small")) {
			return (int)( super.getCalories()*0.6);
		}else {
			return super.getCalories();
		}
		
	}

	public void increaseProteinSize() {
		for (int i = 0; i < dishIngredient.size(); i++) {
			if (dishIngredient.get(i).getType().equalsIgnoreCase("protein")) {
				dishIngredient.add(dishIngredient.get(i));
				break;
			}
		}
	}

	/**
	 * call printIngredient()
	 */
	@Override public String toString() {
		return "\nYour choice: " + name + printIngredient() + "\nCalorie: " + this.totalCalories() + " calories" + super.toString();
	}
}