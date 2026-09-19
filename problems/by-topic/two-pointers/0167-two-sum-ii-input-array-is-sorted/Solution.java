/**
 * Problem: Two Sum II - Input Array Is Sorted (Medium)
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Approach: two pointers from both ends, relying on sorted order: moving right inward can
 * only decrease or hold the sum, moving left inward can only increase or hold it, so each
 * move safely eliminates the half that cannot contain the answer.
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
