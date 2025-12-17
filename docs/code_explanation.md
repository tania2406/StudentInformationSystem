# Code Explanation

## 1. Overall Architecture

The application is divided into four main classes:

- `Student` – represents a student record.  
- `StudentManager` – contains business logic and manages student data in memory.  
- `ValidationUtils` – provides reusable validation methods.  
- `StudentInformationSystem` – handles user interaction (menu and input/output).

All records are stored in an `ArrayList<Student>` inside `StudentManager` for the duration of the program run.

---

## 2. Student.java

### Purpose

Represents individual student records with basic fields and a method to print them in table format.

### Key Elements

- Fields:
  - `String studentId`
  - `String name`
  - `int age`
  - `double grade`
  - `String contact`

- Constructor:
  - Accepts all fields and assigns them.

- Getters/Setters:
  - Standard getters and setters for each field.
  - Validation is performed externally before setting.

- `display()`:
  - Uses formatted output for alignment:
    ```
    System.out.printf("%-10s %-20s %-5d %-7.2f %-15s%n",
                      studentId, name, age, grade, contact);
    ```

---

## 3. StudentManager.java

### Purpose

Encapsulates all operations on the student list (add, list, search, delete).

### Internal Data Structure

- `private final List<Student> students = new ArrayList<>();`  
  - Dynamic list of student records.

### Main Methods

- `boolean addStudent(Student student)`  
  - Checks for duplicate ID using `findById`.  
  - Adds the student if ID is unique and returns `true`.

- `List<Student> getAllStudents()`  
  - Returns a copy of the list of all students.

- `Student findById(String id)`  
  - Linear search for a student whose `studentId` matches (case-insensitive).

- `List<Student> findByName(String namePart)`  
  - Returns all students where `name` contains `namePart` (case-insensitive).

- `boolean deleteStudent(String id)`  
  - Removes the matching student if found and returns `true`.

---

## 4. ValidationUtils.java

### Purpose

Provides static methods to validate user input before it is used to create or modify `Student` objects.

### Methods

- `isNonEmpty(String value)`  
  - Returns `true` if `value` is not `null` and not blank.

- `isValidAge(int age)`  
  - Returns `true` if `age > 0`.

- `isValidGrade(double grade)`  
  - Returns `true` if `0 <= grade <= 100`.

These methods are used in `StudentInformationSystem` when reading and checking user input.

---

## 5. StudentInformationSystem.java

### Purpose

Contains the `main` method, displays the menu, reads user choices, and coordinates with `StudentManager` and `ValidationUtils`.

### Key Members

- `static Scanner scanner` – reads console input.  
- `static StudentManager manager` – performs all operations on student data.

### Main Flow

- `main`:
  - Runs a loop:
    - Displays menu via `printMenu()`.
    - Reads user choice using `readInt(...)`.
    - Uses a `switch` to call `addStudent()`, `viewAllStudents()`, `updateStudent()`, `deleteStudent()`, `searchById()`, or `searchByName()`.
    - Exits when the user enters `0`.

### UI Methods

- `addStudent()`  
  - Prompts for ID, Name, Age, Grade, Contact.  
  - Validates input using `ValidationUtils`.  
  - Creates a `Student` and calls `manager.addStudent(student)`.

- `viewAllStudents()`  
  - Retrieves all students from `manager.getAllStudents()`.  
  - Prints a header and calls `display()` on each student.

- `updateStudent()`  
  - Finds the student by ID.  
  - For each field, shows current value and allows blank input (keep value) or new value (update after validation).

- `deleteStudent()`  
  - Calls `manager.deleteStudent(id)` and prints success/failure.

- `searchById()`  
  - Calls `manager.findById(id)` and prints the result if found.

- `searchByName()`  
  - Calls `manager.findByName(namePart)` and prints all matching students.

### Input Helper Methods

- `readInt(String prompt)`  
  - Repeatedly prompts until a valid integer is entered.

- `readDouble(String prompt)`  
  - Repeatedly prompts until a valid double is entered.

- `readNonEmptyString(String prompt)`  
  - Prompts until a non-blank string is given.

- `readOptionalString(String prompt)`  
  - Allows blank input (used when updating fields).

---

## 6. How Technical Requirements Are Met

- **Project overview and objectives**  
  - Described in README and at the start of this document.

- **Setup and installation**  
  - Covered in `docs/installation_guide.md` and README.

- **Code structure explanation**  
  - Detailed in this file, mapping each responsibility to a specific class.

- **Screenshots of working application**  
  - Stored in `docs/screenshot_menu.jpg`, `docs/screenshot_add.jpg`, `docs/screenshot_view.jpg` and referenced in README and user manual.

- **Technical requirements**  
  - Student class with attributes: `Student.java`  
  - Validation of age, grade, and textual fields: `ValidationUtils.java` + checks in UI  
  - Menu-driven console interface using `Scanner`: `StudentInformationSystem.java`  
  - Add, view, update, delete, search: `StudentInformationSystem` + `StudentManager`  
  - Formatted output: `Student.display()` using `printf`  
  - Error handling: input helpers with try/catch and re-prompts  
  - Data persistence during runtime: `ArrayList<Student>` in `StudentManager`.

