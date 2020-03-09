/**
* @author 
* @author 
* CIS 36B, Final Project
*/

import java.io.IOException;
import java.util.Scanner;

public interface Catalogue {
    /**
     * Reads from a file and populates the catalogue
     * @param input the Scanner used to read in the data
     */
    void populateIngredients(Scanner input) throws IOException;
   
    /**
     * Searches for b in the catalogue
     * @param b the Book to locate
     * @return the location of b in
     * the catalogue
     */
    int binarySearch(Ingredient i);
   
    /**
     * Sorts the catalogue into
     * ascending order
     */
    void bubbleSort();
   
    /**
     * Prints a menu of options to interact
     * with the catalogue
     */
    void printMenu();
   
    /**
     * Prints out the current catalogue
     */
    void printIngredients();
}