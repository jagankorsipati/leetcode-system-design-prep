import java.util.*;

/**
 * Problem: Two Sum (Easy)
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Approach: single-pass hash map of value -> index; check complement before inserting.
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));          // [0, 1]
    }
}
