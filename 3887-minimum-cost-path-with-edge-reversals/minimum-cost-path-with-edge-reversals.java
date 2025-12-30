class Solution {
    public int minCost(int n, int[][] edges) {
        int[] indeg=new int[n];
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]*2});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int d=curr[0];int u=curr[1];
            if(d>dist[u]) continue;
            if(u==n-1) return d;
            for(int[] edge:adj.get(u)){
                int v=edge[0],w=edge[1];
                if(dist[v]>d+w){
                    dist[v]=d+w;
                    q.offer(new int[]{dist[v],v});
                }
            }
        }
        return -1;
    }
}