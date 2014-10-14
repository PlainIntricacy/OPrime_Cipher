/**
 * 
 * Java program that simulates a circular primes decryption device.
 * Unlike a regular Caesar cipher, this version uses the key as its circular prime upper limit.
 * This limit is used to calculate the sum of positive circular primes below it.
 * The calculated sum is then used as the shift number to decrypt the message.
 * 
 * Based on problem 35 on projecteuler.net, and the Caesar Cipher.
 * 
 * https://projecteuler.net/problem=35
 * https://en.wikipedia.org/wiki/Caesar_cipher
 * https://github.com/PlainIntricacy/Circular_Primes
 * 
 */
package oprime_cipher;

import java.util.Scanner;

/*
 *  @author todyerutz @ plainintricacy.wordpress.com
 */
public class OPrime_Cipher {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter your message:");
            String inText = input.nextLine();
            char[] arr = inText.toUpperCase().toCharArray();
            System.out.println("Please enter your key.");
            int sKey = Integer.parseInt(input.nextLine());
            System.out.println("Decrypted message:");
            decrypt(arr, sumOPrimes(sKey));
            System.out.println();
            input.close();
        }    
    }
    
    public static boolean isLetter(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    public static int Lpos(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static int Apos(int x){
        if(x>alphabet.length()){
            return x-alphabet.length();
        }else
            if(x<0){
                return alphabet.length()+x;
            }        
        return x;
    }
            
    public static void decrypt(char[] a, int x){
        x = -x;
        for(int i=0; i<a.length; i++){
            if(isLetter(a[i])){
                a[i] = alphabet.charAt(Lpos(alphabet.charAt(Apos(Lpos(a[i])+x))));
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
    
    public static int sumOPrimes(int x){
        int sum=0;
        if(x>2){
            sum+=2;
        }
        for(int i=3; i<=x; i+=2){
           int temp = i; 
           if(primality(i)&&primality(rotate(temp))){
               sum+=i;
           }           
        }
        return sum;
    }
    
    public static boolean primality(int q){
        if(q==2){
            return true;
        }else
        if(q%2==0&&q!=2){
            return false;
        }else{
        for(int i=3; i<=Math.sqrt(q); i+=2){
                if(q%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int rotate(int x){
        int y=0;
        do{
            y*=10;
            y+=x%10;
            x=x/10;
        }while(x>0);
        return y;
    }
}
