class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf=new UnionFind(n);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            uf.Union(u,v);
        }
        return uf.find(source)==uf.find(destination);
    }
}
class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int V){
        parent=new int[V+1];
        rank=new int[V+1];
        for(int i=0;i<=V;i++){
            parent[i]=i;
        }
    }
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return find(parent[node]);
    }
    boolean Union(int u,int v){
        int parent_u=find(u);
        int parent_v=find(v);
        if(parent_u==parent_v){
            return false;
        }
        if(rank[parent_u]>rank[parent_v]){
            parent[parent_v]=parent_u;
        }
        else if(rank[parent_v]>rank[parent_u]){
            parent[parent_u]=parent_v;
        }
        else{
            parent[parent_u]=parent_v;
            rank[parent_v]++;
        }
        return true;
    }
    
}