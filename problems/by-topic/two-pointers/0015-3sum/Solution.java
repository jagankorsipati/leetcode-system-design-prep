import java.util.*;

/**
 * Problem: 3Sum (Medium)
 * Link: https://leetcode.com/problems/3sum/
 *
 * Approach: sort first, then fix one element and two-pointer scan the rest for pairs summing
 * to its complement. Skips duplicates at both the outer index and inside the two-pointer scan
 * to avoid duplicate triplets, relying on sorted order so identical values sit adjacent.
 * Time: O(n^2) - the O(n log n) sort is dominated by the nested scan.
 * Space: O(log n) auxiliary (recursion stack from the in-place sort); output is O(n^2) in the
 * worst case but that is the unavoidable size of the answer, not extra working space.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        // Fix the first element, then two-pointer scan the remainder for its complement pair.
        // Outer loop stops two short of the end, since left and right need at least two slots.

        for (int i = 0; i < nums.length - 2; i++) {

            // Distinct triplets required: skip i if it repeats the previous value, so only the
            // first occurrence of any duplicate run ever runs the full inner scan.
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int target = 0 - nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip past any run of duplicate values at left and right before continuing,
                    // so the same triplet isn't recorded more than once.
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
