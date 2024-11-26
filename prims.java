import java.util.*;
public class Qsix {
    static class Edge{
        int node,weight;
        Edge(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public static int PrimsMst(int n , List<List<Edge>> graph){
        int TotalCost=0;
        boolean[] vis=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0,0});


        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int weight=curr[1];
            if (vis[node]){
                continue;
            }
            vis[node] = true;
            TotalCost+=weight;

            for (Edge neighbor: graph.get(node)){
                if(!vis[neighbor.node]){
                    pq.add(new int[]{neighbor.node, neighbor.weight});
                }
            }
        }




        return TotalCost;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1,1));
        graph.get(0).add(new Edge(3,5));
        graph.get(0).add(new Edge(2,2));
        graph.get(1).add(new Edge(2,3));
        graph.get(1).add(new Edge(0,1));
        graph.get(2).add(new Edge(0,2));
        graph.get(2).add(new Edge(4,8));
        graph.get(2).add(new Edge(2,3));
        graph.get(3).add(new Edge(0,5));
//        graph.get(3).add(new Edge(4,7));
//        graph.get(4).add(new Edge(3,7));
        graph.get(4).add(new Edge(2,8));
        int totalcost=PrimsMst(5,graph);
        System.out.println(totalcost);
    }
}
