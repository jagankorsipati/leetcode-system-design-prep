/**
 * Problem: Container With Most Water (Medium)
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Approach: two pointers starting at both ends; always move the shorter line inward,
 * since it's the bottleneck limiting area and the taller line can never improve things alone.
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max_area = 0;

        while (left < right) {
            int current_height = Math.min(height[left], height[right]);
            int current_width = right - left;
            int current_area = current_height * current_width;
            max_area = Math.max(current_area, max_area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max_area;
    }
}
