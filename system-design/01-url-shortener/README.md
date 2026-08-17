# URL Shortener

## Requirements

**Functional**
- Shorten a long URL into a short code.
- Redirect a short code to its original URL.

**Non-functional**
- Read-heavy (redirects far outnumber creations) — quantify the ratio if you're given one in the interview.
- Low latency redirects (<100ms).
- High availability preferred over strong consistency for redirects.

**Scale estimate** (fill in from interviewer-given numbers or state your own assumptions explicitly):
- Writes/sec: ?
- Reads/sec: ?
- Storage over 5 years: ?

## High-level design

Diagram goes here — `![design](diagrams/high-level.svg)`. Client → Load Balancer → App servers → Cache → DB, plus the ID-generation path.

## Deep dive

- **ID generation strategy:** base62 counter vs. hash-and-check vs. pre-generated key ranges — trade-offs on collision handling and coordination.
- **Data store choice:** why a KV store (e.g. DynamoDB/Cassandra) usually beats a relational DB here, and when it wouldn't.
- **Caching:** what to cache, eviction policy, cache-aside vs write-through.

## Trade-offs discussed

Table or bullets contrasting the 2-3 major decision points, what you chose, and what you gave up. This section is often what differentiates senior from staff-level answers — showing you understood the alternative, not just the answer.

## Follow-ups to be ready for

- Custom aliases
- Analytics/click tracking
- Rate limiting abusive creators
- Expiring links
