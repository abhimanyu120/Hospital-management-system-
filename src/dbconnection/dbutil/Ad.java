/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection.dbutil;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Ad 
{
    public static void main(String[] args) {
        System.out.println("Enter first line:");
        int a,b;
        Scanner kb=new Scanner (System.in);
        a=kb.nextInt();
        b=kb.nextInt();
        int[]arr=new int[a];
        System.out.println("Enter the array value:");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=kb.nextInt();
        }
       for(int i=1;i<=b;i++)
       {
           System.out.println("Enter the third line: ");
           int s=kb.nextInt();
           s=s-1;
           int e=kb.nextInt();
           e=e-1;
           int op=kb.nextInt();
           for(;s<=e;s++)
           {
               arr[s]=arr[s] & op;
           }    
       }
        System.out.println("-----------------Output------------");
       for(int j=0;j<arr.length;j++)
           {
               System.out.println(arr[j]);
           }
        
    }
}
