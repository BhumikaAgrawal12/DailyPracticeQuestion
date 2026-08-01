class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>(); 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int t=curr[2];
            time=Math.max(time,t);
            for(int[] d:dir){
                int cr=d[0]+row;
                int cc=d[1]+col;
                if(cr>=0 && cr<m && cc>=0 && cc<n && grid[cr][cc]==1){
                    grid[cr][cc]=2;
                    fresh--;
                    q.add(new int[]{cr,cc,t+1});
                }
            }
        }
        return fresh==0?time:-1;
    }
}