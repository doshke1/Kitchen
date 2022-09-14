package entites;

public enum RecipeLevel {

    BEGINNER("beginner"),
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    PRO("pro");


    RecipeLevel(String value){
        this.value = value;
    }

    private final String value;
    public String getValue(){
        return this.value;
    }

}
