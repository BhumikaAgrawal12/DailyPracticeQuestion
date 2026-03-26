class Solution {
   public int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }
   //This funcn  is calculating total subarray with sum<=goal
    public int func(int[] nums,int k){
        int i=0;
        int j=0;
        int sum=0;
        int cnt=0;
        while(j<nums.length){
            sum+=(nums[j]%2);
            while(i<=j && sum>k){
                sum-=(nums[i]%2);
                i++;
            }
            cnt=cnt+(j-i+1);//total subarrays that can be form within i to j with sum<=k
            j++;
        }
        return cnt;
    }
}