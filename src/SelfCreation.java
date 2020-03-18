/**
* @author Yunjing Mai
* @author Xinfang Zhang
* CIS 36B, Final Project
*/


public class SelfCreation extends BasicSalad {

	/**
	 * Default constructor for SelfCreation. Set the price and size to default value
	 * Declare a ArrayList for all ingredients for the Selfcreations
	 */
	public SelfCreation() {
		super();
	}

	/**
	 * Two-arguments constructor for SelfCreation. Set the price and size to default
	 * value Declare a ArrayList for all ingredients for the Selfcreations
	 */
	public SelfCreation(String size) {
		super(size);
	}

	/**
	 * Calculate the total calories for all ingredients within a salad
	 */
	@Override
	public int totalCalories() {
		int total = 0;
		for (int i = 0; i < dishIngredient.size(); i++) {
			total += dishIngredient.get(i).getNumber() * dishIngredient.get(i).getCalories();
		}
		return total;
	}

	/**
	 * call printIngredient()
	 */
	@Override
	public String toString() {
		return "\n\nYour choice: self selection" + printIngredient() + "\nCalorie: " + this.totalCalories() + " calories"
				+ super.toString();
	}

}
