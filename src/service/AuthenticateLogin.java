package service;

import entities.User;

import java.util.List;

public class AuthenticateLogin {

    public static User autenticar(List<User> userList, String cpf, int senha) {
        for (User user : userList) {
            if (user.getCpf().equals(cpf) && user.getSenha() == senha) {
                return user;
            }
        }
        return null;
    }
}
