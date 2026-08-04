class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(vis,i,adj);
            }
        }
        return cnt;
    }
    void dfs(boolean[] vis,int node,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int nbr:adj.get(node)){
            if(!vis[nbr]){
                dfs(vis,nbr,adj);
            }
        }
    }
}