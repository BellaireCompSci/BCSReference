package algorithms;

import java.util.*;

public class Dijkstras {
	static class Node implements Comparator<Node> { 
	    public int node; 
	    public long cost; 
	  
	    public Node(int node, long cost) 
	    { 
	        this.node = node; 
	        this.cost = cost; 
	    } 
	  
	    public Node() {
		}

		@Override
	    public int compare(Node node1, Node node2) 
	    { 
	        if (node1.cost < node2.cost) 
	            return -1; 
	        if (node1.cost > node2.cost) 
	            return 1; 
	        return 0;
	    } 
		public String toString() {
			return node + " " + cost;
		}
	} 
	
	static class djikstras { 
	    private long dist[]; 
	    private int[] parent;
	    private Set<Integer> settled; 
	    private PriorityQueue<Node> pq; 
	    private int V;
	  
	    public djikstras(int V) 
	    { 
	        this.V = V; 
	        dist = new long[V]; 
	        parent = new int[V];
	        settled = new HashSet<Integer>(); 
	        pq = new PriorityQueue<Node>(V, new Node()); 
	    } 
	  
	    public void run(List<List<Node>> adj, int src) 
	    { 	  
	    	Arrays.fill(dist, Integer.MAX_VALUE);
	    	Arrays.fill(parent, Integer.MAX_VALUE);
	        pq.add(new Node(src, 0)); 
	        dist[src] = 0; 
	        parent[src] = -1;
	        
	        while (settled.size() != V-1 && pq.size() > 0) {
	            int u = pq.remove().node; 
	            if(!settled.contains(u)) {
	            settled.add(u);
			        // All the neighbors of v 
			        for (int i = 0; i < adj.get(u).size(); i++) { 
			            Node v = adj.get(u).get(i); 
			            
			            if (!settled.contains(v.node)) {
			                if (dist[u] + v.cost < dist[v.node]) {
			                    dist[v.node] = dist[u] + v.cost; 
			                    parent[v.node] = u; // when there are two possible parents, choose the one of lesser value
			                    pq.add(new Node(v.node, dist[v.node])); 
			                }
			            }
			        }
	            }
	        }
	    }
	}
}
