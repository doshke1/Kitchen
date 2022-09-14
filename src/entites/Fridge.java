package entites;

import db.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fridge {

    List<WeightedIngredient> weightedIngredientList = Database.getIngredients();

    public List<WeightedIngredient> getWeightedIngredientList() {
        return Database.getIngredients();
    }

    public void setWeightedIngredientList(List<WeightedIngredient> weightedIngredientList) {
        this.weightedIngredientList = weightedIngredientList;
    }

    public void printAllIngredients() {
        for (WeightedIngredient ingredient : getWeightedIngredientList()) {
            System.out.println(ingredient);
        }
    }

    public void addIngredient(String name, Double weight, Double price){
        WeightedIngredient weightedIngredient = getIngredientByName(name);
        if(weightedIngredient.isNull()){
            WeightedIngredient newIngredient = new WeightedIngredient();
            newIngredient.setNextId();
            newIngredient.setName(name);
            newIngredient.setWeight(weight);
            newIngredient.setPricePerUnit(price);
            Database.getIngredients().add(newIngredient);
        } else {
            weightedIngredient.setWeight(weightedIngredient.getWeight() + weight);
        }
        System.out.println(Database.getIngredients());
    }

    public void removeIngredient(String name, Double weightToRemove)  {
        WeightedIngredient ingredient = getIngredientByName(name);
        if(ingredient.isNull()){
            System.out.printf("This ingredient (%s) is not in Database\n",name);
            return;
        }

        if (ingredient.getWeight() >= weightToRemove) {
            ingredient.setWeight(ingredient.getWeight() - weightToRemove);
        } else {
            ingredient.setWeight(0.0);
        }
        System.out.println(ingredient);
    }

    public void removeAllIngredient(String deleteAllIngredientName){
        WeightedIngredient ingredient = getIngredientByName(deleteAllIngredientName);
        if(ingredient.isNull()){
            System.out.printf("This ingredient (%s) is not in Database\n",deleteAllIngredientName);
            return;
        }
        weightedIngredientList.remove(ingredient);
        System.out.printf("Ingredient %s is deleted!\n", deleteAllIngredientName);
    }

    public void checkWhichMealWeCanMake()  {
        for (Recipe recipe : Database.getRecipes())
            checkIngredientsInRecipe(recipe.getName());
    }

    private void checkIngredientsInRecipe(String recipeName) {
        Recipe recipe = getRecipeByName(recipeName);
        if(recipe.isNull()){
            System.out.printf("This recipe (%s) is not in Database!\n",recipeName);
            return;
        }

        boolean isOk = true;
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            if (!weightedIngredientList.contains(recipeIngredient.getWeightedIngredient())) {
                System.out.printf("This recipeIngredient (%s) is not in fridge!\n", recipeIngredient.getWeightedIngredient().getName());
                isOk = false;
                break;
            }

            if (recipeIngredient.getQuantityInRecipe() > recipeIngredient.getWeightedIngredient().getWeight()) {
                System.out.printf("There is not enough ingredient (%s) quantity to make this recipe (%s)!\n"
                        ,recipeIngredient.getWeightedIngredient().getName(), recipe.getName());
                isOk = false;
                break;
            }
        }

        if (isOk) {
            System.out.printf("We have enough ingredients in fridge for %s.\n\n", recipeName);
        }
    }

    public void checkWithMealWeCanMakeWithPercentage(String percentage) {
        for (Recipe recipe : Database.getRecipes())
            checkIngredientsInRecipeWithPercentage(recipe.getName(), percentage);
    }

    private void checkIngredientsInRecipeWithPercentage(String recipeName, String percentage) {
        Recipe recipe = getRecipeByName(recipeName);
        if(recipe.isNull()){
            System.out.printf("This recipe (%s) is not in Database!\n",recipeName);
            return;
        }

        Double doublePercentage = Double.parseDouble(percentage.replace("%", "")) / 100;
        boolean isOk = true;
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            if (!weightedIngredientList.contains(recipeIngredient.getWeightedIngredient())) {
                System.out.printf("This recipeIngredient (%s) is not in fridge!\n", recipeIngredient.getWeightedIngredient().getName());
                isOk = false;
                break;
            }

            if (recipeIngredient.getQuantityInRecipe() * doublePercentage > recipeIngredient.getWeightedIngredient().getWeight()) {
                System.out.printf("There is not enough ingredient (%s) quantity!\n", recipeIngredient.getWeightedIngredient().getName());
                isOk = false;
                break;
            }
        }

        if (isOk) {
            System.out.printf("We have enough ingredients in fridge for %s.\n\n", recipeName);
        }
    }

    public void makeMeal(String recipeName)  {
        checkIngredientsInRecipe(recipeName);

        Recipe recipe = getRecipeByName(recipeName);
        if(recipe.isNull()){
            System.out.printf("This recipe (%s) is not in Database!\n",recipeName);
            return;
        }

        for (RecipeIngredient ingredient : recipe.getRecipeIngredients()) {
            removeIngredient(ingredient.getWeightedIngredient().getName(), ingredient.getQuantityInRecipe());
        }
        System.out.printf("Meal (%s) is ready!!!\n", recipeName);
    }

    public void printRecipeWithLevelFilter(String level) {
        System.out.printf("With %s weight we have these recipes: \n", level);
        for (Recipe recipe : Database.getRecipes()) {
            if (recipe.getRecipeLevel().getValue().equalsIgnoreCase(level)) {
                System.out.println(recipe);
            }
        }
    }

    public void printRecipeWithMoneyLimitAndLevel(Double amount) {
        System.out.printf("With %.2f money we can make these recipes: \n", amount);
        for (Recipe recipe : Database.getRecipes()) {
            if (getTotalRecipePrice(recipe) <= amount) {
                System.out.println(recipe);
            }
        }
    }

    public void printRecipeWithMoneyLimitAndLevel(Double amount, String levelFiler) {
        System.out.printf("With %.2f money and %s level we can make these recipes: \n", amount,levelFiler);
        for (Recipe recipe : Database.getRecipes()) {
            if (recipe.getRecipeLevel().getValue().equalsIgnoreCase(levelFiler) && getTotalRecipePrice(recipe) <= amount) {
                System.out.println(recipe);
            }
        }
    }

    public void sortRecipesByPrice() {
        List<Recipe> sortedListDesc = Database.getRecipes();
        Collections.sort(sortedListDesc, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return (o2.getPrice()).compareTo(o1.getPrice());
            }
        });

        for (Recipe recipe : sortedListDesc)
            System.out.println(recipe);

    }

    public void sortRecipesByWeight() {
        List<Recipe> sortedListDesc = Database.getRecipes();
        Collections.sort(sortedListDesc, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return (o2.getTotalWeight()).compareTo(o1.getTotalWeight());
            }
        });
        for (Recipe recipe : sortedListDesc)
            System.out.println(recipe);
    }

    public void seeAllRecipes() {
        for (Recipe recipe : Database.getRecipes()) {
            System.out.println(recipe);
        }
    }

    public void lookFavoriteRecipes() {
        List<Recipe> favoriteRecipes = new ArrayList<>();

        for (Recipe recipe : Database.getRecipes()) {
            if(recipe.isFavorite()){
                favoriteRecipes.add(recipe);
            }
        }

        if(favoriteRecipes.size() > 0){
            System.out.println(favoriteRecipes);
        }
        else {
            System.out.println("There is no favorite recipe!");
        }

    }

    public void addToFavoriteRecipes(String recipeName) {
        Recipe recipe = getRecipeByName(recipeName);
        if(recipe.isNull()){
            System.out.printf("This recipe (%s) is not in Database!\n", recipeName);
            return;
        }

        if(recipe.isFavorite()){
            System.out.printf("This recipe (%s) is already one of favorites!\n",recipeName);
        } else {
            recipe.setFavorite(true);
            System.out.printf("Recipe (%s) add to favorites!\n",recipeName);
        }
    }


    public void removeRecipeFromFavorites(String recipeToRemove) {
        Recipe recipe = getRecipeByName(recipeToRemove);
        if(recipe.isNull()){
            System.out.printf("This recipe (%s) is not in Database!\n", recipeToRemove);
            return;
        }

        if(recipe.isFavorite()){
            recipe.setFavorite(false);
            System.out.printf("Recipe (%s) removed from favorites!\n",recipeToRemove);
        } else {
            System.out.printf("Recipe isn't favorite!\n",recipeToRemove);
        }
    }

    public void checkFavoriteRecipeWithPriceFilter(Double priceForFavoriteRecipe) {
        List<Recipe> favoriteRecipes = new ArrayList<>();

        for (Recipe recipe : Database.getRecipes()) {
            if(recipe.isFavorite() && priceForFavoriteRecipe >= recipe.getPrice()){
                favoriteRecipes.add(recipe);
            }
        }

        if(favoriteRecipes.size() > 0){
            System.out.println(favoriteRecipes);
        }
        else {
            System.out.printf("There is no favorite recipe for this price (%.2f)!\n",priceForFavoriteRecipe);
        }
    }

    private Double getTotalRecipePrice(Recipe recipe) {
        Double totalPrice = 0.0;
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients())
            totalPrice += recipeIngredient.getWeightedIngredient().getPrice();
        return totalPrice;
    }

    private WeightedIngredient getIngredientByName(String name){
        for (WeightedIngredient ingredient : weightedIngredientList) {
            if (ingredient.getName().equalsIgnoreCase(name))
                return ingredient;
        }
        return new WeightedIngredient();
    }

    private Recipe getRecipeByName(String recipeName) {
        for (Recipe recipe : Database.getRecipes()) {
            if (recipe.getName().equalsIgnoreCase(recipeName))
                return recipe;
        }
        return new Recipe();
    }

}
