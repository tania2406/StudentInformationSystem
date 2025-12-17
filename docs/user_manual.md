# User Manual

## 1. Starting the Application

After compiling:
   cd src
   java StudentInformationSystem
 
You will see a menu like:

   ===== Student Information System =====

1.Add Student
 
2.View All Students

3.Update Student

4.Delete Student

5.Search Student by ID

6.Search Student by Name

7.Exit
======================================
Enter your choice:


Type the option number and press Enter.

---

## 2. Menu Options

### 1. Add Student

- Prompts for:
  - Student ID
  - Name
  - Age
  - Grade (0–100)
  - Contact
- Valid input:
  - A new student is added and you see: `Student added successfully.`  
- Invalid input:
  - Empty ID/Name/Contact → error, re-prompt or abort.  
  - Age ≤ 0 or invalid → rejected.  
  - Grade < 0 or > 100 or invalid → rejected.  
  - Duplicate ID → not added.

### 2. View All Students

- Shows a formatted table of all stored students:
  - Columns: ID, Name, Age, Grade, Contact.  
- If there are no students:
  - Shows: `No student records found.`

### 3. Update Student

- Asks for the Student ID to update.  
- If found:
  - Displays current values for each field.  
  - For each field:
    - Press Enter to keep the current value.  
    - Type a new value to update it.  
  - Invalid new values (e.g., invalid age/grade format) are ignored with an error message.  
- If not found:
  - Shows: `Student not found.`

### 4. Delete Student

- Asks for Student ID.  
- If found:
  - Deletes the student and displays a confirmation message.  
- If not found:
  - Shows: `Student not found.`

### 5. Search Student by ID

- Asks for Student ID.  
- If found:
  - Prints a single formatted row with that student’s details.  
- If not:
  - Shows: `Student not found.`

### 6. Search Student by Name

- Asks for a full or partial name.  
- Performs a case-insensitive substring search.  
- Shows all matching students in a table.  
- If none match:
  - Shows: `No students matched the search.`

### 0. Exit

- Exits the application with the message: `Exiting... Goodbye!`

---

## 3. Input Rules and Validation

- **Age**:
  - Must be a positive integer.  
- **Grade**:
  - Must be a number between 0 and 100.  
- **Student ID, Name, Contact**:
  - Cannot be blank.  
- On invalid numeric input:
  - The application prints an error and re-prompts until a valid number is provided.

---

## 4. Using Sample Data

- Open `test_data/sample_students.txt` in a text editor.  
- Use these values to quickly populate several students through the “Add Student” menu option.  
- Then test viewing, updating, deleting, and searching.

---

## 5. Notes

- Data is stored only in memory during the current run.  
- When you exit the program, all records are cleared.
