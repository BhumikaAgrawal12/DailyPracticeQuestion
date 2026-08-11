class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int[] ans=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        int[] inD=new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            inD[u]++;
            adj.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inD[i]==0){
                q.offer(i);
            }
        }
        int indx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[indx++]=node;
            for(int nbr:adj.get(node)){
                inD[nbr]--;
                if(inD[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        if(indx!=V){
            return new int[]{};
        }
        return ans;
    }
    
}