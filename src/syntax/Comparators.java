package syntax;

import java.util.ArrayList;
import java.util.Comparator;


public class Comparators {
	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Wrench", 11, 16, 54));
		items.add(new Item("Book", 5, 3, 12));
		items.add(new Item("Screwdriver", 5, 1, 25));
		items.add(new Item("Computer", 784, 168, 653));
		items.add(new Item("Magazine", 5, 3, 6));

		items.sort(new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				// If i1 comes before i2, return number < 0
				// If i1 comes after i1, return number > 0
				// If i1 and i2 are equal, return 0

				// This means, if we want lower values to come first:
				//     return i1.value-i2.value
				// If we want higher values to come first:
				//     return i2.value-i2.value

				// highest utility, lowest weight, lowest cost
				if (i1.utility-i2.utility != 0)
					return i2.utility-i1.utility; // highest utility first

				if (i1.weight-i2.weight != 0)
					return i1.weight-i2.utility; // lowest weight first

				return i1.cost - i2.cost; // lowest cost first
			}
		});

		for (int i=0; i<items.size(); i++) {
			System.out.println(items.get(i));
		}
	}

	public static class Item {
		public String name;
		public int utility;
		public int weight;
		public int cost;

		public Item(String n, int u, int w, int c) {
			name = n;
			utility = u;
			weight = w;
			cost = c;
		}

		public String toString() {
			return String.format("%s %d %d %d", name, utility, weight, cost);
		}
	}
}
