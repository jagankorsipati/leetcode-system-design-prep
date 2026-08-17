# 543. Diameter of Binary Tree

**Difficulty:** Easy
**Link:** [LeetCode](https://leetcode.com/problems/diameter-of-binary-tree/)
**Pattern:** DFS on trees (height + side-effect tracking)

## Problem

Given a binary tree, find the length of the longest path between any two nodes, measured in number of edges. The path does not need to pass through the root.

## Intuition

The naive instinct is to think "longest path" means starting from the root. It doesn't — the diameter can be entirely within a subtree, far from the root. The trick is to realize that the longest path *through* any given node equals (height of its left subtree) + (height of its right subtree) + 2 edges connecting them. So: compute height recursively as normal, but at every node, also check whether the path *through* that node beats the best diameter seen so far. The diameter is a side-effect of the height computation, not the primary return value.

## Approach

1. Do a post-order DFS that returns the height of each subtree.
2. A `null` node has height `-1` (so a leaf node computes to height `0`).
3. At each node, compute `leftHeight + rightHeight + 2` — this is the diameter of the path passing through this node — and update a running max (`diameter`) if it's larger.
4. Return `max(leftHeight, rightHeight) + 1` as this node's height, for the parent's calculation.
5. After the DFS finishes, `diameter` holds the answer.

## Complexity

- **Time:** O(n) — visits every node exactly once.
- **Space:** O(h) — recursion stack depth equals tree height (worst case O(n) for a skewed tree, O(log n) for a balanced one).

## Visual

![Diameter of Binary Tree walkthrough](diagram.svg)

## Solution

See [`Solution.java`](Solution.java)

## Edge cases considered

- Single node tree → diameter is 0 (no edges).
- Skewed tree (essentially a linked list) → diameter equals the number of nodes minus 1, and recursion depth is O(n) — worth mentioning iterative/stack-based alternatives if asked about stack overflow risk on very deep trees.
- Empty tree (`root == null`) → returns 0 correctly since `diameter` starts at 0 and `longestPath` is never called on a real node.

## Follow-ups / variants

- What if you need the actual path (node sequence), not just its length? → track parent pointers or the two subtree "arms" at the max node.
- What if the tree is huge and doesn't fit comfortably in a recursive call stack? → convert to an iterative post-order traversal with an explicit stack.
- Weighted edges instead of counting edges? → same structure, just sum edge weights instead of +1/+2.