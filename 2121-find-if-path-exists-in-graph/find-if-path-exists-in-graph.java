class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited=new int[n];
        return BFS(adj,visited,source,destination);
    }
    public static boolean BFS(ArrayList<List<Integer>>adj,int[] visited,int node,int dest){
        Queue<Integer>q=new LinkedList<>();
        q.offer(node);
        visited[node]=1;
        while(!q.isEmpty()){
            int front_node=q.poll();
            if(front_node==dest){
                return true;
            }
            for(int nbr:adj.get(front_node)){
                if(visited[nbr]==0){
                    q.offer(nbr);
                    visited[nbr]=1;
                }
            }
            
        }
        return false;
    }
}