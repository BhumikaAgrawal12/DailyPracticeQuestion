class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int min=prices[0];
        int maxProfit=0;
        int sum=0;
        for(int i=1;i<n;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else{
                maxProfit=Math.max(maxProfit,prices[i]-min);
                sum+=maxProfit;
                maxProfit=0;
                min=prices[i];
            }
        }
        return sum;
    }
}