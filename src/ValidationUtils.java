
public class ValidationUtils {
	public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }
}
