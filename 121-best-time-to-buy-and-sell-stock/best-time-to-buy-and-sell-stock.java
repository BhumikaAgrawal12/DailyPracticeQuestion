class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int price:prices){
            if(price<min){
                min=price;
            }
            else{
                maxProfit=Math.max(maxProfit,price-min);
            }
        }
        return maxProfit;
    }
}



//BRUTE FORCE(TLE)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int max=Integer.MIN_VALUE;;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                if(prices[j]>prices[i]){
//                     max=Math.max(max,prices[j]-prices[i]);
//                }
//             }
//         }
//         if(max==Integer.MIN_VALUE){
//             return 0;
//         }
//         return max;
//     }
// }