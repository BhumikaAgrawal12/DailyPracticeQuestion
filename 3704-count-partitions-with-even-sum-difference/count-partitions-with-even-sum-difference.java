class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int c=0;
        int ans=0;
        int a=0;
        for(int i=0;i<n-1;i++){
            ans+=nums[i];
            a=sum-ans;
            if(Math.abs(a-ans)%2==0){
                c++;
            }

        }
        return c;
    }
}