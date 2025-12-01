//dfs 
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
        return dfs(adj,visited,source,destination);
    }
    boolean dfs(ArrayList<List<Integer>>adj,int[] visited,int node,int dest){
        if(node==dest){
            return true;
        }
        visited[node]=1;
        for(int nbr:adj.get(node)){
            if(visited[nbr]==0){
                if(dfs(adj,visited,nbr,dest)){
                    return true;
                }
            }
        }
        return false;
    }
}