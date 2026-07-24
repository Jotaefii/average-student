package entities;

import entities.enums.UserType;

public class Management extends User{
    public Management(String nome, String cpf, int senha, UserType userType) {
        super(nome, cpf, senha, userType);
    }
}
