# CoffeeMachine

A plain Java project demonstrating **Abstraction** — hiding the how,
exposing only the what.

## The Concept

Abstraction means you interact with something through **what it does,
not how it does it.** When you press "Espresso" on a coffee machine,
you don't think about water pressure, brew temperature, or extraction
time. You ask for a result. The machinery is hidden.

In code, abstraction means defining a **contract** — a set of operations
something can do — and keeping all implementation details hidden behind
that contract. The caller knows what to ask for. It has no idea how the
answer is produced.

### Abstraction vs Encapsulation

These two are commonly confused. The distinction is clean:

- **Encapsulation** asks: *who can touch this data?*
- **Abstraction** asks: *does the caller even need to know this exists?*

A coffee machine encapsulates its water tank (you can't reach in and
touch it). It abstracts its brewing process (you don't know or care
how it works).

## What This Project Demonstrates

### The interface is the only thing the caller sees
`CoffeeMachine` holds a `CoffeeBrewer` reference — never an
`EspressoMachine` or `FrenchPress` directly. The entire implementation
of each brewer is invisible to it. It calls `brew()` and receives a
`Coffee`. That is all it knows.

### Implementation details stay private
Each brewer hides its own machinery behind private constants —
`PRESSURE_BAR`, `STEEP_MINUTES`, `BRAND`. None of these leak through
the interface. The contract exposes none of them.

### Implementations are swappable at runtime
`setBrewer()` lets the active brewer be replaced without changing a
single line of `CoffeeMachine`. This is exactly what Spring does when
it injects a `PasswordEncoder` or `UserDetailsService` bean — the
dependent class never changes, only the injected implementation does.

## Where This Appears in Real Codebases

**`JpaRepository`** — you call `findAll()`, `save()`, `deleteById()`.
Whether Hibernate is generating SQL, caching, or batching underneath
is completely abstracted away.

**`PasswordEncoder`** — `AuthService` calls `passwordEncoder.matches()`.
It has no idea it is talking to `BCryptPasswordEncoder`. Swap to Argon2
tomorrow and `AuthService` does not change at all.

**`UserDetailsService`** — `JwtAuthFilter` calls `loadUserByUsername()`.
Whether users come from memory, a database, or an external service is
fully hidden behind the interface.
