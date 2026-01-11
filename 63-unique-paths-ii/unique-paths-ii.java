class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return sol(obstacleGrid,m,n,0,0,dp);
    }
    int sol(int[][] obstacleGrid,int er,int ec,int cr,int cc,int[][] dp){
        if(cr>=er || cc>=ec || obstacleGrid[cr][cc]==1){
            return 0;
        }
        if(cr==er-1 && cc==ec-1){
            return 1;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        
        int right=sol(obstacleGrid,er,ec,cr+1,cc,dp);
        int bottom =sol(obstacleGrid,er,ec,cr,cc+1,dp);
        dp[cr][cc]=right+bottom;
        return dp[cr][cc];
    }
}