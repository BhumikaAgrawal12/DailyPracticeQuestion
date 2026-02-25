class Solution {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int cnt=Integer.bitCount(arr[i]);
            if(!list.contains(cnt)){
                list.add(cnt);
            }
        }
        Collections.sort(list);
        int[] ans=new int[arr.length];
        int indx=0;
        for(int i=0;i<list.size();i++){
            int bit=list.get(i);
             ArrayList<Integer> temp = new ArrayList<>();
           
            for (int j = 0; j < arr.length; j++) {
                if (Integer.bitCount(arr[j]) == bit) {
                    temp.add(arr[j]);
                }
            }
        
            Collections.sort(temp);
            for (int num : temp) {
                ans[indx++] = num;
            }
        }
        
        return ans;
    }
}