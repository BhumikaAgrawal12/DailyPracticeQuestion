class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findProfit(prices,dp,0,1);//{0=start,1=canBuy}
        
    }
    int findProfit(int[] prices,int[][] dp,int idx,int canBuy){
        if(idx>prices.length-1){
            return 0;
        }
        if(dp[idx][canBuy]!=-1){
            return dp[idx][canBuy];
        }
        int profit=0;
        if(canBuy==1){
            int buy=-prices[idx]+findProfit(prices,dp,idx+1,0);
            int skip=findProfit(prices,dp,idx+1,1);
            profit=Math.max(buy,skip);
        }
        else{
            int sell=prices[idx]+findProfit(prices,dp,idx+2,1);
            int hold=findProfit(prices,dp,idx+1,0);
             profit=Math.max(sell,hold);
        }
        return dp[idx][canBuy]=profit;

    }
}