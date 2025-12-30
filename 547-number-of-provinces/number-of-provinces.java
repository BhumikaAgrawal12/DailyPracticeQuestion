class Solution {
    private void dfs(int[][] isConnected,int j,boolean[] visited)
    {
        visited[j] = true;
         for(int m=0;m<isConnected[j].length;m++)
         {
            if(isConnected[j][m] == 1 && !visited[m])//base condition
            {
                dfs(isConnected,m,visited);
            }
         }

    }
    
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i =0;i<isConnected.length;i++)
        {
            if(!visited[i])//visited== false
           { 
                count++;
                dfs(isConnected,i,visited);
           }
        }
        return count;
    }
}