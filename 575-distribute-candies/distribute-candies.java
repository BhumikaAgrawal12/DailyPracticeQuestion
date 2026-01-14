class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<candyType.length;i++){
            set.add(candyType[i]);
        }
        int hlf=n/2;
        return Math.min(hlf,set.size());
    }
}