class Solution {
    public int edgeScore(int[] edges) {
      HashMap<Integer,Long>map=new HashMap<>();
      for(int i=0;i<edges.length;i++){
        if(!map.containsKey(edges[i])){
            map.put(edges[i],(long)i);
        }
        else{
            map.put(edges[i],map.get(edges[i])+(long)i);
        }
      }  
     // List<List<Integer>>list=new ArrayList<>(map.keySet());

      long maxScore=0;
      int ans=Integer.MAX_VALUE;
      for(Map.Entry<Integer,Long>entry:map.entrySet()){
        if(entry.getValue()>maxScore){
            maxScore=entry.getValue();
        }
      }
      //return maxScore;
      for(Map.Entry<Integer,Long>entry:map.entrySet()){
        if(entry.getValue()==maxScore){
            ans=Math.min(entry.getKey(),ans);
        }
      }
      return ans;
    

    }
}