class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        for(List<Integer>list:edges){
            set.add(list.get(1));
        }
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}