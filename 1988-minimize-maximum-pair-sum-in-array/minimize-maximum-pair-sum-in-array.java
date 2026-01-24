class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=0;
        int s=0;
        int e=n-1;
        while(s<e){
            max=Math.max(max,nums[s]+nums[e]);
            s++;
            e--;
        }
        return max;
    }
}