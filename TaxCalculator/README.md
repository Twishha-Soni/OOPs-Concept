# TaxCalculator

A plain Java project demonstrating **Polymorphism** — one call, many
behaviors, zero instanceof.

## The Concept

Polymorphism means one method call produces different behavior depending
on the actual type of the object receiving it. You call the same method
on different objects through the same reference type, and each object
responds in its own way. The caller does not decide which behavior runs.
The object does.

### The instanceof Problem

The most common sign that polymorphism is being missed:

```java
if (taxpayer instanceof Freelancer) {
    // freelancer logic
} else if (taxpayer instanceof Corporate) {
    // corporate logic
} else if (taxpayer instanceof NonProfit) {
    // nonprofit logic
}
```

This is the caller deciding which behavior runs. Every time a new type
is added, this block must be found and extended. The logic is scattered
across the codebase rather than living inside each type where it belongs.

With true polymorphism, adding a new type means writing one new class.
Nothing else changes. The if/else chain does not exist.

### How the JVM Makes This Work

When you call `calculator.calculate(income)`, the JVM does not look at
the reference type (`TaxCalculator`). It looks at the actual object in
memory — the real class that was instantiated — and runs that class's
version of the method. This is called **dynamic dispatch**.

This is why `instanceof` is unnecessary. The dispatch mechanism already
knows the type. Writing `instanceof` chains duplicates work the JVM
already does — and requires manual maintenance every time a new type
is added.

## What This Project Demonstrates

### Zero conditionals in TaxProcessor
`TaxProcessor` calls `calculator.calculate(income)` in a loop. The JVM
routes each call to the correct implementation automatically. No `if`,
no `switch`, no `instanceof` anywhere in the processor.

### Each type owns its own rules
`EmployeeTaxCalculator` applies progressive brackets with a standard
deduction. `FreelancerTaxCalculator` applies a flat rate plus a
self-employment surcharge. `CorporateTaxCalculator` applies small
business relief below a threshold. `NonProfitTaxCalculator` returns
zero tax. Each rule set lives entirely inside its own class.

### NonProfit proves the point
A non-profit paying zero tax would be a special case in an `instanceof`
world — its own branch, its own condition. Here it is simply another
implementation of the same contract. `TaxProcessor` treats it
identically to every other type.

### Adding a new type costs one new class
To add a `SoleTraderTaxCalculator`, write the class and add it to the
list in `Main`. `TaxProcessor` does not change. The `TaxCalculator`
interface does not change. Nothing else changes.

## Where This Appears in Real Codebases

**`HttpMessageConverter`** — when Spring serializes a response to JSON,
it calls `write()` on a converter. Which converter runs depends on the
actual registered type. Spring never writes an `instanceof` chain to
decide.

**`AuthenticationProvider`** — Spring Security calls `authenticate()`
on whatever provider is registered. Whether it is a database provider,
LDAP provider, or in-memory provider, the call is identical. The object
decides the behavior.

**`GlobalExceptionHandler`** — each `@ExceptionHandler` method is
polymorphic dispatch. Spring looks at the actual exception type and
routes to the right handler. No `instanceof` anywhere.