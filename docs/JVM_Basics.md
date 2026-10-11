# JVM Basics — A Simple Explanation

## What is JDK, JRE, JVM?



| Term | Full Name | What It Is |
|------|-----------|------------|
| **JDK** | Java Development Kit | JRE + development tools (compiler, debugger, etc.) needed to *write and build* Java programs |
| **JRE** | Java Runtime Environment | JVM + the standard libraries needed to *run* Java programs |
| **JVM** | Java Virtual Machine | The engine that actually *runs* Java bytecode |


In short:
- **JDK** — everything in the JRE, plus the tools a developer needs to *create* Java programs (you install this if you want to *write* Java code).
- **JRE** — everything needed to run Java applications on a machine (you install this if you just want to *use* Java programs).
- **JVM** — runs the code.

---

## What Is Bytecode?

When you write a Java program, you write it in plain, human-readable Java source code (`.java` files).  
When you compile that code using `javac`, the compiler does **not** translate it into machine-specific instructions. Instead, it translates it into an intermediate format called **bytecode** (stored in `.class` files).

Bytecode is a compact set of instructions designed for the JVM — not for any real hardware. It sits halfway between high-level source code and low-level machine code.


---

## "Write Once, Run Anywhere"

One of Java's most famous promises is **"Write Once, Run Anywhere" (WORA)**. Here is what it means.

In many other languages, when you compile a program, the output is tied to a specific operating system and CPU architecture. A program compiled on Windows for Intel will not run on macOS or Linux without recompiling (and sometimes rewriting). This makes distributing software painful.

Java solves this by adding the JVM as a universal layer between your code and the hardware. You compile your `.java` source code once, and the result is bytecode — a platform-neutral format. Any machine that has a JVM installed can then run that bytecode, regardless of whether the machine runs Windows, macOS, Linux, or even an embedded system. The JVM is responsible for translating the bytecode into the native machine instructions for whatever hardware it runs on.

---
