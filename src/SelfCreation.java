/**
* @author Yunjing Mai
* @author Xinfang Zhang
* CIS 36B, Final Project
*/

public class SelfCreation extends BasicSalad {
	private final String NAME = "Self made";

	/**
	 * Default constructor for SelfCreation. 
	 * call superclass
	 */
	public SelfCreation() {
		super();
	}

	/**
	 * One argument constructor for SelfCreation.
	 * call superclass with size
	 */
	public SelfCreation(String size) {
		super(size);
	}

	/**
	 * Calculate the total calories for all ingredients within a salad
	 * @return total calories
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
	 * Call printIngredient() from BasicSalad
	 * Print the name and the total calories of the salad 
	 */
	@Override
	public String toString() {
		return "\nYour choice: " + NAME + printIngredient() + "\nCalorie: " + this.totalCalories() + " calories"
				+ super.toString();
	}

}
