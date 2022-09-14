package entites;

public class WeightedIngredient extends Ingredient {
    private Double weight;
    private Double pricePerUnit;

    public WeightedIngredient() {
        super();
    }

    public WeightedIngredient(String name, Double weight, Double pricePerUnit){
        super(name);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public Double getPrice(){
        return this.weight * this.pricePerUnit;
    }

    public Double getWeight(){
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "WeightedIngredient{" +
                "ID = " + super.getId() +
                ", name = " + super.getName() +
                ", weight = " + weight +
                ", pricePerUnit = " + pricePerUnit +
                '}';
    }


}
