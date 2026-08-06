package service;

import entities.Management;
import entities.Student;
import entities.Teacher;
import entities.User;
import repository.ManagerRepository;
import repository.StudentRepository;
import repository.TeacherRepository;

public class AuthenticateLogin {

    private final ManagerRepository managerRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public AuthenticateLogin(ManagerRepository managerRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.managerRepository = managerRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public User login(String cpf, int password) {

        Management management = managerRepository.findByCpf(cpf);

        if (management != null && management.getSenha() == password) {
            return management;
        }

        Teacher teacher = teacherRepository.searchTeacherByCpf(cpf);

        if (teacher != null && teacher.getSenha() == password) {
            return teacher;
        }

        Student student = studentRepository.searchStudentByCpf(cpf);

        if (student != null && student.getSenha() == password) {
            return student;
        }

        return null;
    }
}
