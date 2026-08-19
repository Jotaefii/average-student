package service;

import entities.Management;
import entities.Student;
import entities.Teacher;
import entities.User;
import excepetions.BusinessException;
import repository.ManagerRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import util.CpfValidator;
import util.PasswordValidator;

public class AuthenticateLogin {

    private final ManagerRepository managerRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public AuthenticateLogin(ManagerRepository managerRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.managerRepository = managerRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public User login(String cpf, String password) {
        if (!CpfValidator.isValid(cpf)) {
            throw new BusinessException("CPF inválido!");
        }

        if (!PasswordValidator.isValid(password)) {
            throw new BusinessException("Senha inválida!");
        }

        Management management = managerRepository.findByCpf(cpf);

        if (management != null && management.getSenha().equals(password)) {
            return management;
        }

        Teacher teacher = teacherRepository.searchTeacherByCpf(cpf);

        if (teacher != null && teacher.getSenha().equals(password)) {
            return teacher;
        }

        Student student = studentRepository.searchStudentByCpf(cpf);

        if (student != null && student.getSenha().equals(password)) {
            return student;
        }

        throw new BusinessException("CPF ou senha incorretos!");
    }
}
