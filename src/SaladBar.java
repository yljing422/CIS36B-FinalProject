/**
 * @author Yunjing Mai
 * @author Jing Yang
 * @author Xinfang Zhang
 * @author Ansar Shaikh
 * @author Wei Wang
 * CIS 36B, Final Project
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class SaladBar {
	public static int count = 0;
	public static final double TAX = 0.0925;
	private Stock stock;
	private ArrayList<BasicSalad> order;
	private Scanner input = new Scanner(System.in);

	String[] INGREDIENT_TYPES = {"Greens", "Veggies", "Protein", "Topping", "Dressing"};
	int[] INGREDIENT_TYPES_QUANTITIES = {1, 2, 1, 3, 2};

	/**
	 * Display the Chef's Creation Menu
	 */
	public void printChefMenu() { // this can be moved to class ChefCreation
		System.out.println("\nHere is our Chef's Creation menu:");
		for (int i = 0; i < ChefCreation.dishesName.length; i++) {
			System.out.println((i + 1) + ". " + ChefCreation.dishesName[i]);
		}
	}

	/**
	 * Display all the ingredients in the list
	 */
	public void printIngredient(String[] ingredients) {
		System.out.println("The ingredients are: ");
		for (int i = 0; i < ingredients.length - 1; i++) {
			System.out.print(ingredients[i] + ", ");
		}
		System.out.println(ingredients[ingredients.length - 1]);
	}

	/**
	 * Ask the user for ordering a small or large salad
	 * @exception inputMismatchExceotion  if the input is a number
	 * @return the size of customer's order 
	 */
	public String askSize() {
		System.out.print("\nWhat size do you want? (1 for small, 2 for large): ");
		boolean valid = false;
		int size = 0;
		while (!valid) {
			try {
				size = input.nextInt();
				input.nextLine();
				if (size != 1 && size != 2) {
					System.out.println("please enter the valid value for the size, 1 for small or 2 for large");
					System.out.print("What size do you want? (1 for small, 2 for large): ");
					continue;
				}
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number, not a text!");
				System.out.print("What size do you want? (1 for small, 2 for large): ");
				input.nextLine();
			}
		}
		
		if (size == 1) {
			return "small";
		} else {
			return "large";
		}
	}

	/**
	 * Ask the user order chef creations or make their own salad.
	 * Check the error enter
	 * @return the choice for ordering the chef od self salad
	 */
	public String askDish() {
		String choice;
		System.out.print("\nDo you want to choose a chef or your own? (Enter 'C' for chef 'S' for self): ");
		choice = input.nextLine();
		while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("s")) {
			System.out.println("Wrong enter, please try again");
			System.out.print("\nDo you want to choose a chef or your own? (Enter 'C' for chef 'S' for self): ");
			choice = input.nextLine();
		}
		return choice;
	}

	/**
	 * Ask the user add a new ingredient or remove the exist ingredient from the salad
	 * Check the error enter
	 * @return the choice of adding or removing
	 */
	private String askAddOrRemove() {
		System.out.print("\n\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order) ");
		String choice = input.nextLine();
		while (!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("r") && !choice.equalsIgnoreCase("n")) {
			System.out.println("Wrong enter, please try again");
			System.out.print("\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order) ");
			choice = input.nextLine();
		}

		return choice;
	}
	
	/**
	 * Ask the customer for what option they want to add or remove
	 * @param limit the number of the last option which can add or remove 
	 * @exception InputMismatchException if the customer enter the right number
	 * @return the choice which would be added or removed
	 */
	private int askThingsToAddOrRemove(int limit) {
		boolean again = true;
		int choice = -1;
		while (again) {
			try {
				System.out.print("\nYour choice: ");
				choice = input.nextInt();
				input.nextLine();
				if (choice > limit || choice < 1) {
					System.out.println("It is out of the range. Please select from 1 to " + limit);
					continue;
				}
				again = false;
				return choice;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number, not a text!");
				input.nextLine();
			}
			
		}

		return choice;
	}

	/**
	 * Ask the customer for ordering another new salad 
	 * Return true for ordering a new salad, otherwise return false
	 * @return if the user continue to order a new salad
	 */
	private boolean askUserContinue() {
		System.out.print("\n\nDo you need order another one?(end with 'n') ");
		String another = input.nextLine();
		
		if (another.equalsIgnoreCase("N")) {
			return false;
		}
		return true;
	}

	/**
	 * Ask user choose one of the chef creations , 
	 * then create a arrayList of all ingredients for the specific chef salad.
	 * If the size is large , upgrade to a two=protein salad
	 * @param size the size of the salad
	 * @return ChefCreation object which is updated chef salad for the customer
	 */
	private ChefCreation processChefOrder(String size) {
		String name = null;
		boolean again = true;
		String chefOption;
		ArrayList<Ingredient> ingredients = null;

		printChefMenu();
		while (again) {
			System.out.print("\nPlease choose one Chef's Salad from 1-" + ChefCreation.dishesName.length + ": ");
			chefOption = input.nextLine();

			switch (chefOption) {
				case "1":
					name = "Chicken Ceaser";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.chickenCaesar);
					ingredients = stock.createDish(ChefCreation.chickenCaesar);
					again = false;
					break;
				case "2":
					name = "Southwestern Chicken";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.southwesternChicken);
					ingredients = stock.createDish(ChefCreation.southwesternChicken);
					again = false;
					break;
				case "3":
					name = "Spinach Bacon";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.spinachBacon);
					ingredients = stock.createDish(ChefCreation.spinachBacon);
					again = false;
					break;
				case "4":
					name = "Spring Green Salad";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.springGreenSalad);
					ingredients = stock.createDish(ChefCreation.springGreenSalad);
					again = false;
					break;
				case "5":
					name = "Mediterranean Pasta";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.mediterraneanPasta);
					ingredients = stock.createDish(ChefCreation.mediterraneanPasta);
					again = false;
					break;
				case "6":
					name = "Chinese Chicken";
					System.out.println("\nYou choose: " + name);
					printIngredient(ChefCreation.chineseChicken);
					ingredients = stock.createDish(ChefCreation.chineseChicken);
					again = false;
					break;
				default:
					name = "";
					System.out.println("Please enter a number between 1 to " + ChefCreation.dishesName.length + "!");
					again = true;
					break;
			}
		}

		ChefCreation chef = new ChefCreation(name, size);
		if (size.equalsIgnoreCase("L")) {
			chef.increaseProteinSize();
		}
		chef.setDishIngredient(ingredients);
		System.out.println("\nYour chef order: " + chef.getName() + " ");
		System.out.printf("Current price right now is: %.2f", chef.getPrice());
		
		return chef;
	}

	/**
	 * Ask customer for choosing the limited ingredients for every specific type
	 * If the number of the some ingredient is zero, inform the user that it's out of stock
	 * @param size the size of the salad 
	 * @return selfCreation which is the updated self-made for the customer
	 */
	private SelfCreation processSelfOrder(String size) {
		SelfCreation self = new SelfCreation(size);
		ArrayList<Ingredient> stockIngredientByType = new ArrayList<>();

		for (int i = 0; i < INGREDIENT_TYPES.length; i++) {
			int quantities = 0;
			System.out.println("\n" + INGREDIENT_TYPES[i]);
			if (INGREDIENT_TYPES[i].equalsIgnoreCase("protein") && size.equalsIgnoreCase("large")) {
				quantities = INGREDIENT_TYPES_QUANTITIES[i] + 1;
			} else {
				quantities = INGREDIENT_TYPES_QUANTITIES[i];
			}
			System.out.println("Please select " + quantities + " " + INGREDIENT_TYPES[i]);
			stockIngredientByType = stock.findByType(INGREDIENT_TYPES[i]);
			printIngredient(stockIngredientByType);
			for (int j = 0; j < quantities; j++) {
				int choice = askThingsToAddOrRemove(stockIngredientByType.size());
				Ingredient addIngredient = stockIngredientByType.get(choice - 1);
				if (self.findIngredientNumber(addIngredient.getName()) < addIngredient.getNumber()) {
					self.add(stockIngredientByType.get(choice - 1));
					System.out.println("you have selected " + stockIngredientByType.get(choice - 1).getName());
					System.out.println("you have " + (quantities - j - 1) + " " + INGREDIENT_TYPES[i] + " to Select");
				} else {
					j--;
					System.out.println("This ingredient " + addIngredient.getName() + " doesn't have enough stock");
					System.out.println("Please re-select from the list");
				}
			}
		}
		self.setPrice(size);
		System.out.printf("Your self selection salad current price is  %.2f", self.getPrice());
		return self;
	}

	/**
	 * Display all the ingredients of a specific type 
	 * @param ingredientsByType
	 */
	private void printIngredient(ArrayList<Ingredient> ingredientsByType) {
		System.out.println("\nThe available ingredients are: ");
		for (int i = 0; i < ingredientsByType.size(); i++) {
			System.out.println(i + 1 + ". " + ingredientsByType.get(i).getName());
		}
	}

	/**
	 * According to the user's option, to edit salad.
	 * If choice is "n" , then stop the edition of the salad
	 * It choice is "a" , ask user what type of ingredients they want to add and
	 * add the specific ingredient.
	 * Otherwise, ask user for what specific ingredient they want to remove 
	 * from the ordered salad
	 * @param salad the ordered salad
	 * @param choiceOption the choice for adding or removing or no editing 
	 */
	private void processAddOrRemove(BasicSalad salad, String choiceOption) {
		if (choiceOption.equalsIgnoreCase("n")) {
			return;
		}
		if (choiceOption.equalsIgnoreCase("a")) {
			System.out.println("1. Greens\n2. Veggies\n3. Protein\n4. Topping\n5. Dressing");
			System.out.print("What type of ingredient do you want to add? ");
			int typeIndex = askThingsToAddOrRemove(5);
			ArrayList<Ingredient> stockIngredientByType = stock.findByType(INGREDIENT_TYPES[typeIndex - 1]);
			printIngredient(stockIngredientByType);
			int ingredientIndex = askThingsToAddOrRemove(stockIngredientByType.size());
			Ingredient currentIngredient = stockIngredientByType.get(ingredientIndex - 1);
			if(salad.findIngredientNumber(currentIngredient.getName()) < currentIngredient.getNumber()) {
				salad.add(currentIngredient);
				System.out.println("\nYou added: \nType: " + currentIngredient.getType() + "\nName: " + currentIngredient.getName());
				System.out.printf("Current price right now is: %.2f", salad.getPrice());
			} else {
				System.out.println("Sorry" + currentIngredient.getName() + " doesn't have enough stock");
			}
		} else {
			System.out.println("Please remove things that in the list");
			printIngredient(salad.getDishIngredient());
			int ingredientIndex = askThingsToAddOrRemove(salad.dishIngredient.size());
			Ingredient removedIngredient = salad.getDishIngredient().get(ingredientIndex - 1);
			salad.remove(removedIngredient);
			System.out.println("\nYou have removed: \nType: " + removedIngredient.getType() + "\nName: " + removedIngredient.getName());
			System.out.printf("Current price right now is: %.2f", salad.getPrice());
		}
	}
	
	/**
	 * Count the total amount of salads
	 * @return the number of the salads
	 */
	public static int countDishes() {
		count++;
		return count;
	}

	public static void main(String[] args) throws IOException{
		SaladBar s = new SaladBar();
		s.stock = new Stock();
		s.order = new ArrayList<>();
		File outfile = new File("receipt.txt");
		PrintWriter out = new PrintWriter(outfile);

		System.out.println("Welcome to Salad Daze! ");
		BasicSalad salad;
		boolean isContinueOrder = true;
		while (isContinueOrder) {
			//create different type of Salad Object
			String dishType = s.askDish();
			String size = s.askSize();
			if (dishType.equalsIgnoreCase("c")) {
				salad = s.processChefOrder(size);
			} else {
				salad = s.processSelfOrder(size);
			}
			//add or remove ingredient
			String choiceOption = s.askAddOrRemove();
			while (!choiceOption.equalsIgnoreCase("n")) {
				s.processAddOrRemove(salad, choiceOption);
				choiceOption = s.askAddOrRemove();
			}
			// add dish to order
			s.order.add(salad);
			countDishes();

			try {
				s.stock.updateStock(salad.getDishIngredient());
			} catch (Exception e) {
				System.out.println("Sorry, your select is our of stock");
			}

			isContinueOrder = s.askUserContinue();
		}
		
		// print receipt
		double subtotal = 0;
		double tax;
		double total;
		System.out.println("\n\n#############################################");
		System.out.println("Receipt:");
		out.println("Receipt:");
		
		if (count > 1) { 
			System.out.println("You ordered " + count + " salads.");
			out.println("You ordered " + count + " salads.");
		} else {
			System.out.println("You ordered " + count + " salad.");
			out.println("You ordered " + count + " salad.");
		}
		
		for (int i = 0; i < s.order.size(); i++) {
			System.out.print("\n" + (i + 1) + ": ");
			out.print("\n" + (i + 1) + ": ");
			System.out.println(s.order.get(i));
			out.println(s.order.get(i));
			subtotal += s.order.get(i).getPrice();
		}

		System.out.printf("\n\nSubtotal Price: %.2f", subtotal);
		out.printf("\n\nSubtotal Price: %.2f", subtotal);
		
		tax = subtotal * TAX;
		System.out.printf("\nSale Tax: %.2f", tax);
		out.printf("\nSale Tax: %.2f", tax);
		
		total = subtotal + tax;
		System.out.printf("\nOrder Total: %.2f", total);
		out.printf("\nOrder Total: %.2f", total);
		out.close();
	}
}
