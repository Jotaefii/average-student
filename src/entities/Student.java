package entities;

import entities.enums.UserType;

public class Student extends User {
    public Student(String nome, String cpf, int senha, UserType userType) {
        super(nome, cpf, senha, userType);
    }
}
