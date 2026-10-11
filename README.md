# LearnTrack — Student Course Management System

A menu-driven console application built in Java that manages students, courses,
and enrollments. All data is held in memory using `ArrayList` — no database or
file I/O required.

---

## Project Structure

```
src/com/airtribe/learntrack/
├── ui/          Main.java              — console menu & user input
├── entity/      Student, Course, Enrollment, Person, Trainer,
│                EnrollmentStatus       — domain model
├── service/     StudentService, CourseService, EnrollmentService
│                                       — business logic
├── db/          StudentDB, CourseDB, EnrollmentDB
│                                       — in-memory data store
├── exception/   EntityNotFoundException, InvalidInputException
├── util/        IdGenerator, InputValidator
docs/
├── Setup_Instructions.md
├── JVM_Basics.md
└── Design_Notes.md
```

---

## Class Diagram

```mermaid
classDiagram

    %% ── Inheritance ──────────────────────────────────────
    Person <|-- Student
    Person <|-- Trainer

    %% ── Association: Enrollment links Student and Course ─
    Student "1" --> "0..*" Enrollment : has
    Course  "1" --> "0..*" Enrollment : has

    %% ── Enumeration used by Enrollment ───────────────────
    Enrollment --> EnrollmentStatus : status

    %% ── Service → DB dependencies ────────────────────────
    StudentService    ..> StudentDB    : uses
    CourseService     ..> CourseDB     : uses
    EnrollmentService ..> EnrollmentDB : uses
    EnrollmentService ..> CourseDB     : uses

    %% ── DB → Entity dependencies ─────────────────────────
    StudentDB    ..> Student    : stores
    CourseDB     ..> Course     : stores
    EnrollmentDB ..> Enrollment : stores

    %% ── Service → Utility dependencies ──────────────────
    StudentService    ..> IdGenerator : uses
    CourseService     ..> IdGenerator : uses
    EnrollmentService ..> IdGenerator : uses

    %% ── UI → Service dependencies ────────────────────────
    Main ..> StudentService    : calls
    Main ..> CourseService     : calls
    Main ..> EnrollmentService : calls

    %% ── Exception usage ──────────────────────────────────
    EntityNotFoundException  --|> Exception
    InvalidInputException    --|> Exception

    %% ── Class definitions ────────────────────────────────

    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getId() int
        +getFirstName() String
        +getLastName() String
        +getEmail() String
        +getDisplayName() String
    }

    class Student {
        -String batch
        -Boolean active
        +getBatch() String
        +getActive() Boolean
        +getDisplayName() String
    }

    class Trainer {
        -String specialisation
        +getSpecialisation() String
        +getDisplayName() String
    }

    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -Boolean active
        +getId() int
        +getCourseName() String
        +getActive() Boolean
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -Date enrollmentDate
        -EnrollmentStatus status
        +getId() int
        +getStudentId() int
        +getCourseId() int
        +getStatus() EnrollmentStatus
    }

    class EnrollmentStatus {
        <<enumeration>>
        ACTIVE
        COMPLETED
        CANCELLED
    }

    class StudentService {
        <<service>>
        +addStudent(firstName, lastName, batch)$
        +addStudent(firstName, lastName, email, batch)$
        +getStudentById(id) Student$
        +listStudents()$
        +updateStudent(id, ...)$
        +removeStudent(id)$
    }

    class CourseService {
        <<service>>
        +addCourse(name, desc, weeks)$
        +getCourseById(id) Course$
        +listCourses()$
        +updateCourse(id, ...)$
        +activateOrDeactivate(id, active)$
    }

    class EnrollmentService {
        <<service>>
        +enrollStudent(studentId, courseId)$
        +viewEnrollmentsForStudent(studentId)$
        +updateEnrollment(id, status)$
    }

    class StudentDB {
        <<datastore>>
        -List~Student~ students$
        +addStudent(student)$
        +getStudentById(id) Student$
        +getAllStudents() List$
    }

    class CourseDB {
        <<datastore>>
        -List~Course~ courses$
        +addCourse(course)$
        +getCourseById(id) Course$
        +getAllCourses() List$
    }

    class EnrollmentDB {
        <<datastore>>
        -List~Enrollment~ enrollments$
        +addEnrollment(enrollment)$
        +listAllEnrollments() List$
    }

    class IdGenerator {
        <<utility>>
        -int studentIdCounter$
        -int courseIdCounter$
        -int enrollmentIdCounter$
        +getNextStudentId() int$
        +getNextCourseId() int$
        +getNextEnrollmentId() int$
    }

    class InputValidator {
        <<utility>>
        +validateNonEmpty(value, field)$
        +validatePositive(value, field)$
    }

    class EntityNotFoundException {
        +EntityNotFoundException(message)
    }

    class InvalidInputException {
        +InvalidInputException(message)
    }

    class Main {
        <<ui>>
        -Scanner scanner$
        +main(args)$
    }
```

---

## Prerequisites

| Tool | Minimum version |
|------|----------------|
| JDK  | 17 (uses switch-expression arrow syntax) |

Verify your installation:

```bash
java -version
javac -version
```

---

## Compile

From the project root (the directory that contains `src/`):

```bash
# Create the output directory
mkdir -p out

# Compile all source files
javac -d out $(find src -name "*.java")
```

---

## Run

```bash
java -cp out com.airtribe.learntrack.ui.Main
```

You will see a menu like:

```
========================================
   Welcome to LearnTrack
========================================
----------------------------------------
  Main Menu
----------------------------------------
  1. Student Management
  2. Course Management
  3. Enrollment Management
  0. Exit
----------------------------------------
Enter choice:
```

---

## Features

### Student Management
- Add a student (with or without an email address)
- List all students
- Search a student by ID
- Update student details (any field, others are preserved)
- Deactivate a student (soft-delete — sets `active = false`)

### Course Management
- Add a course
- List all courses
- Activate or deactivate a course

### Enrollment Management
- Enroll a student in a course
- View all enrollments for a student
- Mark an enrollment as **Completed** or **Cancelled**

---

## Error Handling

- Typing a non-number at any numeric prompt re-prompts cleanly.
- Entering an unknown menu option shows `[!] Invalid option.`
- Referencing a student, course, or enrollment that does not exist prints
  the error message from `EntityNotFoundException` — no stack trace is shown.

---

## Package

`com.airtribe.learntrack`
