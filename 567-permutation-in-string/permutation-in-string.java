class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length()) return false;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int k=s1.length();
        for(int i=0;i<k;i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }
        for(int i=k;i<s2.length();i++){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
            map2.put(s2.charAt(i-k),map2.get(s2.charAt(i-k))-1);
            if(map2.get(s2.charAt(i-k))==0)
                map2.remove(s2.charAt(i-k));
            if(map1.equals(map2)){
                return true;
            }

        }
        return false;
    }
}