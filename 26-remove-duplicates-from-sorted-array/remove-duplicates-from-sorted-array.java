class Solution {
    public int removeDuplicates(int[] nums) {
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>max){
        //         max=nums[i];
        //     }
        // }
        // int[] count=new int[max+1];
        // for(int i=0;i<nums.length;i++){
        //     count[nums[i]]++;
        // }
        // int c=0;
        // for(int i=0;i<count.length;i++){
        //     if(count[i]>=1){
        //         nums[c]=i;
        //         c++;
        //     }
        // }
        // return c;

        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
        
    }
}