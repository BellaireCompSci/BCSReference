package algorithms;

import java.util.*;

public class lowestCommonAncestor { // LCA query using pre-processed segment tree
	

	static class LCA {
		int[] height, first, segtree;
	    boolean[] visited;
	    List<Integer> euler;
	    int n;
	    List<List<Integer>> adjList;
	    
	    public LCA(List<List<Integer>> adj) {
	    	int root = 1;
	        n = adj.size();
	        height = new int[n];
	        first = new int[n];
	        euler = new ArrayList<>();
	        visited = new boolean[n];
	        adjList = adj;
	        dfs(root, 0);
	        int m = euler.size();
	        segtree = new int[m * 4];
	        build(1, 0, m - 1);
	    }
	    
	    void dfs(int node, int h) {
	        visited[node] = true;
	        height[node] = h;
	        first[node] = euler.size();
	        euler.add(node);
	        for (int child : adjList.get(node)) {
	            if (!visited[child]) {
	                dfs(child, h + 1);
	                euler.add(node);
	            }
	        }
	    }
	    
	    void build(int node, int b, int e) {
	        if (b == e) {
	            segtree[node] = euler.get(b);
	        } else {
	            int mid = (b + e) / 2;
	            build(node << 1, b, mid);
	            build(node << 1 | 1, mid + 1, e);
	            int l = segtree[node << 1], r = segtree[node << 1 | 1];
	            segtree[node] = (height[l] < height[r]) ? l : r;
	        }
	    }
	    
	    int query(int node, int b, int e, int L, int R) {
	        if (b > R || e < L)
	            return -1;
	        if (b >= L && e <= R)
	            return segtree[node];
	        int mid = (b + e) >> 1;

	        int left = query(node << 1, b, mid, L, R);
	        int right = query(node << 1 | 1, mid + 1, e, L, R);
	        if (left == -1) return right;
	        if (right == -1) return left;
	        return height[left] < height[right] ? left : right;
	    }
	    
	    int lca(int u, int v) {
	        int left = first[u], right = first[v];
	        if (left > right) {
	        	int t = right;
	        	right = left;
	        	left = t;
	        }
	        return query(1, 0, euler.size() - 1, left, right);
	    }
	}
	
	static class segt {
        long[] t;
        int N;
        public segt(int n) {
            t = new long[4*n];
            N = n;
        }
        
        void build(long a[]) {
        	build(a, 1, 0, N-1);
        }
        
        void build(long a[], int v, int tl, int tr) {
            if (tl == tr) {
                t[v] = a[tl];
            } else {
                int tm = (tl + tr) / 2;
                build(a, v*2, tl, tm);
                build(a, v*2+1, tm+1, tr);
                t[v] = Math.min(t[v*2], t[v*2+1]);
            }
        }
        
        long queryMin(int l, int r) {
        	return queryMin(1, 0, N-1, l, r);
        }
 
        long queryMin(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return Integer.MAX_VALUE/2;
            if (l == tl && r == tr)
                return t[v];
            int tm = (tl + tr) / 2;
            return Math.min(queryMin(v*2, tl, tm, l, Math.min(r, tm)),
                    queryMin(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }
        
        void update(int pos, int new_val) {
        	update(1, 0, N-1, pos, new_val);
        }
 
        void update(int v, int tl, int tr, int pos, long new_val) {
            if (tl == tr) {
                t[v] = new_val;
            } else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v*2, tl, tm, pos, new_val);
                else
                    update(v*2+1, tm+1, tr, pos, new_val);
                t[v] = Math.min(t[v*2], t[v*2+1]);
            }
        }
    }
}
