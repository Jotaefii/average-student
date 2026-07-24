package entities;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String nomeTurma;
    private Integer sala;
    private Teacher teacher;

    private List<Student> students = new ArrayList<>();

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
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
}
