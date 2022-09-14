package db;

import entites.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

      private static List<WeightedIngredient> ingredients = new ArrayList(
              Arrays.asList(new WeightedIngredient("Jaja", 2.0, 10.0),
                      new WeightedIngredient("Brasno", 3.0, 15.0),
                      new WeightedIngredient("Jabuka", 5.0, 5.0),
                      new WeightedIngredient("Puter", 3.0, 20.0),
                      new WeightedIngredient("Dzem", 3.0, 15.0),
                      new WeightedIngredient("Hleb", 5.0, 5.0),
                      new WeightedIngredient("Piletina", 5.0, 30.0),
                      new WeightedIngredient("Krompir", 7.0, 5.0),
                      new WeightedIngredient("Pasulj", 5.0, 5.0),
                      new WeightedIngredient("Slanina", 3.0, 25.0),
                      new WeightedIngredient("Mleko", 8.0,13.0),
                      new WeightedIngredient("Pirinac", 7.0, 5.0),
                      new WeightedIngredient("Secer", 5.0, 8.0),
                      new WeightedIngredient("Keks", 5.0, 5.0),
                      new WeightedIngredient("Sargarepa", 3.0, 5.0)
                      )
      );

      private static List<Recipe> recipes = makeRecipesList();


    public static List<WeightedIngredient> getIngredients() {
        return ingredients;
    }

    public static void setIngredients(List<WeightedIngredient> ingredients) {
        Database.ingredients = ingredients;
    }

    public static List<Recipe> getRecipes() {
        return recipes;
    }

    public static void setRecipes(List<Recipe> recipes) {
        Database.recipes = recipes;
    }

    public static List<Recipe> makeRecipesList(){

        List<Recipe> allRecipes = new ArrayList<>();


        //Supa
        Recipe supa = new Recipe();
        supa.setName("Supa");
        List<RecipeIngredient> sastojciZaSupu = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(3.0, Database.getWeightedIngredientByName("Piletina")),
                        new RecipeIngredient(1.0, Database.getWeightedIngredientByName("Sargarepa")))
        );
        supa.setRecipeIngredients(sastojciZaSupu);
        supa.setRecipeLevel(RecipeLevel.MEDIUM);
        supa.setFavorite(false);
        allRecipes.add(supa);
        //

        //Keks i mleko
        Recipe keksIMleko = new Recipe();
        keksIMleko.setName("Keks i mleko");
        List<RecipeIngredient> sastojciZaKeksIMleko = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Mleko")),
                        new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Keks")))
        );
        keksIMleko.setRecipeIngredients(sastojciZaKeksIMleko);
        keksIMleko.setRecipeLevel(RecipeLevel.EASY);
        keksIMleko.setFavorite(false);
        allRecipes.add(keksIMleko);
        //

        //Palacinke
        Recipe palacinke = new Recipe();
        palacinke.setName("Palacinke");
        List<RecipeIngredient> sastojciZaPalacinke = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Mleko")),
                        new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Jaja")),
                        new RecipeIngredient(1.0, Database.getWeightedIngredientByName("Brasno")))
        );
        palacinke.setRecipeIngredients(sastojciZaPalacinke);
        palacinke.setRecipeLevel(RecipeLevel.EASY);
        palacinke.setFavorite(false);
        allRecipes.add(palacinke);
        //


        //Sutlijas
        Recipe sutlijas = new Recipe();
        sutlijas.setName("Sutlijas");
        List<RecipeIngredient> sastojciZaSutlijas = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Mleko")),
                        new RecipeIngredient(3.0, Database.getWeightedIngredientByName("Pirinac")),
                        new RecipeIngredient(1.0, Database.getWeightedIngredientByName("Secer")))
        );
        sutlijas.setRecipeIngredients(sastojciZaSutlijas);
        sutlijas.setRecipeLevel(RecipeLevel.EASY);
        sutlijas.setFavorite(false);
        allRecipes.add(sutlijas);
        //

        //Proja
        Recipe proja = new Recipe();
        proja.setName("Proja");
        List<RecipeIngredient> sastojciZaProju = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Jaja")),
                        new RecipeIngredient(1.0, Database.getWeightedIngredientByName("Mleko")),
                        new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Brasno")))
        );
        proja.setRecipeIngredients(sastojciZaProju);
        proja.setRecipeLevel(RecipeLevel.EASY);
        proja.setFavorite(false);
        allRecipes.add(proja);
        //

        //Kajgana
        Recipe kajgana = new Recipe();
        kajgana.setName("Kajgana");
        List<RecipeIngredient> sastojciZaKajganu = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(3.0, Database.getWeightedIngredientByName("Jaja")),
                new RecipeIngredient(1.0, Database.getWeightedIngredientByName("Slanina")))
        );
        kajgana.setRecipeIngredients(sastojciZaKajganu);
        kajgana.setRecipeLevel(RecipeLevel.BEGINNER);
        kajgana.setFavorite(false);
        allRecipes.add(kajgana);
        //

        //Pita od jabuka
        Recipe pitaOdJabuka = new Recipe();
        pitaOdJabuka.setName("Pita od jabuka");
        List<RecipeIngredient> sastojciZaPituOdJabuka = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Jaja")),
                        new RecipeIngredient(3.0, Database.getWeightedIngredientByName("Brasno")),
                        new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Jabuka")))
        );
        pitaOdJabuka.setRecipeIngredients(sastojciZaPituOdJabuka);
        pitaOdJabuka.setRecipeLevel(RecipeLevel.MEDIUM);
        pitaOdJabuka.setFavorite(false);
        allRecipes.add(pitaOdJabuka);
        //

        //Dzem na hlebu
        Recipe dzemIHleb = new Recipe();
        dzemIHleb.setName("Puter i dzem");
        List<RecipeIngredient> sastojciZaPuterIDzem = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Hleb")),
                        new RecipeIngredient(3.0, Database.getWeightedIngredientByName("Dzem")),
                        new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Puter")))
        );
        dzemIHleb.setRecipeIngredients(sastojciZaPuterIDzem);
        dzemIHleb.setRecipeLevel(RecipeLevel.BEGINNER);
        dzemIHleb.setFavorite(false);
        allRecipes.add(dzemIHleb);
        //

        //Piletina sa krompirom
        Recipe pileIKrompir = new Recipe();
        pileIKrompir.setName("Piletina sa krompirom");
        List<RecipeIngredient> sastojciZaPileIKrompir = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Piletina")),
                        new RecipeIngredient(5.0, Database.getWeightedIngredientByName("Krompir")))
        );
        pileIKrompir.setRecipeIngredients(sastojciZaPileIKrompir);
        pileIKrompir.setRecipeLevel(RecipeLevel.HARD);
        pileIKrompir.setFavorite(false);
        allRecipes.add(pileIKrompir);
        //

        //Pasulj
        Recipe pasulj = new Recipe();
        pasulj.setName("Pasulj");
        List<RecipeIngredient> sastojciZaPasulj = new ArrayList<>(
                Arrays.asList(new RecipeIngredient(8.0, Database.getWeightedIngredientByName("Pasulj")),
                        new RecipeIngredient(2.0, Database.getWeightedIngredientByName("Slanina")))
        );
        pasulj.setRecipeIngredients(sastojciZaPasulj);
        pasulj.setRecipeLevel(RecipeLevel.HARD);
        pasulj.setFavorite(false);
        allRecipes.add(pasulj);
        //



        return allRecipes;
    }

    private static WeightedIngredient getWeightedIngredientByName(String name)  {
        for (WeightedIngredient ingredient : ingredients) {
            if(ingredient.getName().equalsIgnoreCase(name))
                return ingredient;
        }
        return new WeightedIngredient();
    }



}
