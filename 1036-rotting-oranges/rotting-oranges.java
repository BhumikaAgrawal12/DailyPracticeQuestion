class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int t=curr[2];
            time=Math.max(time,t);
            for(int[] dir:direction){
                int rc=dir[0]+r;
                int cr=dir[1]+c;
                if(rc>=0 && rc<m && cr>=0 && cr<n && grid[rc][cr]==1){
                    grid[rc][cr]=2;
                    fresh--;
                    q.offer(new int[]{rc,cr,t+1});
                }
            }
        }
        return fresh==0?time:-1;
    }
}