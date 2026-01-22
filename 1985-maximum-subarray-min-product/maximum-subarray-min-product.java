class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        long[] prefixSum=new long[n+1];
        for(int i=1;i<=n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        int[] pse=new int[n];
        int[] nse=new int[n];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,n);
        ArrayDeque<Integer>st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i]=st.peek();
            }
            st.push(i);
        }
        long mod=(int)1e9+7;
        long max=0;
        for(int i=0;i<n;i++){
            int left=pse[i];
            int right=nse[i];
            long sum=prefixSum[right]-prefixSum[left+1];
            long prod=nums[i]*sum;
            max=Math.max(max,prod);
            
        }
        return (int)(max%mod);
    }
}