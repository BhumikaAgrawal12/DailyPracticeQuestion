class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( !vis[i][j] && grid[i][j]==1){
                    
                    max=Math.max(max,dfs(vis,grid,i,j,n,m));
                }
            }
        }
        return max;
    }
    int dfs(boolean[][] vis,int[][] grid,int cr,int cc,int n,int m){
        if(cr<0 || cc<0 || cr>=m || cc>=n || vis[cr][cc] || grid[cr][cc]==0){
            return 0;
        }
        vis[cr][cc]=true;
        int area=1;

        area+=dfs(vis,grid,cr+1,cc,n,m);
        area+=dfs(vis,grid,cr-1,cc,n,m);
        area+=dfs(vis,grid,cr,cc+1,n,m);
        area+=dfs(vis,grid,cr,cc-1,n,m);
        return area;
    }
}
    