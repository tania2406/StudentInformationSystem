
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findById(student.getStudentId()) != null) {
            return false; // ID already exists
        }
        students.add(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> findByName(String namePart) {
        List<Student> result = new ArrayList<>();
        String target = namePart.toLowerCase();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(target)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean deleteStudent(String id) {
        Student s = findById(id);
        if (s == null) return false;
        students.remove(s);
        return true;
    }
}
