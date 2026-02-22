class Solution {
    public int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int len = bin.length();
        
        int lastIndex = -1;
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            if (bin.charAt(i) == '1') {
                if (lastIndex != -1) {
                    max = Math.max(max, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        
        return max;
    }
}