package entites;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Priceable, Weightable {
    private String name;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeLevel recipeLevel;
    private boolean isFavorite;

    public Recipe(){};

    public Recipe(String name, List<RecipeIngredient> recipeIngredients, RecipeLevel recipeLevel, boolean isFavorite) {
        this.name = name;
        this.recipeIngredients = recipeIngredients;
        this.recipeLevel = recipeLevel;
        this.isFavorite = isFavorite;
    }

    @Override
    public Double getPrice(){
        Double price = 0.0;
        for (RecipeIngredient recipeIngredient : recipeIngredients)
            price += recipeIngredient.getWeightedIngredient().getPrice();

        return price;
    }

    @Override
    public Double getTotalWeight(){
        Double weight = 0.0;
        for (RecipeIngredient recipeIngredient : recipeIngredients)
            weight += recipeIngredient.getWeightedIngredient().getWeight();

        return weight;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeLevel getRecipeLevel() {
        return recipeLevel;
    }

    public void setRecipeLevel(RecipeLevel recipeLevel) {
        this.recipeLevel = recipeLevel;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

//    public void deleteIngredient(String name) {
//        recipeIngredients.remove(name);
//    }

//    public void addIngredient(RecipeIngredient ingredient) {
//        recipeIngredients.add(ingredient);
//    }

//    public Recipe newRecipe(Double percent, Recipe recipe) {
//        Recipe newRecipe = new Recipe();
//        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
//        newRecipe.setName(recipe.getName());
//        newRecipe.setRecipeLevel(recipe.getRecipeLevel());
//        for (RecipeIngredient ingredient : recipe.getRecipeIngredients()) {
//            RecipeIngredient recipeIngredient = new RecipeIngredient();
//            Double quantityInRecipe = ingredient.getQuantityInRecipe() * percent / 100;
//            recipeIngredient.setQuantityInRecipe(quantityInRecipe);
//            recipeIngredient.setWeightedIngredient(ingredient.getWeightedIngredient());
//            recipeIngredientList.add(recipeIngredient);
//        }
//
//        return newRecipe;
//    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", recipeLevel=" + recipeLevel +
                ", isFavorite=" + isFavorite +
                '}';
    }

    public boolean isNull(){
        return this.name == null;

    }

}



