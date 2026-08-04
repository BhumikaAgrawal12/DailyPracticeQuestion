class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( !vis[i][j] && grid[i][j]=='1'){
                    cnt++;
                    dfs(vis,grid,i,j,n,m);
                }
            }
        }
        return cnt;
    }
    void dfs(boolean[][] vis,char[][] grid,int cr,int cc,int n,int m){
        if(cr<0 || cc<0 || cr>=m || cc>=n || vis[cr][cc] || grid[cr][cc]=='0'){
            return ;
        }
        vis[cr][cc]=true;
        dfs(vis,grid,cr+1,cc,n,m);
        dfs(vis,grid,cr-1,cc,n,m);
        dfs(vis,grid,cr,cc+1,n,m);
        dfs(vis,grid,cr,cc-1,n,m);
    }
}