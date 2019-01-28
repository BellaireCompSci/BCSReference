package examples;

import java.util.Arrays;

public class LinkedArrays{
   public static void main (String[] args){
     int[] a = {1,2,3,4,5};
     int[] b = a; //b will now point to the data point where a is instead of creating a new instance.
     System.out.println(Arrays.toString(b));
     a[0]=a[1];
     System.out.println(Arrays.toString(b));
     b[1]=b[2];
     System.out.println(Arrays.toString(a));
     System.out.println(Arrays.toString(b));
     a= new int[]{5,6,7,8,9};
     System.out.println(Arrays.toString(a)); //moving to a different pointer due to the new keyword
     System.out.println(Arrays.toString(b));
     /*output:
      [1, 2, 3, 4, 5]
      [2, 2, 3, 4, 5]
      [2, 3, 3, 4, 5]
      [2, 3, 3, 4, 5]
      [5, 6, 7, 8, 9]
      [2, 3, 3, 4, 5]
      NOTE: this works for all objects*/
   }
 }
