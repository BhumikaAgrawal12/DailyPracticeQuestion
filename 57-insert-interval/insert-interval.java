class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> res=new ArrayList<>();
        
        for(int[] slot:intervals){
            if(slot[0]>newInterval[1]){
                res.add(newInterval);
                newInterval=slot;
            }
            else if(slot[1]<newInterval[0]){
                res.add(slot);
            }
            else{
                newInterval[0]=Math.min(slot[0],newInterval[0]);
                newInterval[1]=Math.max(slot[1],newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}