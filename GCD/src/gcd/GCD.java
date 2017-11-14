/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;
import java.util.Scanner;
/**
 *
 * @author Pero Djukic
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        int n1 = scanner.nextInt();
        System.out.println("Secound number: ");
        int n2 = scanner.nextInt();

        System.out.println("---------------------------------------\nGCD by using the Euclidean algorithm");
        System.out.println("The gcd is: "+euclidean(n1,n2)+"\n");

        gcd(n1,n2);
    }
    private static int euclidean(int a, int b){
        if   (b != 0){
             return euclidean(b,a%b);
        }
        return a;
    }
    private static void gcd(int a, int b){
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        int p1 = 1;
        int p2 = 1;
        int i = 0;
        int j = 0;

        while (a!=1){
            p1=nPrime(a,p1);
            n1[i] = p1;
            a = a/p1;
            p1 = 1;
            i++;
        }
        while (b!=1){
            p2 =nPrime(b,p2);
            n2[j] = p2;
            b = b/p2;
            p2 = 1;
            j++;
        }

        int[] sum = new int[10];
        int cnt =0;

        for (int l = 0; l<n1.length; ){
            for (int k = 0; k<n2.length; ) {
                if (n1[l] == n2[k] && n1[l] != 0 && n2[k] != 0){
                    sum[cnt] = n1[l];
                    n2[k] = 0;
                    k++;
                    l++;
                    cnt++;
                }
                else {
                    k++;
                }
            }l++;
        }

        int summe = 1;

        if (sum[0]!=0) {
            for (int c = 0; c < sum.length&& sum[c]!=0; ) {
                summe *= sum[c];
                c++;
            }
        }
        else {
            summe = sum[0];
        }

        System.out.println("---------------------------------------\nGCD by the product of the common prime");
        System.out.println("The gcd is: "+summe+"\n");
    }
    private  static int nPrime(int n, int m){
        m++;
        if (n%m == 0){
            return m;
        }
        return nPrime(n,m);
    }
}

