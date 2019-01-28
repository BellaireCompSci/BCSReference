package syntax;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        System.out.println(array);
        array.add(1);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(5);
        System.out.println(array);

        array.remove(3); // removing item at index 3
        System.out.println(array);

        array.remove(Integer.valueOf(5)); // removing item that equals the integer object 5
        System.out.println(array);
    }
}
