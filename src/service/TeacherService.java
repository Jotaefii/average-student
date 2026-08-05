package service;

import entities.SchoolClass;
import entities.Teacher;
import repository.SchoolClassRepository;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SchoolClassRepository schoolClassRepository;

    public TeacherService(TeacherRepository teacherRepository, SchoolClassRepository schoolClassRepository) {
        this.teacherRepository = teacherRepository;
        this.schoolClassRepository = schoolClassRepository;
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
        Teacher teacher = teacherRepository.searchTeacherByCpf(cpf);

        if (teacher == null) {
            return false;
        }

        for (SchoolClass schoolClass : schoolClassRepository.listClasses()) {
            if (schoolClass.getTeacher() != null && schoolClass.getTeacher().equals(teacher)) {
                schoolClass.setTeacher(null);
            }
        }
        return teacherRepository.deleteTeacher(cpf);
    }
}
