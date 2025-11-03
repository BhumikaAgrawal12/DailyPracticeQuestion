class Solution {
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int n=s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[] dp=new int[n+1];
        for(int i=1;i<=m;i++){
            int[] temp=new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    temp[j]=dp[j-1]+1;
                }
                else{
                    temp[j]=Math.max(dp[j],temp[j-1]);
                }
            }
            dp=temp;
        }
        
        return dp[n];
    }
}