package repository;

import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> teacherList() {
        return teachers;
    }

    public Teacher searchTeacherByCpf(String cpf) {
        for (Teacher teacher : teachers) {
            if (teacher.getCpf().equals(cpf)) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher searchTeacherByName(String nome) {
        for (Teacher teacher : teachers) {
            if (teacher.getNome().equalsIgnoreCase(nome)){
                return teacher;
            }
        }
        return null;
    }

    public boolean editTeacher(String cpf, Teacher newTeacher) {
        Teacher teacher = searchTeacherByCpf(cpf);

        if (teacher != null){
            teacher.setNome(newTeacher.getNome());
            teacher.setSenha(newTeacher.getSenha());
            return true;
        }
        return false;
    }

    public boolean deleteTeacher(String cpf) {
        Teacher teacher = searchTeacherByCpf(cpf);

        if (teacher != null){
            teachers.remove(teacher);
            return true;
        }
        return false;
    }
}
