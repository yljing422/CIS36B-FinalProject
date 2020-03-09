/**
* @author 
* @author 
* CIS 36B, Final Project
*/

public class Ingredient implements Comparable<Ingredient> {
	private String type;
	private String name;
	private int number;
	private int calories;
	
	public Ingredient() {
		type = "Unknow type";
		name = "Unknow name";
		number = 0;
		calories = 0;
	}
	public Ingredient(String type, String name, int number, int calories) {
		this.type = type;
		this.name = name;
		this.number = number;
		this.calories = calories;
	}
	
	public Ingredient(Ingredient i) {
		type = i.name;
		name = i.type;
		number = i.number;
		calories = i.calories;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	// toString()
	
	// equals
	
	public int compareTo(Ingredient i) {
		// first name, second type, third calories
		return 0;
	}

	
}
