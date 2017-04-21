package ingredients.types;

/**
 * Created by Sona_Gamaryan on 4/8/2017.
 */
public class Topping extends Ingredient {
    private Topping_enum topping;

    public Topping(Topping_enum toppingIngredient, int wght) {
        this.topping = toppingIngredient;
        this.setCalloriesPerUnit(500);
        this.setUnitWeight(50);
        this.setWeight(wght);
    }

    @Override
    public String toString(){
        return topping.toString() + " cals: " +calculateCallories();
    }
}
