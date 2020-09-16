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
        ArrayList<Integer> powerr=new ArrayList();
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
        ArrayList<Integer> primee=new ArrayList();
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
        ArrayList<Integer> neutral=new ArrayList();
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
        int n;
        Scanner s =new Scanner(System.in);
        //Input how many arrays we want to create via string
        String rowcol;
        System.out.println("Enter the row col values for the array:");
        rowcol=s.nextLine();
        int len=rowcol.length();
        //System.out.print(len);
        //If string is not of even length row col value cannot be extracted
        if(len%2!=0)
        {
            System.out.println("Invalid input");
        }
        else
        {
        ArrayList<int[][]>list;
        list = new ArrayList<>();
        int first=0;
        int second=1;
        for (int i=0; i<(rowcol.length())/2; i++) {
            
            int[][] ia = new int[rowcol.charAt(first)-'0'][rowcol.charAt(second)-'0'];
            list.add(ia);
            first=second+1;
            second=second+2;
        }
        
        //Input the value of passenger ID
        System.out.println("Enter no of  passengers");
        n=s.nextInt();
        int[] pid1=new int[n];
        System.out.println("Enter the passengers ID: ");
        for(int i=0;i<n;i++)
        {
            pid1[i]=s.nextInt();
        }
        int[] pid=new int[n];
        ArrayList<Integer> primelist;
        primelist = getprime(pid1,n);
        ArrayList<Integer> power;
        power=getpower(pid1,n);
        ArrayList<Integer> neutral;
        neutral=getneutral(pid1,primelist,power,n);
        primelist.addAll(power);
        primelist.addAll(neutral);

        for(int i=0;i<primelist.size();i++)
        {
            pid[i]=primelist.get(i);
        }
        int row,col;
        int m=0;
        int plen=pid.length;
        //filling aisle seat
        for(int i=0;i<list.size();i++)
        {
            int[][] a=list.get(i);
            row=a.length;
            col=a[0].length;
            //first array has only one aisle column
            if(i==0)
            {
                for(int r=0;r<row;r++)
                {
                  if(m<plen)
                   {
                     a[r][col-1]=pid[m];
                     m++;
                   }
                }
            }
            //Last row has only one aisle column
            else if(i==list.size()-1)
            {
                for(int r=0;r<row;r++){
                 if(m<plen)
                 {
                    a[r][0]=pid[m];
                    m++;
                 }
                }
            }
            
            else
            {
            if(m<plen)
            {
                for(int r=0;r<row;r++){
                    if(m<plen){
                    a[r][0]=pid[m];
                    m++;}
                    
                    if(m<plen){
                    a[r][col-1]=pid[m];
                    m++;}
                }
            }
            }
        }
        //filling window seat
        int[][] a=list.get(0);
        int arow=a.length;
        for(int r=0;r<arow;r++ ) {
            if (m<plen) {
                a[r][0] = pid[m];
                m++;
            }
        }
        int[][] b=list.get(list.size()-1);
        int bcol=b[0].length;
        int brow=b.length;
        for (int r=0;r<brow;r++) {
            if (m<plen) {
                b[r][bcol-1] = pid[m];
                m++;
            }
            }
        
        //filling rest of the center seats
        for(int i=0;i<list.size();i++)
        {
            int[][] cen=list.get(i);
            row=cen.length;
            col=cen[0].length;
            for(int r=0;r<row;r++)
                    
            {
                for(int j=1;j<col-1;j++)
                {
                    if(m<plen){
                    cen[i][j]=pid[m];
                    m++;}
                }
            }
            
        }
        
        
        //int rv=0;
        for(int v=0;v<list.size();v++)
        {
            
            int[][] val=list.get(v);
            int ar=val.length;
            int ac=val[0].length;
            System.out.println((v+1)+" Array");
            for(int i=0;i<ar;i++)
            {
                for(int j=0;j<ac;j++)
                {
                System.out.print(val[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
	
        }
                  
    }
    
}
/*TESTCASE 1:
Enter the row col values for the array:
23343243
Enter no of  passengers
25
Enter the passengers ID: 
29 59 14 11 3 13 15 18 12 16 6 17 7 47 61 5 21 2 41 9 10 8 19 1 4

1 Array  2 Array    3 Array  4 Array
18 1 29  11 0 0 3    61 5     8 0 6
12 0 59  13 0 0 17   2  41    4 0 21
         7  0 0 47   19  16   14 0 9
                              15 0 10

TESTCASE 2:
Enter the row col values for the array:
2443
Enter no of  passengers
7
Enter the passengers ID: 
1 2 16 8 59 7 6

1 Array      2 Array
6 0 0 2      7 0 0   
0 0 0 59     16 0 0
             8  0 0
             1  0 0   
TESTCASE 3:
Enter the row col values for the array:
32234
Invalid Input.

TESTCASE 4:
Enter the row col values for the array:
522113
Enter no of  passengers
10
Enter the passengers ID: 
9 5 3 4 87 47 11 15 25 29

1 Array    2 Array  3 Array
0 5        9        25 0 0
0 3        15
0 47 
0 11 
0 29 

TESTCASE 5:
Enter the row col values for the array:
342322
Enter no of  passengers
15
Enter the passengers ID: 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

1 Array    2 Array  3 Array
6 15 0 2   7 0 11   8 12
9 0 0 3    13 0 4   1 14
10 0 0 5 


TESTCASE 6:
Enter the row col values for the array:
233243342244
Enter no of  passengers
20
Enter the passengers ID: 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

1 Array  2 Array  3 Array   4 Array        5 Array  6 Array
0 0 2    5 7      4  0  8   14  0  0  15    0  0     0  0  0  0
0 0 3    11 13    16 0  1   18  0  0  20    0  0     0  0  0  0
         17 19    6  0  9   0   0  0   0             0  0  0  0
                  10 0  12                           0  0  0  0

*/
