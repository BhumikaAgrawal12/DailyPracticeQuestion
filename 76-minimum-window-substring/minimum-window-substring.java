class Solution {
    public String minWindow(String s, String t) {
        String str="";
        if(t.length()>s.length()){
            return str;
        }
        if(s.equals(t)){
            return s;
        }
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int start=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int count=0;
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)]>0){
                count++;
            }
            freq[s.charAt(right)]--;
            while(count==t.length()){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0){
                    count--;
                }
                left++;
            }

        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}