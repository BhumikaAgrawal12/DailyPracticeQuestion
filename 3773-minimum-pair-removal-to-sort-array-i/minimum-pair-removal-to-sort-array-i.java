class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nums[i]);
        } 
        
        int ans=0;
        while(!isSorted(list)){
            int minSum=Integer.MAX_VALUE;
            int indx=0;
            for(int i=0;i<list.size()-1;i++){
                if(minSum>list.get(i)+list.get(i+1)){
                    minSum=list.get(i)+list.get(i+1);
                    indx=i;
                }
            }
            list.set(indx,minSum);
            list.remove(indx+1);
            ans++;
        }
        return ans;
    }
    public boolean isSorted(ArrayList<Integer> list){
        int n=list.size();
        int a=0;
        for(int i=0;i<n-1;i++){
            if(list.get(i+1)<list.get(i)){
                return false;
            }
        }
        return true;
    }
}