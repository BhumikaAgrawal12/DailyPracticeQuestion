import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                freq.put(product, freq.getOrDefault(product, 0) + 1);
            }
        }

        int sum = 0;
        for (int count : freq.values()) {
            if (count > 1) {
                sum += (count * (count - 1)) / 2;
            }
        }

        return sum * 8;
    }
}