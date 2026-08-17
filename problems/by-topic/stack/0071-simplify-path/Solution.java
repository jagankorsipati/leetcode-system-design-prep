import java.util.Stack;

/**
 * Problem: Simplify Path (Medium)
 * Link: https://leetcode.com/problems/simplify-path/
 *
 * Approach: tokenize on '/', use a stack to handle '..' (pop) and ignore '.' / empty tokens,
 * then rebuild the canonical path from the stack.
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            switch (token) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                case "":
                    break; // no-op: current dir, or artifact of split on repeated/leading slashes
                default:
                    stack.push(token);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}