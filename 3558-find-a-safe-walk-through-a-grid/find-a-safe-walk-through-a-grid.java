class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.size(),m=grid.get(0).size();
        int[][] vis=new int[n][m];
        for(int[] a:vis) Arrays.fill(a,Integer.MAX_VALUE);
        vis[0][0]=grid.get(0).get(0);
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair x=q.poll();
            int h=x.val+grid.get(x.r).get(x.c),r=x.r,c=x.c;
            if(r==n-1 && c==m-1 && h<health) return true;
            for(int[] a:dir){
                int nr=r+a[0],nc=c+a[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(h<vis[nr][nc]){
                        vis[nr][nc]=h;
                        q.add(new Pair(vis[nr][nc],nr,nc));
                    }
                }
            }
        }
        return false;
    }
}
class Pair{
    int val,r,c;
    Pair(int val,int r,int c){
        this.val=val;
        this.r=r;
        this.c=c;
    }
}