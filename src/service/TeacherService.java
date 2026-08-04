package service;

import entities.SchoolClass;
import entities.Teacher;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher(String nome, String cpf, int senha, SchoolClass schoolClass) {
        Teacher teacher = new Teacher(nome, cpf, senha, schoolClass);
        schoolClass.setTeacher(teacher);
        teacherRepository.addTeacher(teacher);
    }

    public Teacher searchTeacherByCpf(String cpf) {
        return teacherRepository.searchTeacherByCpf(cpf);
    }

    public Teacher searchTeacherByName(String name) {
        return teacherRepository.searchTeacherByName(name);
    }

    public List<Teacher> teacherList() {
        return teacherRepository.teacherList();
    }

    public boolean editTeacher(String cpf, Teacher teacher) {
        return teacherRepository.editTeacher(cpf, teacher);
    }

    public boolean deleteTeacher(String cpf) {
        return teacherRepository.deleteTeacher(cpf);
    }
}
