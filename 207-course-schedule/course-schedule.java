class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] inD=new int[V];
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            inD[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inD[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int nbr:adj.get(node)){
                inD[nbr]--;
                if(inD[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        return ans.size()==V;
    }
}