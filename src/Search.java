/**
* @author Wei Wang
* CIS 36B, Final Project
*/

import java.util.ArrayList;

public interface Search {

    /**
     * Reads from a file and populates the ingredients
     */
    void populateIngredients();

    /**
     * Searches for type in the ingredients
     * @param type the ingredients type
     * @return the ingredients that belongs to this type
     */
    ArrayList<Ingredient> findByType(String type); //binarySearch(Ingredient i);

    /**
     * Reduce stock number when ingredient be sold
     * @param dishIngredients the ingredient be sold
     */
    void updateStock(ArrayList<Ingredient> dishIngredients) throws Exception;
   
    /**
     * Sort stock data according name, type, calories
     */
    void bubbleSort();

    /**
     * Search certain ingredient's name in the stock
     * @param name name of ingredient
     * @return index of the name's object at stock
     */
    Ingredient binarySearch(String name);
    
}