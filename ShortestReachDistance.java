import java.io.*;
import java.util.*;

class Graph{
    List<List<Integer>> neighbors;
    int size;
    public Graph(int size){
        neighbors = new ArrayList<>();
        this.size = size;
        while(size > 0){
            neighbors.add(new ArrayList<Integer>());
            size--;
        }
    }
    
    public void addEdge(int start, int end){
        neighbors.get(start-1).add(end-1);
        neighbors.get(end-1).add(start-1);
    }
    
    public int[] getShortestPath(int startId){
        Queue<Integer> q = new LinkedList<>();
        q.add(startId);
        
        int distances[] = new int[size];
        Arrays.fill(distances, -1);
        distances[startId] = 0;
        
        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int neighbor: neighbors.get(currNode)){
                if(distances[neighbor] == -1){
                    distances[neighbor] = distances[currNode] + 6;
                    q.add(neighbor);
                }
            }
        }
        
        return distances;
    }
}
public class ShortestReachDistance {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++){
            int nodes = sc.nextInt();
            Graph g = new Graph(nodes);
            int edges = sc.nextInt();
            
            for(int j=0;j<edges;j++){
                g.addEdge(sc.nextInt(), sc.nextInt());
            }
            
            int startNode = sc.nextInt();
            
            int[] ans = g.getShortestPath(startNode-1);
            
            System.out.println();
            for(int k=0;k<ans.length;k++){
            	if(k!=startNode-1)
            		System.out.print(ans[k] + " ");
            }
        }
    }
}
