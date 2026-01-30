class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[n-1],n-1});
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            while(!pq.isEmpty() && pq.peek()[1]>i+k){
                pq.poll();
            }
            dp[i]=nums[i]+pq.peek()[0];
            pq.add(new int[]{dp[i],i});
        }
        return dp[0];
    }
}