package repository;

import entities.Management;
import entities.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {

    private final List<Management> managements = new ArrayList<>();

    public ManagerRepository() {
        Management management = new Management("Joao", "admin", 123);
        management.setRole(UserRole.MANAGER);

        managements.add(management);
    }

    public Management findByCpf(String cpf) {
        for (Management management : managements) {
            if (management.getCpf().equals(cpf)) {
                return management;
            }
        }
        return null;
    }
}
