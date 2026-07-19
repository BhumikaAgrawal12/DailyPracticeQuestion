class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n=intervals.length;
        int[][] res=new int[n][2];
        int[] prev=intervals[0];
        int indx=0;
        for(int[] curr:intervals){
            if(prev[1]>=curr[0]){
                prev[1]=Math.max(prev[1],curr[1]);
            }
            else{
                res[indx++]=prev;
                prev=curr;
            }
        }
       res[indx++]=prev;
        return Arrays.copyOf(res,indx);
    }
}