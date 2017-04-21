package ingredients.types;

/**
 * Created by Sona_Gamaryan on 4/8/2017.
 */
public class Dressing extends Ingredient {
    private Dressing_enum dressing;

    public Dressing(Dressing_enum dressingIngredient, int wght){
        this.dressing = dressingIngredient;
        this.setCalloriesPerUnit(200);
        this.setUnitWeight(40);
        this.setWeight(wght);
    }
    @Override
    public String toString(){
        return dressing.toString() + " cals: " +calculateCallories();
    }
}
