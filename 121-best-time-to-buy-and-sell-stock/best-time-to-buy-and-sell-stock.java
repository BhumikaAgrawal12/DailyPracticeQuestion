class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,prices[i]-min);
            if(prices[i]<min){
                min=prices[i];
            }
            
        }
        return maxProfit;
    }
}