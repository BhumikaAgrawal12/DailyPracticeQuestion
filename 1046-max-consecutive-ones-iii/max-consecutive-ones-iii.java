class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int zeroes=0;
        int max=0;
        int size=0;
        int i=0;
        int j=0;
        while(j<n){
            if(nums[j]==0){
                zeroes++;
            }
            while(zeroes>k){
                if(nums[i]==0){
                    zeroes--;
                }
                i++;
            }
            size=j-i+1;
            max=Math.max(max,size);
            j++;
        }
        return max;
    }
}