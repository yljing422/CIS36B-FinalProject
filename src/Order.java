/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Order implements Catalogue {
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private static final String fileName = "ingredients.txt";
    
	public void populateIngredients(Scanner input) {
		// try-catch here
	}
	
	public boolean binarySearch(Ingredient i) {
		return false;
	}
	
    public void printMenu() {
    	
    }
    
    public void printIngredients() {
    	
    }
    
    public static void main(String[] args) {
    	Order o = new Order();
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
    	// if chef, ask name, new Chef(String name)
    	//
    }
}
