# 71. Simplify Path

**Difficulty:** Medium
**Link:** [LeetCode](https://leetcode.com/problems/simplify-path/)
**Pattern:** Stack (tokenize + process directory components)

## Problem

Given an absolute Unix-style file path, convert it to its simplified canonical form — collapsing `.` (current directory, a no-op), resolving `..` (go up one directory), and removing redundant slashes.

## Intuition

A stack is the natural fit because `..` needs to "undo" the most recently pushed directory — that's exactly stack (LIFO) behavior. Split the path on `/`, then walk the resulting tokens: push real directory names, pop on `..`, ignore `.` and empty strings (which come from consecutive or trailing slashes).

## Approach

1. Split the path string on `/`.
2. For each token:
   - `".."` → pop the stack if it's non-empty (going up a level; ignore if already at root).
   - `"."` or `""` → skip (no-op / artifact of split).
   - anything else → push it as a real directory name.
3. Rebuild the path by popping the stack and prepending `/` + name to the result.
4. If the stack was empty the whole time, the canonical path is just `"/"`.

## Complexity

- **Time:** O(n) — one pass to split/tokenize, one pass to rebuild from the stack.
- **Space:** O(n) — stack holds up to n directory components in the worst case.

## Visual

![Simplify Path stack walkthrough](diagram.svg)

## Solution

See [`Solution.java`](Solution.java)

## Edge cases considered

- Multiple consecutive slashes (`"//home//foo/"`) → `split` produces empty-string tokens, explicitly skipped.
- Trailing `..` past the root (`"/../"`) → popping an empty stack is a no-op, so it correctly stays at `/`.
- Result is empty after processing (all tokens were `.`/`..`/empty) → must return `"/"`, not an empty string.

## A note on the original version

The first pass of this solution had `if (result == "")` — a reference comparison rather than a value comparison (`result.equals("")` or `result.isEmpty()`). It happened to work here due to Java's string literal interning, but relying on `==` for string equality is a classic subtle bug and would likely get flagged in code review. Fixed in the version below.

## Follow-ups / variants

- What about Windows-style paths (`\` separators, drive letters)? → would need a different tokenization strategy; worth mentioning you'd ask the interviewer for the target OS convention.
- What if the path can contain multiple `..` in sequence beyond root, and the interviewer wants an error instead of clamping at `/`? → straightforward extension: track underflow and throw/flag instead of silently ignoring.