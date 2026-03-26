class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] ans=new int[n-k+1];
        int indx=0;
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        ans[indx++]=pq.peek()[0];
        for(int i=k;i<n;i++){
            pq.add(new int[]{nums[i],i});
            while(!pq.isEmpty() && pq.peek()[1]<=i-k){
                pq.poll();
            }
            ans[indx++]=pq.peek()[0];
        }
        return ans;
    }
}