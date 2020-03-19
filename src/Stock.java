/**
* @author Jing Yang
* CIS 36B, Final Project
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Stock implements Search {
	ArrayList<Ingredient> stock;
    private static final String fileName = "ingredients.txt";
	
    /**
     * Default constructor for Stock, create a new ArrayList of current stock
     * call populateIngredients() to read from ingredients.txt file
     */
	public Stock() {
		stock = new ArrayList<>();
		populateIngredients();
	}
	
	/**
	 * getter for stock
	 * @return ingredient stock
	 */
	public ArrayList<Ingredient> getStock() {
		return stock;
	}
	
	/**
	 * Reads from a file and populates the catalog thought create Ingredient object and then add in ArrayList
	 */
	public void populateIngredients() {
		String name, type;
		int number, calories;
		
		try {
			File infile = new File(fileName);
	        Scanner input = new Scanner(infile);
	        
	    	while (input.hasNextLine()) {
	    		name = input.nextLine();
	    		type = input.nextLine();
	    		number = input.nextInt();
	    		calories = input.nextInt();
	    		
	    		if (input.hasNextLine()) {
	    			input.nextLine();
	    			input.nextLine();
	    		}
	    		
	    		Ingredient in = new Ingredient(type, name, number, calories);
	    		stock.add(in);
	    	}
	    	
	    	input.close();
		} catch (IOException e) {
			System.out.println(e);
		}
    }
	
	/**
	 * According the same type finding the ingredient name  
	 * @param type type of ingredient
	 * @return the name of the same type of ingredient
	 */
	public ArrayList<Ingredient> findByType(String type) {
		ArrayList<Ingredient> ingredientByType = new ArrayList<>();
		for (int i = 0; i < stock.size(); i++) {
			if (stock.get(i).getType().equalsIgnoreCase(type)) {
				ingredientByType.add(stock.get(i));
			}
		}
		return ingredientByType;
	}
	
	/**
	 * Collect all of the chef creation ingredient after finish select, transfer array to ArrayList, and then call createDish(ArrayList<String> name)
	 * @param name ingredients are ordered
	 */
	public ArrayList<Ingredient> createDish(String[] name){
		Ingredient temp;
		ArrayList<Ingredient> result = new ArrayList<>();
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < stock.size(); j++) {
				if (stock.get(j).getName().equalsIgnoreCase(name[i])) {
					if (stock.get(j).getNumber() <= 0){
						throw new NoSuchElementException("Sorry, not able to create dish, because " + stock.get(j).getName() + " is out of stock");
					}
					temp = new Ingredient(stock.get(j));
					temp.setNumber(1);
					result.add(temp);
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Reduce stock number when ingredient be sold
	 * @param dishIngredients the ingredient be sold
	 */
	public void updateStock(ArrayList<Ingredient> dishIngredients) throws Exception{
		for (int i = 0; i < dishIngredients.size(); i++) {
			Ingredient current = dishIngredients.get(i);
			Ingredient stockIngredient = binarySearch(current.getName());
			if (current.getNumber() > stockIngredient.getNumber()) {
				throw new Exception("Out of stock");
			} else {
				stockIngredient.setNumber(stockIngredient.getNumber() - current.getNumber());
			}
		}
	}

	
	/**
	 * Sort stock data according name, type, calories
	 */
	public void bubbleSort() {
		for (int i = 0; i < stock.size() - 1; i++) {
			for (int j = 0; j < stock.size() - 1 - i; j++) {
				if (stock.get(j).compareTo(stock.get(j + 1)) > 0) {
					Ingredient temp = stock.get(j);
					stock.set(j, stock.get(j + 1));
					stock.set(j + 1, temp);
				}
			}
		}
	}
	
	/**
	 * Find ingredient name at stock
	 * @param name name of ingredient
	 * @return index of the name's object at stock
	 */
	public Ingredient binarySearch(String name) {
		bubbleSort();
		int start = 0;
		int end = stock.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (name.equals(stock.get(mid).getName())) {
				return stock.get(mid);
			} else if (name.compareTo(stock.get(mid).getName()) > 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return null;
	}

	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stock.size(); i++) {
			sb.append(stock.get(i));
		}
		return sb.toString();
	}
}
