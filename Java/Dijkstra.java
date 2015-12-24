import java.io.*;
import java.util.*;
public class Dijkstra{
	/**
 * Dijkstra:finds the shortest path in weighted graph
 * @param r start node
 * @param in adjacency list
 * @return distance to each node from start node
 */
public int[] dijkstra1(int r,ArrayList<HashMap<Integer,Integer>> in){
	final int[] out=new int[in.size()],prev=new int[in.size()];
	TreeSet<Integer> pq=new TreeSet<Integer>(new Comparator<Integer>(){
		public int compare(Integer i0, Integer i1) {
			if(out[i0]!=out[i1])return Double.compare(out[i0],out[i1]);
			return i0-i1;
		}
	});
	Arrays.fill(out, Integer.MAX_VALUE/2);
	out[r]=0;
	prev[r]=-1;
	pq.add(r);
	while(!pq.isEmpty()){
		int t=pq.first();
		pq.remove(pq.first());
		for(int i:in.get(t).keySet())if(out[t]+in.get(t).get(i)<out[i]){
			pq.remove(i);
			out[i]=out[t]+in.get(t).get(i);
			prev[i]=t;
			pq.add(i);
		}
	}
	return out;//note you can also return previous here if you like....or some combination of the two
}
/**
 * shortest path from r to all points
 * @param r the start node
 * @param in the adjacency matrix
 * @return the length of the path from r to each node
 */
public int[] dijkstra2(int r,int[][] in){
	final int[] out=new int[in.length],prev=new int[in.length];
	TreeSet<Integer> pq=new TreeSet<Integer>(new Comparator<Integer>(){
		public int compare(Integer i0, Integer i1) {
			if(out[i0]!=out[i1])return Double.compare(out[i0],out[i1]);
			return i0-i1;
		}
	});
	Arrays.fill(out, Integer.MAX_VALUE/2);
	out[r]=0;
	prev[r]=-1;
	pq.add(r);
	while(!pq.isEmpty()){
		int t=pq.first();
		pq.remove(pq.first());
		for(int i=0;i<in.length;i++)if(out[t]+in[t][i]<out[i]){
			pq.remove(i);
			out[i]=out[t]+in[t][i];
			prev[i]=t;
			pq.add(i);
		}
	}
	return out;//note you can also return previous here if you like....or some combination of the two
}
}