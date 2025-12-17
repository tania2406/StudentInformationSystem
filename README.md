# Student Information System (Java Console)

## Project Overview and Objectives

The Student Information System is a console-based Java application that manages basic student records (Student ID, name, age, grade, contact number).  
Its objectives are to provide simple CRUD operations from the terminal, demonstrate a clear separation between model, business logic, validation, and UI, and showcase input validation and formatted console output using core Java only.

---

## Setup and Installation Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt or a Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Steps (Command Line)

1. Clone the repository:
   
    git clone https://github.com/tania2406/StudentInformationSystem.git
   
    cd StudentInformationSystem

3. Compile the source code:
   
   cd src
   
   javac Student.java StudentManager.java ValidationUtils.java StudentInformationSystem.java

5. Run the application:
   
   java StudentInformationSystem
   
For detailed setup, see `docs/installation_guide.md`.

---

## Code Structure

Project layout:

├── README.md

├── src

│ ├── Student.java # Student entity class

│ ├── StudentManager.java # Business logic and data handling

│ ├── ValidationUtils.java # Validation helper methods

│ └── StudentInformationSystem.java# Main program and menu/UI

├── docs

│ ├── installation_guide.md # Detailed installation steps

│ ├── user_manual.md # How to use the application

│ ├── code_explanation.md # Detailed code/architecture explanation

│ ├── screenshot_menu.jpg # (add actual screenshot)

│ ├── screenshot_add.jpg # (add actual screenshot)

│ └── screenshot_view.jpg # (add actual screenshot)

└── test_data

└── sample_students.txt # Sample input data for testing


Short description of source files:

- `Student.java`  
  - Data model for a student with fields: `studentId`, `name`, `age`, `grade`, `contact`.  
  - Getters/setters and a `display()` method to print a formatted row.

- `StudentManager.java`  
  - Stores students in an internal `ArrayList<Student>`.  
  - Methods for add, list all, find by ID, find by name, and delete.

- `ValidationUtils.java`  
  - Static validation methods:
    - `isNonEmpty(String value)`
    - `isValidAge(int age)`
    - `isValidGrade(double grade)`

- `StudentInformationSystem.java`  
  - Contains `main` and the menu loop.  
  - Uses `Scanner` for input, `StudentManager` for operations, and `ValidationUtils` for validation.

---

## Screenshots of Working Application

screenshots to the `docs/` :
1. screenshot_menu.jpg
2. screenshot_add.jpg
3. screenshot_view.jpg


---

## How Technical Requirements Are Met

- **Project overview and objectives**  
  - Described above in “Project Overview and Objectives”.

- **Setup and installation instructions**  
  - Provided in this README and in detail in `docs/installation_guide.md`.

- **Code structure explanation**  
  - Given in the “Code Structure” section and expanded in `docs/code_explanation.md`.

- **Screenshots of working application**  
  - Stored in `docs/` and referenced in README and user manual.

- **Technical requirements mapping**  
  - Student class with attributes: `Student.java`  
  - Data validation (age, grade, non-empty): `ValidationUtils.java` + checks in `StudentInformationSystem.java`  
  - Menu-driven interface with `Scanner`: `StudentInformationSystem.java`  
  - Add, view, update, delete: menu methods → `StudentManager` methods  
  - Search by ID/name: `searchById()` / `searchByName()` → `StudentManager.findById()` / `findByName()`  
  - Formatted output: `Student.display()` uses `System.out.printf("%-10s %-20s %-5d %-7.2f %-15s%n", ...)`  
  - Basic error handling: input helper methods (`readInt`, `readDouble`, etc.) catch parsing errors and re-prompt  
  - Data persistence with `ArrayList`: `StudentManager` maintains an in-memory `ArrayList<Student>` during the run

---



   
