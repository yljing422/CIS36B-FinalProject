import java.util.ArrayList;

public class Stock {
	ArrayList<Ingredient> stock;
	
	public Stock() {
		stock = new ArrayList<>();
		//read from file
	}
	
	public Ingredient findIngredient(String name) {
		//can replace use binary search if sorted;
		for (int i = 0; i < stock.size(); i++) {
			if (stock.get(i).getName().equals(name) && stock.get(i).getNumber() > 0) {
				Ingredient ing = new Ingredient(stock.get(i));
				ing.setNumber(1);
				return ing;
			}
		}
		return null;
	}
	
	private void sortIngredient() {
		//bubble sort goes here;
	}
	
}
