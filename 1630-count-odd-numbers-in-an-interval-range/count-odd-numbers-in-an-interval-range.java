class Solution {
    public int countOdds(int low, int high) {
        // int cnt=0;
        // for(int i=low;i<=high;i++){
        //     if(i%2!=0){
        //         cnt++;
        //     }
        // }
        // return cnt;

        int c=0;
        int i=low;
        if(i%2==0){
            i=i+1;
        }
        while(i<=high){
            c++;
            i+=2;
        }
        return c;
    }
}