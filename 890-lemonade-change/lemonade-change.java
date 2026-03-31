class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int five=0;
        int ten=0;
        // int twenty=0;
        // int sum=0
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10 && five>0){
                five--;
                ten++;
            }
            else if(bills[i]==20){
                if(five>0 && ten>0) {
                 five--;
                 ten--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        }
        return true;
    }
}