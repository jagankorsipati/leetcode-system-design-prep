# LeetCode & System Design Prep

Personal interview prep log — Java solutions with explanations and diagrams, plus system design writeups. Built while prepping for Staff/Senior SDE interviews. Public so it's useful as a reference for others too.

## How this repo is organized

- **`problems/by-topic/`** — the source of truth. Each problem gets its own folder with a `README.md` (approach + complexity + diagram), a `Solution.java`, and a diagram/visual.
- **`problems/by-company/`** — thin index files that just link back into `by-topic/`, grouped by which company's interviews tend to ask them.
- **`system-design/`** — one folder per design problem, following requirements → high-level design → deep dive → trade-offs.
- **`templates/`** — copy these when adding a new problem so the format stays consistent.

## Progress

| # | Problem | Topic | Difficulty | Pattern | Status |
|---|---------|-------|------------|---------|--------|
| 1 | [Two Sum](problems/by-topic/arrays-hashing/0001-two-sum) | Arrays & Hashing | Easy | Hash Map | ✅ |

_(Add a row per problem as you go — see `templates/PROBLEM_TEMPLATE.md` for the per-problem format.)_

**Stats:** 1 solved · 1 Easy · 0 Medium · 0 Hard

## Legend

| Symbol | Meaning |
|--------|---------|
| ✅ | Solved, explained, reviewed |
| 🔁 | Solved, needs a revisit |
| 📝 | In progress |

## System Design Index

| # | Problem | Key concepts |
|---|---------|---------------|
| 1 | [URL Shortener](system-design/01-url-shortener) | Hashing, DB sharding, caching |

## Why this format

Each problem README follows the same structure on purpose: **problem → intuition → approach → complexity → visual → code**. That consistency is what makes this skimmable as a reference — for you during a quick pre-interview review, and for anyone else browsing.
