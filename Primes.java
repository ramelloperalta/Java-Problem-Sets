import java.util.*;
import static java.lang.Math.sqrt;

/*
 * modeled from pythonexamples/primes.py by Ilkka Kokkarinen July 2019
 */
public class Primes
{   
 
    private static LinkedList<Integer> primeList = new LinkedList<>(Arrays.asList(2,3,5,7,11));
    
    private static void expandPrimes(int n){ //adds primes to primeList to at least sqrt(n), sufficient for primality test
        
        int x = primeList.peekLast() + 2; //difference between two primes is at least 2 or multiple of 2
        
        while (n > primeList.peekLast()) {
            if (isPrime(x)) { primeList.offerLast(x);}
            x += 2;
        }
       
    }
        
    
    public static boolean isPrime(int n){
        if (n == 2) return true;
        if (n < 2) return false; 
        if (n % 2 == 0) return false;
        
        int upperBound = (int)(sqrt(n) + 1); 
        expandPrimes(upperBound); //expands upperbound of non-trivial factors in primeList up to sqrt(n) which is sufficient to compute primality
        
        for (int i: primeList){ 
            if (n % i == 0) return false;  
            if (i * i > n) return true; // if (int)sqrt(n) * (int)sqrt(n) > n, no non-trivial factors exist
        }
        return primeList.contains(n);
    
    }
    
    
    public static int kthPrime(int k){
        while (primeList.size() < k + 1){
            expandPrimes(primeList.peekLast() + 2);
        }
        return primeList.get(k);
    }
    
    public static List<Integer> factorize(int n){
        List<Integer> primefactors = new ArrayList<Integer>();
        
        int upperBound = (int)(sqrt(n) + 1); 
        expandPrimes(upperBound);
        
        while (n % 2 == 0) { // reducing composite numbers; 2 is still a prime number
            primefactors.add(2);
            n /= 2; 
        } 
  
        for (int p: primeList) { // remaining prime factors of odd n
            while (n % p == 0) 
            { 
                primefactors.add(p);
                n /= p; 
            } 
        } 
  
        if (n > 2) primefactors.add(n);
        //System.out.println(factors);
        return primefactors;
    }
    
    public static void main(String[] args){     
       //isPrime(2); isPrime(201);
       //kthPrime(20);
       //factorize(220);
    }
    
}

