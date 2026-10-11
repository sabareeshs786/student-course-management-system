# Design Notes

This document explains the key design decisions made in the LearnTrack project.

---

## 1. Why ArrayList Instead of a Plain Array

An array in Java has a fixed length that must be decided at creation time.
That is a problem for a system where the number of students or courses is not
known in advance — it grows as users add records at runtime.

The key benefit is **no upfront size decision** — the list simply grows as
students are added, and the code stays simple.

---

## 2. Where Static Members Are Used and Why

`static` means the member belongs to the *class*, not to any particular
instance. There are two places in the project where this is the right choice.

### IdGenerator — static counters and methods

There is exactly one running application and therefore one sequence of IDs.
If `studentIdCounter` were an instance field, every `new IdGenerator()` would
restart from 0, producing duplicate IDs.  Making it `static` means all code
shares the same counter for the lifetime of the program.

The methods are `static` for the same reason — callers do not need (and should
not need) to create an `IdGenerator` object just to get the next ID:


### DB classes — static data stores

`StudentDB`, `CourseDB`, and `EnrollmentDB` hold `private static final` lists.
The lists are `static` so that all service classes access the same shared store.
If they were instance fields, two separate `StudentDB` objects would hold
two separate lists — data added through one would be invisible to the other.

### Service classes — static utility methods

All methods in `StudentService`, `CourseService`, and `EnrollmentService` are
`static`.  The services hold no per-instance state — they are collections of
operations on the shared DB lists.  Marking them `static` reflects this: there
is nothing an instance would add.

---

## 3. Where Inheritance Is Used and What It Gains

### The hierarchy

```
Person  (base class)
  ├── Student
  └── Trainer
```

### What Person provides

`Person` holds the four fields that every human in the system has:
`id`, `firstName`, `lastName`, and `email`, along with their getters/setters
and a `getDisplayName()` method.

### What inheritance gains

**No duplication.** Without inheritance, `Student` and `Trainer` would both
need to repeat the four `Person` fields and their accessor methods.  With
`extends Person`, they inherit all of that for free.

**Polymorphism.** Because `Student` and `Trainer` both extend `Person`, any
code that works with a `Person` reference works for either subtype.
Each subclass overrides `getDisplayName()` to produce output appropriate
for its role:

Calling `person.getDisplayName()` on any of these gives the right output
without the caller needing to know which concrete type it has — that is
**polymorphism** in practice.

**`super()` in constructors.** Both `Student` and `Trainer` call `super(id,
firstName, lastName)` or its overload to initialise the `Person` fields.
This means the initialisation logic lives in one place (`Person`) and
subclasses extend rather than repeat it.

---

