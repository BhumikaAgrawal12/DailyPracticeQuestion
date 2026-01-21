class Solution {
    public String makeGood(String s) {
        ArrayDeque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty()){
                if(Character.toLowerCase(ch)==Character.toLowerCase(st.peek())&& st.peek()!=ch){
                    st.pop();
                    continue;
               }
            }
        
            st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}