# BankVault

A plain Java project demonstrating **Encapsulation** as behavioral enforcement —
not just access modifiers.

## The Concept

Most introductions to encapsulation stop at *"make fields private, add getters
and setters."* That is access control — it is not encapsulation.

True encapsulation means an object **owns its state and enforces all the rules
around how that state changes.** The outside world never reaches in and mutates
it directly. It submits requests through a controlled interface, and the object
decides whether and how to honor them.

A raw setter like `setBalance(double balance)` hands complete control back to
the caller. They can set the balance to `-999999`. The object has no say. The
field is private in name only — the behavior is completely unencapsulated.

## What This Project Demonstrates

### No setter for `balance`
There is no `setBalance()`. The only way balance changes is through `deposit()`
or `withdraw()`, both of which validate input and enforce rules before touching
the field. The invariant — balance never goes negative — is guaranteed by the
object itself, not trusted to the caller.

### Named, intent-revealing methods over raw setters
The vault is frozen and unfrozen through `freeze()` and `unfreeze()` rather than
a `setFrozen(boolean)`. Named methods make intent explicit and allow the object
to react internally — in this case, logging every state change automatically.

### Unmodifiable view of internal state
`getTransactionLog()` returns `Collections.unmodifiableList(transactionLog)`
rather than the list itself. Returning the real list would hand the caller a
live reference — they could call `.clear()` and wipe the audit trail. The
unmodifiable wrapper allows reading without allowing mutation.

## Invariants Enforced

| Rule                                      | Enforced by         |
|-------------------------------------------|---------------------|
| Balance never goes negative               | `withdraw()`        |
| Deposits and withdrawals must be positive | Both methods        |
| No withdrawals when frozen                | `withdraw()`        |
| Transaction log cannot be tampered with   | Unmodifiable view   |

## Where This Appears in Real Codebases

**Spring Security's `SecurityContextHolder`** is a strong real-world example.
You do not reach in and flip an `isAuthenticated` boolean. You interact through
`Authentication` objects and filter chains. The security state is fully
encapsulated — the rules are enforced by the framework, not trusted to the
caller.

**JPA-managed entities** follow the same idea for primary keys. The `id` field
is generated and controlled by the persistence layer. You never call
`setId()` in application code — the framework owns that invariant.