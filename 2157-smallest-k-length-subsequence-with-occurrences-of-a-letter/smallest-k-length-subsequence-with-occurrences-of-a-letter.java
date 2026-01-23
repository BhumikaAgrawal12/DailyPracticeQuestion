class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int letterCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter){
                letterCount++;
            }
        }
        int remainLetter=letterCount;
        int st_letter=0;
        ArrayDeque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==letter){
                remainLetter--;
            }
             while (!st.isEmpty()
                    && st.peek() > ch
                    && st.size() - 1 + (s.length() - i) >= k
                    && (st.peek() != letter || st_letter - 1 + remainLetter >= repetition)) {

                if (st.pop() == letter) st_letter--;
            }

            if(st.size()<k && ch==letter){
                st_letter++;
                st.push(ch);
            }
            else if(st.size()<k){
                if(k-st.size()>repetition-st_letter){
                    st.push(ch);
                }
            }

        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}


// class Solution {
//     static String best = null;
//     public String smallestSubsequence(String str, int k, char letter, int repetition) {
//         best=null;
//         findSubsequences(str,"",0,k,letter,repetition);
//         if(best!=null){
//             return best;
//         }
//         return best;
//     }
//     public static void findSubsequences(String str,String ans,int indx,int k,char letter,int repetition){
//          if (ans.length() > k) return;

//         if(ans.length()==k){   
//             int count = 0;
//             for (int i = 0; i < ans.length(); i++) {
//                 if (ans.charAt(i) == letter) {
//                     count++;
//                 }
//             }

//             if (count < repetition) return;
//             if (best == null || ans.compareTo(best) < 0) {//lexicogaphically comparision k liye
//                 best = ans;
//             }
//             return;
           
//         }
//         if(indx==str.length()){
//             return;
//         }
//         //include
//         findSubsequences(str,ans+str.charAt(indx),indx+1,k,letter,repetition);
//         //exclude
//         findSubsequences(str,ans,indx+1,k,letter,repetition);
//     }

// }