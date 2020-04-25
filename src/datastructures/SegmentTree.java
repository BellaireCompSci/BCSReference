package datastructures;

public class SegmentTree {
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
        
        long queryMin(int l, int r) { // update to find min, max, sum, XOR, etc.
        	return queryMin(1, 0, N-1, l, r);
        }
 
        long queryMin(int v, int tl, int tr, int l, int r) { // update to find min, max, sum, XOR, etc.
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
