package examples;

import java.util.*; 
 class UnaryIncrementExample{
   public static void main (String[] args){
     for(int i=0;i<5;){
       System.out.print (i++*5+" ");
     }
      System.out.println();
     for(int i=0;i<5;){
       System.out.print ((i++)*5+" ");
     }
      System.out.println();
     for(int i=0;i<5;){
       System.out.print(++i*5+" ");
     }
      System.out.println();
     int[] x = {1,2,3,4,5};
     for(int i=0;i<x.length;i++){
       System.out.print(x[i]+++" ");  //janky syntax but its 
                                      //x[i]++ + " "
     }
     System.out.println("\n"+Arrays.toString(x));
     /*output is: 
        0 5 10 15 20 -    i++ happens after the print,
        0 5 10 15 20 -    apparently even if you do parentheses. This is because i++ is just shorthand for i+=1, which is a separate command (I think)
        5 10 15 20 25 -   ++i is the highest precedence possible. Does the same thing as i++
        1 2 3 4 5 - G     iven the way the above statements work, this should not be surprising
        [2, 3, 4, 5, 6] - each of the array's elements are incremented
        */
  }
 }
