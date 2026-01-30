class Solution {
    public long perfectPairs(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++) if(nums[i]<0) nums[i]*=-1;
        Arrays.sort(nums);
        int j=0;
        for(int i=0;i<n;i++){
            while(j<n&&nums[j]<=2*nums[i]) j++;
            ans+=(j-1-i);
        }
        return ans;
    }
}