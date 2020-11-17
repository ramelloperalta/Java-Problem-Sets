


public class P2J1
{
    public static long fallingPower(int n, int k){
        long result = n; 
        int x = n;
        if (k == 0) {
            return 1;
        }
        for (int i = 0; i < k-1; i++) {
            x--;
            result = result * x;
        }
        return result;
    }
    
    public static int[] everyOther(int[] arr){
        int len;
        if (arr.length % 2 == 0) {
            len = arr.length / 2;
        } else {
            len = (arr.length / 2) + 1;
        }
        int[] result = new int[len];
        int count=0;
        for (int i = 0; i < arr.length; i += 2) { 
            result[count] = arr[i];
            count++;
        }
        return result;
    }///works
    
    public static int[][] createZigZag(int rows, int cols, int start){
        int[][] result = new int[rows][cols];
        for (int r = 0; r < rows; r++) ///nested loop to go through each 2d element
        {
          for (int c = 0; c < cols; c++)
          {
            result[r][c] = start;
            start++;
          }
        }
 
        for (int i = 1; i < rows; i+=2)
        {
           for (int x = 0; x < cols / 2; x++){
               int temp = result[i][x];
               result[i][x] = result[i][cols - x - 1];
               result[i][cols - x - 1] = temp;
            }
        }
        return result;
    }
    
    public static int countInversions(int[] arr){
        int count = 0; 
        for (int i = 0; i <= arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
               if (arr[i] > arr[j]){
                   count++; 
               } 
           } 
        } 
        return count; 
    }
}
