package util;

public class CpfValidator {

    public static boolean isValid(String cpf) {

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        if (!cpf.matches("\\d+")) {
            return false;
        }

        return true;
    }
}
