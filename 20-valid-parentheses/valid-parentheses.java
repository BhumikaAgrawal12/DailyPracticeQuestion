class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(')');
            }
            else if(s.charAt(i)=='['){
                st.push(']');
            }
            else if(s.charAt(i)=='{'){
                st.push('}');
            }
            else{
                if(st.isEmpty() || st.peek()!=s.charAt(i)){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}