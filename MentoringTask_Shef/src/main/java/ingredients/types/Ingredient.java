package ingredients.types;

/**
 * Created by Sona_Gamaryan on 4/6/2017.
 */
public abstract class Ingredient {
    private int calloriesPerUnit;
    private int unitWeight;
    private int weight;

    protected void setWeight(int qnt)throws IngredientWeightException {
        if (qnt <=0){
            throw new IngredientWeightException("An ingredient object can't have negative or 0 weight");
        }

        this.weight = qnt;
    }

    protected void setCalloriesPerUnit(int cal) {
        calloriesPerUnit = cal;
    }
    protected void setUnitWeight(int wght) throws UnitWeightException {
        if (wght <0) {
            throw new UnitWeightException ("An Ingredient object can't have a negative UnitWieght" + wght);
        }
        else
        unitWeight = wght;
    }

    public int getUnitWeight(){
        return unitWeight;
    }
    public int getCalloriesPerUnit(){
        return calloriesPerUnit;
    }
    public int getWeight(){return this.weight;}

   /* public int getQuantity(){
        return this.weight;
    }*/

    public double calculateCallories(){

        return (double)(weight*calloriesPerUnit / unitWeight);
    }

    @Override
    public String toString(){
        return getClass().getName() + " cals: " + calculateCallories();
    }
}
