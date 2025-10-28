class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        ArrayDeque<Integer>st=new ArrayDeque<>();
        for(int i=2*n;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.peek();
                }
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
}