class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int max=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            max=Math.max(max,set.size());
        }
        return max;
    }
}