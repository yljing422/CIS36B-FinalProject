/**
* @author Jing Yang
* CIS 36B, Final Project
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Stock {
	ArrayList<Ingredient> stock;
    private static final String fileName = "ingredients.txt";
	
    // Constructor
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
	private void populateIngredients() {
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
	public ArrayList<String> findByType(String type) {
		ArrayList<String> ingredientByType = new ArrayList<>();
		for (int i = 0; i < stock.size(); i++) {
			if (stock.get(i).getType().equals(type)) {
				ingredientByType.add(stock.get(i).getName());
			}
		}
		return ingredientByType;
	}
	
	/**
	 * Print the ingredient name of same type
	 * @param type type of ingredient
	 */
	public void printByType(ArrayList<String> ingredientByType) {
		for (int j = 0; j < ingredientByType.size(); j++) {
			System.out.println((j + 1) + ". " + ingredientByType.get(j));
		}
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
						throw new NoSuchElementException("Sorry, not able to create dish, because" + stock.get(j).getName() + " is out of stock");
					}
					temp = new Ingredient(stock.get(j));
					result.add(temp);
					updateStock(stock.get(j));
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Collect all of the self creation ingredient after finish select
	 * @param name ingredients are ordered
	 * @return list of all ingredient object
	 */
	public ArrayList<Ingredient> createDish(ArrayList<String> name) throws NoSuchElementException {
		Ingredient temp;
		ArrayList<Ingredient> result = new ArrayList<>();
		for (int i = 0; i < name.size(); i++) {
			for (int j = 0; j < stock.size(); j++) {
				if (stock.get(j).getName().equalsIgnoreCase(name.get(i))) {
					if (stock.get(j).getNumber() <= 0){
						throw new NoSuchElementException("Sorry, not able to create dish, because" + stock.get(j).getName() + " is out of stock");
					}
					temp = new Ingredient(stock.get(j));
					result.add(temp);
					updateStock(stock.get(j));
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Reduce stock number when ingredient be sold
	 * @param in the ingredient be sold
	 */
	private void updateStock(Ingredient in) {
		in.setNumber(in.getNumber() - 1);;
	}
	
	/**
	 * Add extra ingredient
	 * @param name the ingredient name need added
	 * @return the ingredient's object
	 */
	public Ingredient add(String name) throws NoSuchElementException {
		int idx = binarySearch(name);
		if (stock.get(idx).getNumber() > 0) {
			updateStock(stock.get(idx));
			return stock.get(idx);
		} else {
			throw new NoSuchElementException("Sorry, " + name + " is out of stock"); // catch Exception at main
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
	public int binarySearch(String name) {
		int start = 0;
		int end = stock.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (name.equals(stock.get(mid).getName())) {
				return mid;
			} else if (name.compareTo(stock.get(mid).getName()) > 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stock.size(); i++) {
			sb.append(stock.get(i));
		}
		return sb.toString();
	}
}
