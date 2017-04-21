import java.util.*;
//import java.util.scan
/**
 * Created by Sona_Gamaryan on 4/4/2017.
 */
public class SortingArray {
    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        System.out.println("Task#1.2: Sort list or array by count of consonants in string");
        System.out.println("Please enter text here: ");
        String text = scr.nextLine();

        String arr[] = text.split(" ");
        //String[] arr2 = new String[arr.length];
        String tempStr = new String();

        for (int t = 0; t < arr.length-1; t++) {
            for (int i= 0; i < (arr.length -t-1); i++) {
                if(arr[i+1].length() < arr[i].length()) {
                    tempStr = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tempStr;
                }
            }
        }


        System.out.println("The sorted array result: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}


