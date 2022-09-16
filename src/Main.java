import db.Database;
import entites.Fridge;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {

        Fridge fridge = new Fridge();
        fridge.setWeightedIngredientList(Database.getIngredients());


        Scanner input = new Scanner(System.in);
        System.out.println("Enter options from menu: ");
        int option = showMenu();

        while (option != 18){

            switch (option) {

                case 1: //1. See all ingredients
                    fridge.printAllIngredients();
                    option = showMenu();
                    break;
                case 2: //Add ingredient - (provide name, weight, price)
                    System.out.println("Enter ingredient name:");
                    String ingredientName = input.nextLine();
                    double quantity = 0.0;
                    try {
                        System.out.println("Enter ingredient quantity:");
                        quantity = input.nextDouble();
                        input.nextLine();
                    } catch (NumberFormatException exception){
                        System.out.println("Please provide valid number format!\n");
                    }
                    double price = 0.0;
                    try{
                        System.out.println("Enter ingredient price:");
                        price = input.nextDouble();
                        input.nextLine();
                    } catch (NumberFormatException exception) {
                        System.out.println("Please provide valid number format!\n");
                    }
                    fridge.addIngredient(ingredientName, quantity, price);
                    option = showMenu();
                    break;
                case 3: //Delete ingredient - (provide name and weight)
                    System.out.println("Enter ingredient name:");
                    String deleteIngredientName = input.nextLine();
                    double deleteQuantity = 0.0;
                    try{
                        System.out.println("Enter ingredient quantity:");
                        deleteQuantity = input.nextDouble();
                        input.nextLine();
                    } catch (NumberFormatException exception) {
                        System.out.println("Please provide valid number format!\n");
                    }
                    fridge.removeIngredient(deleteIngredientName, deleteQuantity);
                    option = showMenu();
                    break;
                case 4: //Delete all ingredient weight - (provide name)
                    System.out.println("Enter ingredient name:");
                    String deleteAllIngredientName = input.nextLine();
                    fridge.removeAllIngredient(deleteAllIngredientName);
                    option = showMenu();
                    break;
                case 5:
                    fridge.checkWhichMealWeCanMake();
                    option = showMenu();
                    break;
                case 6:
                    System.out.println("Enter ingredient percentage:");
                    String percentage = input.nextLine();
                    fridge.checkWithMealWeCanMakeWithPercentage(percentage);
                    option = showMenu();
                    break;
                case 7:
                    System.out.println("Enter recipe name:");
                    String mealName = input.nextLine();
                    fridge.makeMeal(mealName);
                    option = showMenu();
                    break;
                case 8:
                    System.out.println("Enter price amount:");
                    try {
                        Double amount = Double.parseDouble(input.nextLine());
                        fridge.printRecipeWithMoneyLimitAndLevel(amount);
                    } catch (NumberFormatException exception){
                        System.out.println("Please provide valid number format!\n");
                    }
                    option = showMenu();
                    break;
                case 9:
                    System.out.println("Enter level for recipe - (beginner, easy, medium, hard, pro)");
                    String level = input.nextLine();
                    fridge.printRecipeWithLevelFilter(level);
                    option = showMenu();
                    break;
                case 10:
                    System.out.println("Enter level for recipe - (beginner, easy, medium, hard, pro)");
                    String levelFiler = input.nextLine();
                    System.out.println("Enter price amount:");
                    try {
                        Double amount = Double.parseDouble(input.nextLine());
                        fridge.printRecipeWithMoneyLimitAndLevel(amount,levelFiler );
                    } catch (NumberFormatException exception){
                        System.out.println("Please provide valid number format!\n");
                    }
                    option = showMenu();
                    break;
                case 11:
                    fridge.sortRecipesByPrice();
                    option = showMenu();
                    break;
                case 12:
                    fridge.sortRecipesByWeight();
                    option = showMenu();
                    break;
                case 13:
                    fridge.seeAllRecipes();
                    option = showMenu();
                    break;
                case 14:
                    fridge.lookFavoriteRecipes();
                    option = showMenu();
                    break;
                case 15:
                    System.out.println("Enter recipe name to be added to favorites:");
                    String recipeName = input.nextLine();
                    fridge.addToFavoriteRecipes(recipeName);
                    option = showMenu();
                    break;
                case 16:
                    System.out.println("Enter recipe name to be removed from favorites:");
                    String recipeToRemove = input.nextLine();
                    fridge.removeRecipeFromFavorites(recipeToRemove);
                    option = showMenu();
                    break;
                case 17:
                    try{
                        System.out.println("Enter price:");
                        Double priceForFavoriteRecipe = input.nextDouble();
                        input.nextLine();
                        fridge.checkFavoriteRecipeWithPriceFilter(priceForFavoriteRecipe);
                    } catch (NumberFormatException exception) {
                        System.out.println("Please provide valid number format!\n");
                    }
                    option = showMenu();
                    break;
                default:
                    System.out.println("Sorry, please enter valid Option");
                    showMenu();
            }// End of switch statement

        }

    }

    public static int showMenu() {

        int option = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Main Menu:");
        System.out.println("--------------");
        System.out.println("1.See all ingredients");
        System.out.println("2.Add ingredient - (provide name, weight, price)");
        System.out.println("3.Delete ingredient - (provide name and weight)");
        System.out.println("4.Delete all ingredient weight - (provide name)");
        System.out.println("5.Check which meal we can make");
        System.out.println("6.Check which meal we can make with percentage - (provide percentage)");
        System.out.println("7.Make meal (provide name)");
        System.out.println("8.Which meal we can make for provided amount?");
        System.out.println("9.Which meal we have for provided level?");
        System.out.println("10.Which meal we have for provided level and price amount?");
        System.out.println("11.Sort recipes by price desc");
        System.out.println("12.Sort recipes by weight desc");
        System.out.println("13.See all recipes");
        System.out.println("14.Look favorite recipes");
        System.out.println("15.Add recipe to favorites");
        System.out.println("16.Remove recipe from favorites");
        System.out.println("17.Which recipe is favorite for provided price?");
        System.out.println("18.Quit");
        System.out.println("--------------");
        System.out.println("Enter your choice:");
        try{
            option = keyboard.nextInt();
        }catch (InputMismatchException e){

        }
        return option;
    }
}
