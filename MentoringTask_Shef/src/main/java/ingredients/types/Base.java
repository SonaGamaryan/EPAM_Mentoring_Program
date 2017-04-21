package ingredients.types;

/**
 * Created by Sona_Gamaryan on 4/6/2017.
 */
public class Base extends Ingredient {
    private GreenBase greenBase;

    public Base(GreenBase baseIngredien, int wght, int calPerUnit, int unitWght){
        this.greenBase = baseIngredien;
        this.setCalloriesPerUnit(calPerUnit);
        this.setUnitWeight(unitWght);
        this.setWeight(wght);
    }
    @Override
    public String toString(){
        return greenBase.toString() + " cals: " +calculateCallories();
    }

    /**
     * Created by Sona_Gamaryan on 4/14/2017.
     */
    public static class IngredientsCountException extends RuntimeException {
        //Parametrized constructor
        public IngredientsCountException(String message){
            super(message);
        }
    }
}
