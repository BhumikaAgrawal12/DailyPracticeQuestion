class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        int ans=0;
        ans+=nums[0];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<n;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        ans+=list.get(0);
        ans+=list.get(1);
        return ans;
    }
}