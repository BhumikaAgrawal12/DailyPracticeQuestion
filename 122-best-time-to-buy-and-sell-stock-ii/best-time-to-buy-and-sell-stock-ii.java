class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            else{
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
                sum+=maxProfit;
                maxProfit=0;
                minPrice=prices[i];
            }
        }
        return sum;
    }
}