class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int remove=0;
        int[] prev=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(prev[1] >intervals[i][0]){
                remove++;
                if(intervals[i][1] < prev[1]){
                    prev = intervals[i];
                }
            }

            else{
                prev=intervals[i];
            }
        }
        return remove;
    }
}