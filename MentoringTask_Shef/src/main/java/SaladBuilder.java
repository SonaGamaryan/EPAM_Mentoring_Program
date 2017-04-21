import ingredients.types.Base;
import ingredients.types.Dressing;
import ingredients.types.Ingredient;
import ingredients.types.Topping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Created by Sona_Gamaryan on 4/6/2017.
 */
public class SaladBuilder {
    private List<Base> baseList;
    private List<Topping> toppingList;
    private List<Dressing> dressingList;
    private List<Ingredient> ingredientList;
    private double saladCallories =0;

    public SaladBuilder(){
        baseList = new ArrayList<>();
        toppingList = new ArrayList<>();
        dressingList = new ArrayList<>();
        ingredientList = new ArrayList<>();

    }

    public void addGreenBase(Base base){
        baseList.add(base);
        ingredientList.add(base);
        if (ingredientList.size() >=3) {
            throw new Base.IngredientsCountException("more than 2 ingredients");
        }
    }

    public void addTopping(Topping topping){
        toppingList.add(topping);
        ingredientList.add(topping);
        if (ingredientList.size() >=4) {
            throw new Base.IngredientsCountException("More than 4 ");
        }
    }

    public void addDressing(Dressing dressing){
        dressingList.add(dressing);
        ingredientList.add(dressing);
      /*  if (ingredientList.size() >=2) {
            throw new ingredients.types.Base.IngredientsCountException();
        }*/
    }

    public double getSaladCallories(){
        return saladCallories;
    }

    public double calculateTotalCallories(){
        double totalCallories =0;
        for (Base next: baseList){
            totalCallories += next.calculateCallories();
        }

        for (Topping next: toppingList){
            totalCallories += next.calculateCallories();
        }

        for (Dressing next: dressingList){
            totalCallories += next.calculateCallories();
        }

        return totalCallories;
    }

    private void sortingSaladElements(){
        ingredientList.sort(new Comparator<Ingredient>(){
            @Override
            public int compare(Ingredient ing1, Ingredient ing2){
                return Double.compare(ing1.calculateCallories(), ing2.calculateCallories());
            }
        });

    }


    public void printSaladIngredients(){
        sortingSaladElements();
        System.out.println("The sorted salad Ingredients by callories are: ");

        for(int i=0;i<ingredientList.size();i++){
            System.out.println(ingredientList.get(i));
        }
    }

    public void findIngredient(int minCals, int maxCals){
        System.out.println("---------");
        System.out.println("The following ingredients are in the rage of " +minCals+ "-" +maxCals+ " cals:");
       for(int i=0;i<ingredientList.size();i++){
            if (ingredientList.get(i).calculateCallories() >= minCals &&
                    ingredientList.get(i).calculateCallories() <= maxCals) {
                System.out.println(ingredientList.get(i));
            }
        }
    }

}
