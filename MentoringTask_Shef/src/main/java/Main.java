import fileReader.JsonReader;
import ingredients.types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sona_Gamaryan on 4/6/2017.
 */
public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("Tasks #2-4: Shef");
        System.out.println("--------------------");
        List<Base> base =new ArrayList<>();
        Topping topping = new Topping(Topping_enum.Avocado,120);
        Dressing dressing = new Dressing(Dressing_enum.FrenchDressing,250);
        SaladBuilder newSalad = new SaladBuilder();
        JsonReader newJsonReader = new JsonReader();
        try {
            base = newJsonReader.getGreenBase();
        } catch (IngredientWeightException e){
            System.out.println(e);
        }

        //adding Bases from json
        try {
            for(Base k:base){
                newSalad.addGreenBase(k);
            }
            newSalad.addTopping(topping);
            newSalad.addDressing(dressing);
        } catch (Base.IngredientsCountException e) {
            e.printStackTrace();
        }

      System.out.println("Your salad is ready, the total callories: " + newSalad.calculateTotalCallories());

      newSalad.printSaladIngredients();

      newSalad.findIngredient(60, 150);

      newJsonReader.printIngredients();
    }

}