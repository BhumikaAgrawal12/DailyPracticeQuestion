class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int orig=image[sr][sc];
        if(orig==color){
            return image;
        }
        dfs(sr,sc,m,n,color,image,orig);
        return image;
    }
    void dfs(int cr,int cc,int m,int n,int color,int[][] img,int orig){
        if(cr<0||cc<0||cr>=m||cc>=n||img[cr][cc]!=orig){
            return;
        }
        img[cr][cc]=color;
        dfs(cr+1,cc,m,n,color,img,orig);
        dfs(cr-1,cc,m,n,color,img,orig);
        dfs(cr,cc+1,m,n,color,img,orig);
        dfs(cr,cc-1,m,n,color,img,orig);
    }
}