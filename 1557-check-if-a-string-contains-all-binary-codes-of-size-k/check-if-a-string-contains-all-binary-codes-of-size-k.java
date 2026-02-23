import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        // Total possible binary codes of length k
        int totalCodes = 1 << k;   // 2^k
        
        HashSet<String> set = new HashSet<>();
        
        // Generate all substrings of length k
        for(int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
        }
        
        // Check if all possible codes are present
        return set.size() == totalCodes;
    }
}