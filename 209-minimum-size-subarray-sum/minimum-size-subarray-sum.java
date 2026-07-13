class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int len=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                len=j-i+1;
                minLen=Math.min(minLen,len);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}