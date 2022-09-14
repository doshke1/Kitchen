package entites;

public class RecipeIngredient {
    private Double quantityInRecipe;
    private WeightedIngredient weightedIngredient;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Double quantityInRecipe, WeightedIngredient weightedIngredient) {
        this.quantityInRecipe = quantityInRecipe;
        this.weightedIngredient = weightedIngredient;
    }

    public Double getQuantityInRecipe() {
        return quantityInRecipe;
    }

    public void setQuantityInRecipe(Double quantityInRecipe) {
        this.quantityInRecipe = quantityInRecipe;
    }

    public WeightedIngredient getWeightedIngredient() {
        return weightedIngredient;
    }

    public void setWeightedIngredient(WeightedIngredient weightedIngredient) {
        this.weightedIngredient = weightedIngredient;
    }
}
