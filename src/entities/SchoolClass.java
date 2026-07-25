package entities;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String nomeTurma;
    private Integer sala;
    private Teacher professor;

    private List<Student> estudantes = new ArrayList<>();

    public SchoolClass(String nomeTurma, Integer sala) {
        this.nomeTurma = nomeTurma;
        this.sala = sala;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Teacher getTeacher() {
        return professor;
    }

    public void setTeacher(Teacher professor) {
        this.professor = professor;
    }

    public List<Student> getEstudantes() {
        return estudantes;
    }

    public void adicionarEstudante(Student student) {
        this.estudantes.add(student);
    }

    public void removerEstudante(Student student) {
        this.estudantes.remove(student);
    }
}
