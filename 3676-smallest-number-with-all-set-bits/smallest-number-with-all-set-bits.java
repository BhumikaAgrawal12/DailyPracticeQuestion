class Solution {
    public int smallestNumber(int n) {
        int k=1;
        int ans=0;
        while(true){
            ans=(int)Math.pow(2,k)-1;
            if(ans>=n){
                break;
            }
            k++;
        }
        return ans;
    }
}