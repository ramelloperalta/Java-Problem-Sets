import java.util.*;

public class P2J3
{  
   public static void reverseSubarray(int[] items, int position, int countLength){
       for(int c = 0; c < countLength / 2; c++) {

           int t = items[position + c];
           items[position + c] = items[position + countLength - c - 1 ];
           items[position + countLength - c - 1] = t;
                    
       }
   }
   
   public static void reverseAscendingSubarrays(int[] items) {
       //System.out.println(Arrays.toString(items));
       int countLength = 1;
       int position = 0;
       for (int i=0; i< items.length-1; i++) {
            if (items[i] < items[i+1]) { 
                
                countLength++; // length of subarray     
                
            } else if (countLength>1) {
                
                reverseSubarray(items, position, countLength);
                position += countLength;//adjust index for start of next subarray
                countLength = 1;   
                
            } else {
                position += 1;
            }
            if ((i==items.length-2)& countLength>1) { //end of array; how to do without an explicit case?
                reverseSubarray(items, position, countLength);
            }
       }//System.out.println(Arrays.toString(items));
   }
   
   public static String pancakeScramble(String text){
       String result = text;
       for (int i = 2; i < text.length(); i++) {
           String reverse = new StringBuilder(text.substring(0,i)).reverse().toString(); //System.out.println("reverse " + reverse);
           String subString = text.substring(i); //System.out.println("subString " + subString);
           text = reverse+subString;
           result = text;
       }
       String reverseResult = new StringBuilder(result).reverse().toString();
       return reverseResult;
    }
       
   public static String reverseVowels(String text){
       List<Character> temp = new ArrayList<>();
       List<Character> vowels = new ArrayList<>();
       
       for (char character : text.toCharArray()) {
           if("aeiouAEIOU".indexOf(character) != -1){
               vowels.add(character);
            } 
        }
       int count = vowels.size()-1;
       
       for (char character : text.toCharArray()) {
           
           if("aeiouAEIOU".indexOf(character) == -1){
              temp.add(character);
           } else {
              if ("AEIOU".indexOf(character) != -1){
              temp.add(Character.toUpperCase(vowels.get(count)));
              count--;
            } else {
                temp.add(Character.toLowerCase(vowels.get(count)));
                count--;
            }
           }
       }
       
       StringBuffer result = new StringBuffer(); 
       for (char s: temp){
           result.append(s);
       }
       return result.toString();
     }

 }
