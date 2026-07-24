package entities;

import entities.enums.UserType;

public class Teacher extends User{
    public Teacher(String nome, String cpf, int senha, UserType userType) {
        super(nome, cpf, senha, userType);
    }
}
