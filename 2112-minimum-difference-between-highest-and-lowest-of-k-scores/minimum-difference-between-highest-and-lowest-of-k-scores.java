class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        int minDiff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<=n-k;i++){
            minDiff=Math.min(minDiff,nums[i-1+k]-nums[i]);
        }
        return minDiff;
    }
}