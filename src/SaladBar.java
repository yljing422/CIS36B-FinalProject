
/**
 * @author Yunjing Mai
 * @author Jing Yang
 * @author Xinfang Zhang
 * @author Ansar Shaikh
 * @author Wei Wang
 * CIS 36B, Final Project
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SaladBar {

	/**
	 * Display the Chef's Creation Menu
	 */
	public void printMenu() { // this can be moved to class ChefCreation
		System.out.println("\nHere is our Chef's Creation menu:");
		for (int i = 0; i < ChefCreation.dishesName.length; i++) {
			System.out.println((i + 1) + ". " + ChefCreation.dishesName[i]);
		}
	}

	public void printIngredient(String[] ingredients) {
		System.out.println("The ingredients are: ");
		for (int i = 0; i < ingredients.length - 1; i++) {
			System.out.print(ingredients[i] + ", ");
		}
		System.out.println(ingredients[ingredients.length - 1]);
	}

	public String askSize(Scanner input) {
		System.out.print("\nWhat size do you want? (1 for small, 2 for large): ");
		int size = input.nextInt();
		while (size != 1 && size != 2) {
			System.out.println("Wrong enter, please try again.");
			System.out.print("What size do you want? (1 for small, 2 for large): ");
			size = input.nextInt();
		}

		if (size == 1) {
			return "small";
		} else {
			return "large";
		}
	}

	public static void main(String[] args) {
		ArrayList<BasicSalad> salads = new ArrayList<BasicSalad>();
		SaladBar order = new SaladBar();

		Stock stock = new Stock();
		ArrayList<String> greens = stock.findByType("Greens");
		ArrayList<String> veggies = stock.findByType("Veggies");
		ArrayList<String> protein = stock.findByType("Protein");
		ArrayList<String> topping = stock.findByType("Topping");
		ArrayList<String> dressing = stock.findByType("Dressing");

		String choice;
		String chefOption = "";
		int Remove = 0; ///
		int selfOption = 0;
		String name = "", size, another;
		double totalPrice = 0.0;
		boolean again;

		ArrayList<Ingredient> ingredient = null;

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Salad Daze! ");
		do {
			System.out.print("\nDo you want to choose a chef or your own? (Enter 'C' for chef 'S' for self): ");
			choice = input.nextLine();
			while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("s")) {
				System.out.println("Wrong enter, please try again");
				System.out.print("\nDo you want to choose a chef or your own? (Enter 'C' for chef 'S' for self): ");
				choice = input.nextLine();
			}
			if (choice.equalsIgnoreCase("c")) {
				order.printMenu();

				again = true;
				while (again) {
					System.out
							.print("\nPlease choose one Chef's Salad from 1-" + ChefCreation.dishesName.length + ": ");
					chefOption = input.next();

					switch (chefOption) {
					case "1":
						name = "Chicken Ceaser";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.chickenCaesar);
						ingredient = stock.createDish(ChefCreation.chickenCaesar);
						again = false;
						break;
					case "2":
						name = "Southwestern Chicken";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.southwesternChicken);
						ingredient = stock.createDish(ChefCreation.southwesternChicken);
						again = false;
						break;
					case "3":
						name = "Spinach Bacon";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.spinachBacon);
						ingredient = stock.createDish(ChefCreation.spinachBacon);
						again = false;
						break;
					case "4":
						name = "Spring Green Salad";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.springGreenSalad);
						ingredient = stock.createDish(ChefCreation.springGreenSalad);
						again = false;
						break;
					case "5":
						name = "Mediterranean Pasta";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.mediterraneanPasta);
						ingredient = stock.createDish(ChefCreation.mediterraneanPasta);
						again = false;
						break;
					case "6":
						name = "Chinese Chicken";
						System.out.println("\nYou choose: " + name);
						order.printIngredient(ChefCreation.chineseChicken);
						ingredient = stock.createDish(ChefCreation.chineseChicken);
						again = false;
						break;
					default:
						name = "";
						System.out.println(
								"\nPlease enter a number between 1 to " + ChefCreation.dishesName.length + "!");
						again = true;
						break;
					}
				}

				size = order.askSize(input);
				ChefCreation c = new ChefCreation(name, size);
				c.setIngredient(ingredient);
				// salads.add(c);
				input.nextLine();

				System.out.print(
						"\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order) ");
				chefOption = input.nextLine();
				while (!chefOption.equalsIgnoreCase("n")) {
					if (chefOption.equalsIgnoreCase("A")) {
						int addType;
						int addNumOfName;
						String addName = "";

						System.out.println("1. Greens\n2. Veggies\n3. Protein\n4. Topping\n5. Dressing");
						System.out.print("\nWhat type of ingredient do you want to add? ");
						addType = input.nextInt();

						switch (addType) {
						case 1:
							stock.printByType(greens);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = greens.get(addNumOfName - 1);
							break;
						case 2:
							stock.printByType(veggies);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = veggies.get(addNumOfName - 1);
							break;
						case 3:
							stock.printByType(protein);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = protein.get(addNumOfName - 1);
							break;
						case 4:
							stock.printByType(topping);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = topping.get(addNumOfName - 1);
							break;
						case 5:
							stock.printByType(dressing);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = dressing.get(addNumOfName - 1);
							break;
						}
						input.nextLine();
						c.addPrice();
						c.add(stock.add(addName));

					} else if (chefOption.equalsIgnoreCase("R")) {
						ArrayList<Ingredient> chef = c.getIngredient();
						System.out.println("What ingredient you want remove? (Enter 1 from " + chef.size() + ")");
						for (int i = 0; i < chef.size(); i++) {
							System.out.println(i + 1 + ". " + chef.get(i).getName());
						}
						Remove = input.nextInt();
						c.removePrice();
						c.remove(chef.get(Remove - 1).getName());
					} else {
						System.out.println("Wrong enter, please try again.");
					}
					System.out.print(
							"\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order) ");
					input.nextLine();
					chefOption = input.nextLine();

				}
				salads.add(c);

			} else {
				ArrayList<String> selfIn = new ArrayList<>();
				size = order.askSize(input);
				SelfCreation s = new SelfCreation(size);

				again = true;
				while (again) {
					try {
						System.out.println("\nPlease select 1 Green:");
						stock.printByType(greens);
						System.out.print("\nPlease select by number 1 - " + greens.size() + ": ");
						selfOption = input.nextInt();
						selfIn.add(greens.get(selfOption - 1));
						again = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Wrong number, please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number, not a text!");
						input.nextLine();
					}
				}

				again = true;
				while (again) {
					try {
						System.out.println("\nPlease select 2 Veggies:");
						stock.printByType(veggies);
						System.out.print(
								"\nPlease select by number 1 - " + veggies.size() + "(connect with a black space): ");
						selfOption = input.nextInt();
						selfIn.add(veggies.get(selfOption - 1));
						selfOption = input.nextInt();
						selfIn.add(veggies.get(selfOption - 1));
						again = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Wrong number, please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number, not a text!");
						input.nextLine();
					}
				}

				again = true;
				while (again) {
					try {
						if (s.getSize().equals("small")) {
							System.out.println("\nPlease select 1 Protein:");
						}
						if (s.getSize().equals("large")) {
							System.out.println("\nPlease select 2 Protein:");
						}
						stock.printByType(protein);
						System.out.print("\nPlease select by number 1 - " + protein.size() + ": ");
						selfOption = input.nextInt();
						selfIn.add(protein.get(selfOption - 1));
						if (s.getSize().equals("large")) {
							selfOption = input.nextInt();
							selfIn.add(protein.get(selfOption - 1));
						}
						again = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Wrong number, please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number, not a text!");
						input.nextLine();
					}
				}

				again = true;
				while (again) {
					try {
						System.out.println("\nPlease select 3 Topping:");
						stock.printByType(topping);
						System.out.print(
								"\nPlease select by number 1 - " + topping.size() + "(connect with a black space): ");
						selfOption = input.nextInt();
						selfIn.add(topping.get(selfOption - 1));
						selfOption = input.nextInt();
						selfIn.add(topping.get(selfOption - 1));
						selfOption = input.nextInt();
						selfIn.add(topping.get(selfOption - 1));
						again = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Wrong number, please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number, not a text!");
						input.nextLine();
					}
				}

				again = true;
				while (again) {
					try {
						System.out.println("\nPlease select 2 Dressing:");
						stock.printByType(dressing);
						System.out.print(
								"\nPlease select by number 1 - " + dressing.size() + "(connect with a black space): ");
						// while (input.hasNextInt()) {
						selfOption = input.nextInt();
						selfIn.add(dressing.get(selfOption - 1));
						selfOption = input.nextInt();

						selfIn.add(dressing.get(selfOption - 1));
						// }
						again = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Wrong number, please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Please enter a number, not a text!");
						input.nextLine();
					}
				}

				ingredient = stock.createDish(selfIn);
				s.setIngredient(ingredient);
				salads.add(s);
				input.nextLine();

				System.out.print(
						"\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order)");
				chefOption = input.nextLine();
				while (!chefOption.equalsIgnoreCase("n")) {
					if (chefOption.equalsIgnoreCase("A")) {
						int addType;
						int addNumOfName;
						String addName = "";
						System.out.println("1. Greens\n2. Veggies\n3. Protein\n4. Topping\n5. Dressing");
						System.out.print("\nWhat type of ingredient do you want to add? ");
						addType = input.nextInt();

						switch (addType) {
						case 1:
							stock.printByType(greens);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = greens.get(addNumOfName - 1);
							break;
						case 2:
							stock.printByType(veggies);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = veggies.get(addNumOfName - 1);
							break;
						case 3:
							stock.printByType(protein);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = protein.get(addNumOfName - 1);
							break;
						case 4:
							stock.printByType(topping);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = topping.get(addNumOfName - 1);
							break;
						case 5:
							stock.printByType(dressing);
							System.out.print("Please enter the number you need add. ");
							addNumOfName = input.nextInt();
							addName = dressing.get(addNumOfName - 1);
							break;
						}
						input.nextLine();
						s.add(stock.add(addName));

					} else if (chefOption.equalsIgnoreCase("R")) {
						ArrayList<Ingredient> self = s.getIngredient();
						System.out.println("What ingredient you want remove? (Enter 1 from " + self.size() + ")");
						for (int i = 0; i < self.size(); i++) {
							System.out.println(i + 1 + ". " + self.get(i).getName());
						}
						Remove = input.nextInt();
						s.removePrice();
						s.remove(self.get(Remove - 1).getName());
					} else {
						System.out.println("Wrong enter, please try again.");
					}
					System.out.print(
							"\nDo you want to add or remove something?('A' for add, 'R' for remove, 'N' for place order) ");
					input.nextLine();
					chefOption = input.nextLine();
				}
			}

			System.out.print("\n\nDo you need order another one?(end with 'n') ");
			another = input.nextLine();
		} while (!another.equalsIgnoreCase("n"));

		for (int i = 0; i < salads.size(); i++) {
			System.out.println(salads.get(i));
			totalPrice += salads.get(i).getPrice();
		}

		System.out.printf("\nTotal price: %.2f", totalPrice);
	}
}
