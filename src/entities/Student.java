package entities;

import entities.enums.UserType;

public class Student extends User {
    private SchoolClass schoolClass;

    public Student(String nome, String cpf, int senha, UserType userType) {
        super(nome, cpf, senha, userType);
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "Aluno(a): " + this.getNome()
                + "\nTurma: " + this.getCpf()
                + "\n";
    }
}
