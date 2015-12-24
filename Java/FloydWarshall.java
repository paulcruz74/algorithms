public class FloydWarshall{
	/**
 * FLoyd Warshall for shortest distance from every node to every other
 * @param in adjacency matrix
 */
public void floydWarshall(int[][] in){
	for(int k=0;k<in.length;k++)for(int i=0;i<in.length;i++)for(int j=0;j<in.length;j++)in[i][j]=Math.min(in[i][j], in[i][k]+in[k][j]);
}
/**
 * Floyd Warshall with path recovery
 * @param in adjacency matrix
 * @return the next node on the path from i to j...just iterate over it until [i][j]=j
 */
public int[][] floydWarshallwPath(int[][] in){
	int[][] next=new int[in.length][in.length];
	for(int i=0;i<in.length;i++)for(int j=0;j<in.length;j++)if(in[i][j]<Integer.MAX_VALUE)next[i][j]=j;
	for(int k=0;k<in.length;k++)for(int i=0;i<in.length;i++)for(int j=0;j<in.length;j++)if(in[i][k]+in[k][j]<in[i][j]){
		in[i][j]=in[i][k]+in[k][j];
		next[i][j]=next[i][k];		
	}
	return next;
}
}