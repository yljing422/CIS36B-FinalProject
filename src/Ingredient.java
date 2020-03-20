/**
* @author Jing Yang
* CIS 36B, Final Project
*/

public class Ingredient implements Comparable<Ingredient> {
	private String type;
	private String name;
	private int number;
	private int calories;
	
	/**
	 * Default constructor, set type, name, number, calories to default value
	 */
	public Ingredient() {
		this("Unknow type", "Unknow name", 0, 0);
	}

	/**
	 * All arguments constructor, specify the value of type, name, number and calories
	 */
	public Ingredient(String type, String name, int number, int calories) {
		this.type = type;
		this.name = name;
		this.number = number;
		this.calories = calories;
	}

	/**
	 * Deep copy constructor
	 */
	public Ingredient(Ingredient i) {
		type = i.type;
		name = i.name;
		number = i.number;
		calories = i.calories;
	}
	
	// Getters
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}

	public int getCalories() {
		return calories;
	}
	
	// Setters
	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	/**
	 * Print the type, name, number and calories of the salad	
	 */
	@Override 
	public String toString() {
		return "Type: " + type + "\nName: " + name + "\nNumber: " + number + "\nCalories: " + calories + "\n\n";
	}
	
	/**
	 * Compare the titles and  types of the ingredients 
	 * @return whether two ingredients have the same name and type
	 */
	@Override 
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (!(o instanceof Ingredient)) {
			return false;
		} else {
			Ingredient i = (Ingredient) o;
			return name.equals(i.name) && type.equals(i.type);
		}
	}
	
	/**
	 * Compares two ingredient. Returns 0 if the two ingredients are equal 
	 * If not same, then compare names , types , and calories of two different ingredients 
	 */
	@Override 
	public int compareTo(Ingredient i) {
		if (this.equals(i)) {
			return 0;
		} else if (!(name.equals(i.name))) {
			return name.compareTo(i.name);
		} else if (!(type.equals(i.type))) {
			return type.compareTo(i.type);
		} else {
			return Integer.compare(calories, i.calories);
		}
	}
}
