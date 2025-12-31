class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Using dijkstra algo direct
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});//directed graph
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            int u=val[0];
            int w=val[1];
            if(w>dist[u]) continue;
            for(int[] nbr:adj.get(u)){
                int v=nbr[0];
                int wt=nbr[1];
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dist[i]);
            
        }
        return ans;
    }
}