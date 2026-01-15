class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()){
            return -1;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        int indx=haystack.indexOf(needle);
        return indx;
    }
}