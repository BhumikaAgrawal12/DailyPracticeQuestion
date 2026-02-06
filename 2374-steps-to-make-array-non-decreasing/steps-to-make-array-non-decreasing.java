class Solution {
    public int totalSteps(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i= n-1;i>=0;i--){
            int cnt=0;
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                cnt=Math.max(cnt+1,dp[st.peek()]);
                st.pop();
            }
            dp[i]=cnt;
            ans=Math.max(ans,dp[i]);
            st.push(i);
        }
        return ans;

    }
}