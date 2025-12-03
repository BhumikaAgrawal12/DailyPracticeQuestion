class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
        for(int num:nums){
            int indx=Math.abs(num)-1;
            if(nums[indx]>0){
                nums[indx]=-nums[indx];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}