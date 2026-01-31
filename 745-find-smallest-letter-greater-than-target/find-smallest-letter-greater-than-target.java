class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min=Integer.MAX_VALUE;
        int n=letters.length;
        char ans=letters[0];
        for(int i=0;i<n;i++){
            char ch=letters[i];
            if(ch>target && ch-target<min){
                min=ch-target;
                ans=ch;
            }
        }
        return ans;
    }
}