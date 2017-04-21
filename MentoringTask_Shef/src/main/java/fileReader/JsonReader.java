package fileReader;

import ingredients.types.Base;
import ingredients.types.GreenBase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sona_Gamaryan on 4/13/2017.
 */
public class JsonReader implements IngredientsFileReader {
    private String base;
    private String base_weight;
    private String topping;
    private String topping_weight;
    private JSONArray dressingList;
    private JSONArray greenBaseList;
    private JSONParser parser = new JSONParser();
    private HashMap<String, GreenBase> hashmap = new HashMap<String, GreenBase>();
    //private String

    @Override
    public void getIngredients(String fileName) {
        try {
            Object obj = null;

            obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;

            base = (String) jsonObject.get("GreenBase");
            base_weight = (String) jsonObject.get("weight1");
            topping = (String) jsonObject.get("Topping");
            topping_weight = (String) jsonObject.get("weight2");
            dressingList = (JSONArray) jsonObject.get("Dressing");

        } catch (NullPointerException | IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printIngredients() {
        System.out.println("---------");
        getGreenBase();
        getIngredients("ingredients2.json");

        Iterator<String> iterator1 = dressingList.iterator();
        System.out.println("\nPrint out French dressing ingredients:");
        iterator1 = dressingList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        getGreenBase();
    }
        public List<Base> getGreenBase()  {
            List<Base> baseList = new ArrayList<>();
            JSONObject jsonObject=null;
            initializeMap();
         try {
             Object obj = null;

             obj = parser.parse(new FileReader("GreenBase.json"));
             jsonObject = (JSONObject) obj;
         } catch (Exception e){
             e.printStackTrace();
         }
            List<Map<String, String>> baseName1 = (List<Map<String, String>>) jsonObject.get("GreenBase");
             for(Map<String, String> iterator: baseName1){
               //  iterator.get("name");
                 String baseName = iterator.get("name");
                 Integer weight = Integer.parseInt(iterator.get("weight"));
                 Integer calsPerUnit =Integer.parseInt(iterator.get("CalloriesPerUnit"));
                 Integer weightPerUnit = Integer.parseInt(iterator.get("WeightPerUnit"));
                baseList.add(new Base(hashmap.get(baseName), weight, calsPerUnit, weightPerUnit));
             }
         return baseList;
        }

        private void initializeMap() {
           // initialaze hashMap
            hashmap.put("Lettuce", GreenBase.Lettuce);
            hashmap.put("Broccoly", GreenBase.Broccoly);
            hashmap.put("Spinach", GreenBase.Spinach);
            hashmap.put("Cabbage", GreenBase.Cabbage);
            hashmap.put("GreenLeaf", GreenBase.GreenLeaf);

        }
}