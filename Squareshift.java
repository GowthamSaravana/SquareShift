/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareshift;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Squareshift {

    /**
     * @param args the command line arguments
     * 
     */
    static boolean isprime(int a)
    {
    if(a<=1)
        return false;
    if(a==2)
        return true;
    int c;

   for ( c = 2 ; c <= a/2 ; c++ )
   {
      if ( a%c == 0 )
     return false;
   }
   return true;
    }
    static boolean ispower(int n)
    {
    if (n == 0||n==1||n==2) 
    return false; 
    while (n != 1) 
     { 
      if (n%2 != 0) 
         return false; 
      n = n/2; 
      } 
  return true; 
    }
    static ArrayList getpower(int[] arr,int n)
    {
        ArrayList powerr=new ArrayList();
        int i;
        for(i=0;i<n;i++)
        {
            if(ispower(arr[i]))
            {
                powerr.add(arr[i]);
                
            }
        }
        return powerr;
    }
    static ArrayList getprime(int[] arr,int n)
    {
        ArrayList primee=new ArrayList();
        int i;
        for(i=0;i<n;i++)
        {
            if(isprime(arr[i]))
            {
                primee.add(arr[i]);
                
            }
        }
        return primee;
    }
    static ArrayList getneutral(int[] arr,ArrayList prime,ArrayList power,int n)
    {
        ArrayList neutral=new ArrayList();
        int i;
        for(i=0;i<n;i++)
        {
            if(prime.contains(arr[i])||power.contains(arr[i]))
            {
                continue;
            }
            else
            {
                neutral.add(arr[i]);
            }
        }
        return neutral;
    }
    public static void main(String[] args) {
         int n,c1,r1,c2,r2,c3,r3,c4,r4;
        Scanner s =new Scanner(System.in);
        int[][] arr=new int [4][2];
        for(int i=0;i<4;i++)
        {
            System.out.println("Enter the row and col values for 2d array "+(i+1));
            for(int j=0;j<2;j++)
            {
                arr[i][j]=s.nextInt();
            }
        }
        System.out.println("Enter no of  passengers");
        n=s.nextInt();
        int[] pid1=new int[n];
        System.out.println("Enter the passengers ID: ");
        for(int i=0;i<n;i++)
        {
            pid1[i]=s.nextInt();
        }
        int[] pid=new int[n];
        ArrayList primelist;
        primelist = getprime(pid1,n);
        //System.out.println("PrimeList"+primelist);
        ArrayList power;
        power=getpower(pid1,n);
        //System.out.println("Power"+power);
        ArrayList neutral;
        neutral=getneutral(pid1,primelist,power,n);
        //System.out.println("Neutral"+neutral);
        primelist.addAll(power);
        primelist.addAll(neutral);

        for(int i=0;i<primelist.size();i++)
        {
            pid[i]=(int) primelist.get(i);
        }
        r1=arr[0][0]; 
        c1=arr[0][1];
        r2=arr[1][0];
        c2=arr[1][1];
        r3=arr[2][0];
        c3=arr[2][1];
        r4=arr[3][0];
        c4=arr[3][1];
        int[][] a=new int[r1][c1];
        int[][] b=new int[r2][c2];
        int[][] c=new int[r3][c3];
        int[][] d=new int[r4][c4];
        int m=0;
        int sum=(r1*c1)+(r2*c2)+(r3*c3)+(r4*c4);
        if(n>sum)
        {
            System.out.println("There number of passenger is larger than the available seats");
        }
        else
        {
        
        for(int i=0;i<4 ;i++) {
            //aisle seating
           
            if(i<r1 && m<pid.length) {
                a[i][c1-1]=pid[m];
                m++;
                
            }
            if(i<r2 && m<pid.length) {
                
                b[i][0]=pid[m];
                    m++;
                   
                    if(!(m<pid.length))
                        break;
                    
                    b[i][c2-1]=pid[m];
                    m++;
                 
            }
            if(i<r3 && m<pid.length) {
                  c[i][0]=pid[m];
                    m++;
                    if(!(m<pid.length))
                        break;
                    
                   c[i][c3-1]=pid[m];
                   
                    m++;
             }
            if(i<r4 && m<pid.length){            
                     d[i][0]=pid[m];
                m++;
            }
            
                    
        }
        //for window seat
        for(int i=0;i<4;i++) {
            if(i<r1 && m<pid.length){
            a[i][0] = pid[m];
            m++;
            }
            if(i<r4 && m<pid.length) {
            d[i][c4-1]=pid[m];
            m++;
            }
        }
        
        //for center seat
        for(int i=0;i<4;i++) {
            for(int j=1;j<c1-1 && m<pid.length ;j++) {
                a[i][j]=pid[m];
                m++;
            }
            for(int j=1;j<c2-1 && m<pid.length;j++){
                b[i][j]=pid[m];
                m++;
            }
            for(int j=1;j<c3-1 && m<pid.length;j++){
                c[i][j]=pid[m];
                m++;
            }
            for(int j=1;j<c4-1 && m<pid.length;j++){
                d[i][j]=pid[m];
                m++;
            }
        }
       
        System.out.println(" First array");
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
                System.out.print(a[i][j]+" ");
                
            }
            System.out.println(" ");
        }
        System.out.println("Second ");
        for(int i=0;i<r2;i++){
            for(int j=0;j<c2;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println(" Third");
        for(int i=0;i<r3;i++){
            for(int j=0;j<c3;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("Fourth ");
        for(int i=0;i<r4;i++){
            for(int j=0;j<c4;j++){
                System.out.print(d[i][j]+" ");
            }
            System.out.println(" ");
        }
     }
                  
    }
    
}
