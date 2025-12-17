import java.util.List;
import java.util.Scanner;

public class StudentInformationSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchById();
                case 6 -> searchByName();
                case 0 -> {
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Student Information System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student by ID");
        System.out.println("6. Search Student by Name");
        System.out.println("0. Exit");
        System.out.println("======================================");
    }

    private static void addStudent() {
        System.out.println("----- Add Student -----");
        String id = readNonEmptyString("Enter Student ID: ");

        if (manager.findById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Name: ");
        int age = readInt("Enter Age (positive): ");
        double grade = readDouble("Enter Grade (0-100): ");
        String contact = readNonEmptyString("Enter Contact: ");

        if (!ValidationUtils.isValidAge(age)) {
            System.out.println("Invalid age.");
            return;
        }
        if (!ValidationUtils.isValidGrade(grade)) {
            System.out.println("Invalid grade.");
            return;
        }

        Student s = new Student(id, name, age, grade, contact);
        boolean added = manager.addStudent(s);
        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student (duplicate ID).");
        }
    }

    private static void viewAllStudents() {
        System.out.println("----- All Students -----");
        List<Student> list = manager.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-7s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-----------------------------------------------------------");
        for (Student s : list) {
            s.display();
        }
    }

    private static void updateStudent() {
        System.out.println("----- Update Student -----");
        String id = readNonEmptyString("Enter Student ID to update: ");
        Student student = manager.findById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Leave input empty to keep existing value.");

        System.out.println("Current Name: " + student.getName());
        String name = readOptionalString("Enter new Name: ");
        if (ValidationUtils.isNonEmpty(name)) {
            student.setName(name);
        }

        System.out.println("Current Age: " + student.getAge());
        String ageStr = readOptionalString("Enter new Age: ");
        if (ValidationUtils.isNonEmpty(ageStr)) {
            try {
                int age = Integer.parseInt(ageStr);
                if (ValidationUtils.isValidAge(age)) {
                    student.setAge(age);
                } else {
                    System.out.println("Invalid age. Age not updated.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Age not updated.");
            }
        }

        System.out.println("Current Grade: " + student.getGrade());
        String gradeStr = readOptionalString("Enter new Grade: ");
        if (ValidationUtils.isNonEmpty(gradeStr)) {
            try {
                double grade = Double.parseDouble(gradeStr);
                if (ValidationUtils.isValidGrade(grade)) {
                    student.setGrade(grade);
                } else {
                    System.out.println("Invalid grade. Grade not updated.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade format. Grade not updated.");
            }
        }

        System.out.println("Current Contact: " + student.getContact());
        String contact = readOptionalString("Enter new Contact: ");
        if (ValidationUtils.isNonEmpty(contact)) {
            student.setContact(contact);
        }

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("----- Delete Student -----");
        String id = readNonEmptyString("Enter Student ID to delete: ");

        boolean deleted = manager.deleteStudent(id);
        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchById() {
        System.out.println("----- Search by ID -----");
        String id = readNonEmptyString("Enter Student ID: ");
        Student s = manager.findById(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-7s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-----------------------------------------------------------");
        s.display();
    }

    private static void searchByName() {
        System.out.println("----- Search by Name -----");
        String name = readNonEmptyString("Enter Name (full or partial): ");

        List<Student> result = manager.findByName(name);
        if (result.isEmpty()) {
            System.out.println("No students matched the search.");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-7s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-----------------------------------------------------------");
        for (Student s : result) {
            s.display();
        }
    }

    // ---------- Input helpers ----------

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("Please enter a non-negative number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!ValidationUtils.isNonEmpty(input)) {
                System.out.println("Input cannot be empty. Please try again.");
            } else {
                return input.trim();
            }
        }
    }

    private static String readOptionalString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input == null ? "" : input.trim();
    }
}

