class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=grid[i][j];
            }
        }
        int[] arr=new int[k*k];
        int indx=0;
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                arr[indx++]=grid[i][j];
            }
        }
        indx = 0;
        for (int i = x + k - 1; i >= x; i--) {
            for (int j = y; j < y + k; j++) {
                ans[i][j] = arr[indx++];
            }
        }

        return ans;
    }
}