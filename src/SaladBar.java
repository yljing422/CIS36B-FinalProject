/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class SaladBar implements Catalogue {
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private static final String fileName = "ingredients.txt";
    ArrayList<BasicSalad> Salads;
    
	public void populateIngredients(Scanner input) {
		// try-catch here
	}
	
	public void printMenu() {
    	
    }
	    
	public int binarySearch(Ingredient i) {
		return 0;
	}
	
	public void bubbleSort() { 
    	for (int i = 0; i < ingredients.size() - 1; i++) {
    		for (int j = 0; j < ingredients.size() - 1 - i; j++) {
    			if (ingredients.get(j).compareTo(ingredients.get(j + 1)) > 0) {
    				Ingredient temp = ingredients.get(j);
    				ingredients.set(j, ingredients.get(j + 1));
    				ingredients.set(j + 1, temp);
    			}
    		}
    	}    
	}
    
	public int linearSearch(String type) {
		return 0;
	}
	
    public void printTypeIngredients() {
    	
    }
    
    public static void main(String[] args) {
    	SaladBar o = new SaladBar();
    	String type, name, size;
    	int number, calories;
    	double price;
    	
    	File infile = new File(fileName);
    	Scanner input = new Scanner(System.in);
    	o.populateIngredients(input);
    	
    	// Welcome and ask user choose the size
    	// if small 6.45, else large 7.65
    	// according size decide the original price
    	
    	// ask user choose chef or self
    	// if chef, ask name, name.toUpperCase()
    	// new Chef(String name, ArrayList<Ingredient> ingredients)
    	
    	// if self, ask chose 1 Organic Green, 3 Veggies, 2 Toppings, 1 Proteins, and Dressing
    	
    	System.out.print("Please choose 1 Organic Green: ");
    	
    	
    	c.add(ingredients, name);
    	
    }
}
