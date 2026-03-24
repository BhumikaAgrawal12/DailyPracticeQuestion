class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int size=m*n;
       int mod=12345;
       int[] arr=new int[size];
       int indx=0;
       for(int i=0;i<m;i++) {
        for(int j=0;j<n;j++){
            arr[indx++]=grid[i][j]%mod;
        }
       }
       int[] prefix=new int[size];
       int[] suffix=new int[size];

       prefix[0]=1;
       for(int i=1;i<size;i++){
        prefix[i]=(prefix[i-1]*arr[i-1])%mod;
       }

       suffix[size-1]=1;
       for(int i=size-2;i>=0;i--){
        suffix[i]=(suffix[i+1]*arr[i+1])%mod;
       }

       int[][] p=new int[m][n];
       indx=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            p[i][j]=(prefix[indx]*suffix[indx])%mod;
            indx++;
        }
       }
       return p;
    }
}