class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int total = 0;
        
        double subsets = Math.pow(2,n);
        for (int mask = 0; mask < subsets; mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums[i];
                }
            }
            total += xor;
        }
        
        return total;
    }
}
