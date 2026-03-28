class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int[][] res=new int[n][2];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] prev=intervals[0];
        int idx=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=prev[1]){
                prev[1]=Math.max(intervals[i][1],prev[1]);
            }
            else{
                res[idx++]=prev;
                prev=intervals[i];
            }
        }
        res[idx++]=prev;
        return Arrays.copyOf(res,idx);
    }
}