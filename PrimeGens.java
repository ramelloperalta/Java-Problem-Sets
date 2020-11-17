
import java.util.*;

public class PrimeGens {
    
   public static class TwinPrimes implements Iterator<Integer>{
       private int i = 0;
       
       @Override public boolean hasNext() {return true;}
       @Override public Integer next(){
            while(true){
                int p = Primes.kthPrime(i++);
                if(Primes.isPrime(p+2)){
                    return p;
                }
            }
       }
   }
   
   public static class SafePrimes implements Iterator<Integer>{
       private int i = 0;
       
       @Override public boolean hasNext(){return true;}
       @Override public Integer next(){
            while(true){
                int p = Primes.kthPrime(i++);
                
                if(Primes.isPrime(2*(p/2)+1) && Primes.isPrime(p/2)){
                    return p;
                }
            }
        } 
   }
    
   public static class StrongPrimes implements Iterator<Integer>{
       private int i = 0;
       
       @Override public boolean hasNext(){return true;}
       @Override public Integer next() {// a strong prime is one which is higher than the arithmetic mean of the prime above and prime below
           while(true){
               int p = Primes.kthPrime(++i);//preincrement
               int a = Primes.kthPrime(i-1);
               int b = Primes.kthPrime(i+1);
               
               if(p > ((a+b)/2)){
                   return p;
               }
           
            } 
        }
    }
   
   //public static void main(String[] args){
       /*TwinPrimes test1 = new TwinPrimes();
       for (int i = 0; i < 24; i++){
           System.out.println(test1.next());
       }*/
       
       /*SafePrimes test2 = new SafePrimes();
       for (int i = 0; i < 24; i++){
           System.out.println(test2.next());
       }*/
       
       /*StrongPrimes test3 = new StrongPrimes();
       for (int i = 0; i < 20; i++){
           System.out.println(test3.next());
       }*/
   //}
  
}

