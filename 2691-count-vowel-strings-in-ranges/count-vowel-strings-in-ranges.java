class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        int[] prefix=new int[words.length];
        int i=0;
        for(String s:words){
            boolean isValid=isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1));
            if(i==0){
                prefix[i]=isValid?1:0;
            }
            else{
                prefix[i]=prefix[i-1]+(isValid?1:0);
            }
            i++;
        }
        int indx=0;
        for(int[] query:queries){
            int l=query[0];
            int r=query[1];
            if(l==0){
                ans[indx++]=prefix[r];
            }
            else{
                ans[indx++]=prefix[r]-prefix[l-1];
            }
        }
        return ans;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}