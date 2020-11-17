import java.util.*; 

public class P2J2 
{
    public static String removeDuplicates(String text){
        String str[] = text.split("");
        List<String> convert = new ArrayList<String>();
        convert = Arrays.asList(str);
        
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(convert.get(0));
        
        for (int i = 1; i < convert.size(); i++){ 
            if(!convert.get(i-1).equals(convert.get(i))) {
                temp.add(convert.get(i));
            }
        }
        StringBuffer result = new StringBuffer(); //mutable string object to convert toString
        for (String s: temp){
            result.append(s);
        }
        return result.toString();
    }
    
    public static String uniqueCharacters(String text){
        Set uniqueSet = new HashSet<Character>();
        ArrayList<Character> temp = new ArrayList<Character>();
        
        for (int i = 0; i < text.length(); i++) {
            if (!uniqueSet.contains(text.charAt(i))){
                temp.add(text.charAt(i));
            }
            uniqueSet.add(text.charAt(i));
        }
        
        StringBuffer result = new StringBuffer();
     
        for (Character s: temp){
            result.append(s);
        }
        
        return result.toString();
    }
    
    public static int countSafeSquaresRooks(int n, boolean[][] rooks){ 
        Set rookX = new HashSet<Integer>();//set for no duplicate row/column
        Set rookY = new HashSet<Integer>();
        
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if (rooks[x][y]){
                    rookX.add(x);
                    rookY.add(y);
                }
            }
        }
        return (n - rookX.size())*(n - rookY.size());
    }
    
    public static int recaman(int n){
            int[] seq = new int[n + 1];
            boolean[] used = new boolean[10 * n];

            seq[0] = 0;
            used[0] = true;
            for (int i = 1; i < n + 1; i++)
            {
                int minusI = seq[i - 1] - i;
                int plusI = seq[i - 1] + i;
                if ((minusI > 0) && (!used[minusI])) {
                    seq[i] = minusI;
                    used[minusI] = true;
                } else {
                    seq[i] = plusI;
                    used[plusI] = true;
                }
            }
            return seq[n];
        }
    
}
