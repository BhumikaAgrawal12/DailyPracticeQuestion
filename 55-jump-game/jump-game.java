class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        int i=0;
        while(i<=max){
            max=Math.max(max,i+nums[i]);
            if(max>=n-1){
                return true;
            }
            i++;
        }
        return false;
    }
}