class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        if(isEqual(mat,target)){
            return true;
        }
        for(int i=0;i<4;i++){
            if(rotate(mat,target)){
                return true;
            }
        }
        return false;
    }
    public boolean isEqual(int[][] mat, int[][] target){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean rotate(int[][] mat, int[][] target){
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        int s=0;
        int e=n-1;
        while(s<e){
            for(int i=0;i<n;i++){
                int temp=mat[i][s];
                mat[i][s]=mat[i][e];
                mat[i][e]=temp;
            }
            s++;
            e--;
        }
        if(isEqual(mat,target)){
            return true;
        }
        return false;
    }
}