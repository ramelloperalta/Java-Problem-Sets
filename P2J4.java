import java.util.*;
/**
 * Write a description of class P2J4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class P2J4
{
    // instance variables - replace the example below with your own
    public static List<Integer> runningMedianOfThree(List<Integer> items){
        List<Integer> result = new ArrayList<>();
        if (items.size() < 3) { return items; }
        result.add(items.get(0));
        result.add(items.get(1));
        for (int i = 0; i < items.size() - 2; i++){
            if ((items.get(i) >= items.get(i+1) && items.get(i+1) >= items.get(i+2))
            ||(items.get(i) <= items.get(i+1) && items.get(i+1) <= items.get(i+2)))
            {
                result.add(items.get(i+1));
            } else if ((items.get(i+2) >= items.get(i) && items.get(i) >= items.get(i+1))
            ||(items.get(i+1) >= items.get(i) && items.get(i) >= items.get(i+2))){
                result.add(items.get(i));
            } else if ((items.get(i) >= items.get(i+2) && items.get(i+2) >= items.get(i+1))
            ||(items.get(i+1) >= items.get(i+2) && items.get(i+2) >= items.get(i))){
                result.add(items.get(i+2));
            }
        }
        //System.out.println(result);
        return result;
        
    }
    public static int firstMissingPositive(List<Integer> items){
        List<Integer> copy = items;
        Collections.sort(copy);
        if (items.isEmpty()||(items.size()<2)){ //System.out.println(1);
            return 1;} 
            
        for (int i = 0; i < items.size()-1; i++){
            if ((copy.get(i) == copy.get(i+1)-1) || (copy.get(i) == copy.get(i+1))){
                continue;
            } else {
                //System.out.println(copy.get(i)+1);
                return copy.get(i) + 1;
            }
        } //System.out.println(1);
        return 1;
    }
    
    //public static void sortByElementFrequency(Map<Integer, Integer> check) implements Comparator<Integer>{
    //}
    public static void sortByElementFrequency(List<Integer> items){
        List<Integer> copy = items;
        Collections.sort(copy);
        Map<Integer, Integer> count = new HashMap<>();
        int counter = 1;
        count.put(copy.get(0), 1);
        for (int i = 1; i < copy.size(); i++){
            if (copy.get(i).equals(copy.get(i-1))){
                counter++;
            } else {
                counter = 1;
            }
            count.put(copy.get(i), counter);
        } 
        /*for (Map.Entry entry : count.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }*/
          


    }
    public static List<Integer> factorFactorial(int n){
        return null;
    }
    public static void main( String[ ] args ){
        List<Integer> test1 = new ArrayList<>();
        test1.add(5);
        test1.add(2);
        test1.add(9);
        test1.add(1);
        test1.add(7);
        test1.add(4);
        test1.add(6);
        test1.add(3);
        test1.add(8);
        List<Integer> test2 = new ArrayList<>();
        test2.add(7); test2.add(5);test2.add(3);test2.add(10);test2.add(2);
        test2.add(99999);test2.add(4);test2.add(6);test2.add(3);test2.add(9);
        test2.add(2);
        
        List<Integer> test3 = new ArrayList<>();
        test3.add(6);test3.add(2);test3.add(12345678);
        
        List<Integer> test4 = new ArrayList<>();
        test4.add(2);
        test4.add(4);
        test4.add(2);
        test4.add(4);
        test4.add(4);
        test4.add(8);
        test4.add(4);
        test4.add(1);
        test4.add(8);
        
        //sortByElementFrequency(test4);
        //firstMissingPositive(test2);
        //runningMedianOfThree(test1);
    }
}
