class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx=new Integer[n];
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

// nums = [6, 1, 10, 3]
// index = [0, 1, 2, 3]

// Sort by value:
// value : 1   3   6   10
// index : 1   3   0   2

        UnionFind uf=new UnionFind(n);
        for (int i = 1; i < n; i++) {
            if (nums[idx[i]] - nums[idx[i - 1]] <= maxDiff) {
                uf.Union(idx[i], idx[i - 1]);
            }
        }
        int i=0;
        for(int[] query:queries){
            int parent_u=uf.find(query[0]);
            int parent_v=uf.find(query[1]);
            if(parent_u==parent_v){
                ans[i]=true;
            }
            else{
                ans[i]=false;
            }
            i++;
        }
        return ans;
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