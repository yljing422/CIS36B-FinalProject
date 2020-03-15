//
/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public class SelfCreation extends BasicSalad {
	ArrayList<Ingredient> selfIngredient;
	
	public SelfCreation() {
		super();
		selfIngredient = new ArrayList<>();
	}
	
	public SelfCreation(String size) {
		super("Self Made", size);
		selfIngredient = new ArrayList<>();
	}
	
	public void setIngredient(ArrayList<Ingredient> in) {
		for (int i = 0; i < in.size(); i++) {
			selfIngredient.add(in.get(i));
		}
	}
	
	@Override
	public void add(Ingredient in) {
		selfIngredient.add(in);
	}
	
	@Override
	public void remove(String in) {
		for (int i = 0; i < selfIngredient.size(); i++) {
			if (selfIngredient.get(i).getName().equalsIgnoreCase(in)) {
				selfIngredient.remove(i);
				break;
			}
		}
		removePrice();
	}
	
	@Override 
	public int totalCalories() {
		for (int i = 0 ; i < selfIngredient.size() ; i++) {
			super.setCalories(super.getCalories() + selfIngredient.get(i).getCalories());
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
		for (int i = 0; i < selfIngredient.size() - 1; i++) {
			in += selfIngredient.get(i).getName() + ", ";
		}
		in += selfIngredient.get(selfIngredient.size() - 1).getName();
		return in;
	}
	
	/**
	 * call printIngredient()
	 */
	@Override public String toString() {
		return "\n\nYour choice: " + getName() + printIngredient() + "\nCalorie: " + this.totalCalories() + " calories" + super.toString();
	}
	
}


