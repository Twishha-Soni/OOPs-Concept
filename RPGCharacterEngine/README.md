# RPGCharacterEngine

A plain Java project demonstrating **Inheritance** — shared structure,
not shared behavior.

## The Concept

Inheritance is one of the most abused features in OOP. The common mistake
is using it purely to reuse code. That leads to fragile, tangled hierarchies
that break the moment requirements change.

Inheritance is the right tool for one thing: when a subclass **is genuinely
a more specific version of its parent.** The parent defines structure — fields
and methods that are truly common to every subclass without exception. The
subclasses extend that structure with their own specific behavior.

The moment you catch yourself overriding a method just to do nothing, or
writing `if (this instanceof Warrior)` — inheritance is being abused.

### What the parent should carry

- **Shared fields** that belong to every subclass without exception
- **Shared operations** whose logic is truly identical across all subclasses
- **Abstract operations** that every subclass must provide, but each provides
  differently

### `abstract` is the honest keyword

When a method belongs on the parent conceptually but has no meaningful default
implementation, mark it `abstract`. This forces every subclass to provide its
own version. It is the parent saying: *"I know you all do this,
but I have no business deciding how."*

### Favor composition over inheritance

Inheritance models *is-a* relationships. Composition models *has-a*.
If you are inheriting primarily to reuse code rather than to express a genuine
type relationship, composition is almost always the better choice.

## What This Project Demonstrates

### Shared structure lives exactly once
`name`, `health`, and `level` belong to every character without exception —
they live on `RPGCharacter`. `takeDamage()`, `isAlive()`, and `getStatus()`
are identical for every subclass — they also live on the parent and are
never overridden. No duplication anywhere.

### Abstract methods force a contract
`attack()` and `getSpecialAbility()` are declared `abstract` on the parent
because the parent has nothing meaningful to say about how they work.
Every subclass must provide its own version or the code will not compile.

### Subclass-specific fields stay on the subclass
`armor` and `weaponType` belong only to `Warrior`. `mana` and `spellSchool`
belong only to `Mage`. `arrows` and `range` belong only to `Archer`.
None of these leak onto the parent.

### The caller never needs to know the subclass
`Battle` operates entirely on `RPGCharacter` references. It never imports
`Warrior`, `Mage`, or `Archer`. The inherited structure and the abstract
contract are everything it needs. This is the payoff of inheritance done right.

## Where This Appears in Real Codebases

**`OncePerRequestFilter`** — `JwtAuthFilter` extends it. The filter
infrastructure (ensuring the filter runs once per request, managing the
filter chain) is inherited structure. The actual filtering logic inside
`doFilterInternal()` is the subclass's own behavior.

**`RuntimeException`** — `StudentNotFoundException` and
`CourseNotFoundException` extend it. They inherit the exception structure
and add only their specific context. The exception handling infrastructure
works on the parent type — the caller never needs to know which subclass
was thrown.