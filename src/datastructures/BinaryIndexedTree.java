package datastructures;

public class BinaryIndexedTree { // also known as a Fenwick tree
	
	public static class BITree {
		int N;
		int[] tree;
		
		public BITree(int n) {
			this.N = n;
			tree = new int[n];
		}
		
		public BITree(int[] arr) {
			N = arr.length;
			for(int i = 0; i < arr.length; i++) {
				add(i, arr[i]);
			}
		}
		
		public void add(int i, int dlta) {
			for (; i < N; i = i | (i + 1))
	            tree[i] += dlta;
		}
		
		public int sum(int r) { // sum query (from 0 to r). Can be modified to perform XOR query
	        int ret = 0;
	        for (; r >= 0; r = (r & (r + 1)) - 1)
	            ret += tree[r];
	        return ret;
	    }

	    public int sum(int l, int r) { // range sum query. Can be modified to perform XOR query. CANNOT be modified to perform min, max query
	        return sum(r) - sum(l - 1);
	    }
	}
}
