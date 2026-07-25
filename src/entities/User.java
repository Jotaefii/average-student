package entities;

import entities.enums.UserType;

public abstract class User {
    private String nome;
    private String cpf;
    private int senha;
    private UserType tipoUsuario;

    public User(String nome, String cpf, int senha, UserType tipoUsuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public UserType getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UserType tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
