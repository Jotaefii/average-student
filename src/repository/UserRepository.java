package repository;

import entities.Management;
import entities.User;
import entities.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new Management("Joao", "admin", 123, UserType.GESTOR));
    }

    public void salvar(User user) {
        users.add(user);
    }

    public List<User> listar() {
        return users;
    }

    public User buscarPorCpf(String cpf) {
        for (User user : users) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }
        return null;
    }
}
