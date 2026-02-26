class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        int carry = 0;
        
        // right se left traverse (last se 1 tak)
        for (int i = s.length() - 1; i > 0; i--) {
            
            int bit = s.charAt(i) - '0';
            int sum = bit + carry;
            
            if (sum == 0) {
                // even
                steps += 1;
                // carry remains 0
            } 
            else if (sum == 1) {
                // odd
                steps += 2;
                carry = 1;
            } 
            else { // sum == 2
                // 10 -> even
                steps += 1;
                carry = 1;
            }
        }
        
        // last bit handle karo
        return steps + carry;
    }
}