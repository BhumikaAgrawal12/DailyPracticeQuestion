class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int indx=0;
        while(indx<n){
            int i=0;
            if(nums[indx]>0){
                res[indx]=nums[(indx+nums[indx])%n];
            }
            else if(nums[indx]<0){
                i=indx-(Math.abs(nums[indx]))%n;
                if(i<0){
                    i=i+n;
                }
                res[indx]=nums[i];
            }
            else{
                res[indx]=0;
            }
            indx++;
        }
        return res;
    }
}