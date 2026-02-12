class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxLen=0;
        
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> map=new HashMap<>();
            
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                if(!map.containsKey(ch)){
                    map.put(ch,1);
                }
                else{
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                if(check(map)){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
    public boolean check(HashMap<Character,Integer> map){
         if (map.size() <= 1) return true;

        // First value store karo
        int firstValue = map.values().iterator().next();

        // Sab values compare karo
        for (int value : map.values()) {
            if (value != firstValue) {
                return false;
            }
        }

        return true;
    }
}