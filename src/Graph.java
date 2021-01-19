import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for( int i = 0; i < v; i++) adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v){
        adj[v].add(u);
        adj[u].add(v);
    }

    void printAdjList(){
        for(int i=0; i<adj.length; i++){
            System.out.print(i + " :" );
            Iterator j = adj[i].iterator();
            while (j.hasNext()){
                System.out.print(" -> "+j.next());
            }
            System.out.println();
        }
    }

    void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean visited [] = new boolean[adj.length];
        Arrays.fill(visited, false);
        visited[start] = true;
        System.out.print("BFS: ");
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v+"\t");
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()){
                int j = i.next();
                if(!visited[j]){
                    visited[j] = true;
                    q.add(j);
                }
            }

        }
//        for(int a = 0 ;a<visited.length;a++){
//            System.out.println(visited[a]);
//        }
    }

    void dfs(int start){
        boolean visited [] = new boolean[adj.length];
        dfsUtil(start, visited);
    }

    void dfsUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v+" -> ");
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()){
            v = i.next();
            if (!visited[v]){
                dfsUtil(v, visited);
            }
        }
    }

    public static void main(String [] args){
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge( 2, 3);
        g.addEdge(3, 4);
        g.printAdjList();
        System.out.println();
        g.bfs(1);
        System.out.println();
        g.dfs(1);
    }
}
