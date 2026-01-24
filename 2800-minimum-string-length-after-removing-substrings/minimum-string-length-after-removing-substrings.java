class Solution {
    public int minLength(String s) {
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ((st.peek()=='A' && ch=='B')||(st.peek()=='C' && ch=='D'))){
                st.pop();
            }
            else
                st.push(ch);
        }
        return st.size();
    }
}