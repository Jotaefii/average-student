package entities;

import entities.enums.UserType;

public class Teacher extends User {
    private SchoolClass classe;

    public Teacher(String nome, String cpf, int senha, UserType userType) {
        super(nome, cpf, senha, userType);
    }

    public SchoolClass getClasse() {
        return classe;
    }

    public void setClasse(SchoolClass classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome()
                + "Turma: " + this.classe
                + "\n";
    }
}
