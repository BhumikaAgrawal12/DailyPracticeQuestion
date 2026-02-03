class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int peak=0;
        if(nums[0]>nums[1]){
            return false;
        }
        for(int i=1;i<n-1;i++){ 
            if(nums[i-1]==nums[i] || nums[i]==nums[i+1]){
                return false;
            }  
            if(nums[i-1]<nums[i] && nums[i+1]<nums[i]){
                peak++;
            }
            
            
        }
        if(peak==1 && nums[n-1]>nums[n-2]){
                peak++;
                return true;
        }
        // if(peak==2){
        //     return true;
        // }
        return false;
    }
}