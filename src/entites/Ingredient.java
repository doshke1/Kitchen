package entites;

public abstract class Ingredient implements Priceable {

    private static Integer count = 0;
    private Integer id;
    private String name;

    public Ingredient(){};

    public Ingredient(String name){
        this.name = name;
        this.id = count++;
    }


    public Integer getId() {
        return id;
    }

    public void setNextId() {
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isNull(){
        return this.id == null;
    }
}
