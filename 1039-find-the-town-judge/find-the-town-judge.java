class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] freq=new int[n+1];
        for(int[] edge:trust){
            int a=edge[0];
            int b=edge[1];
            freq[a]--;
            freq[b]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==n-1){
                return i;
            }
        }
        
       return -1;
    }
}
//T.C.=0(n)
//s.c.=O(n)