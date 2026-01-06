class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Queue<Integer>q=new LinkedList<>();
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                color[i]=0;
                q.offer(i);
            }
            while(!q.isEmpty()){
                int node=q.poll();
                for(int nbr:graph[node]){
                    if(color[nbr]==-1){
                        color[nbr]=1-color[node];
                        q.offer(nbr);
                    }
                    else if(color[node]==color[nbr]){
                        return false;
                    }
                }
            }

        }
        return true;
    }
}