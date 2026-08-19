package util;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null || password.length() != 8) {
            return false;
        }

        if (!password.matches("\\d+")) {
            return false;
        }

        return true;
    }
}
