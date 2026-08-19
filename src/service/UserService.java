package service;

import repository.ManagerRepository;
import repository.StudentRepository;
import repository.TeacherRepository;

public class UserService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final ManagerRepository managerRepository;

    public UserService(StudentRepository studentRepository, TeacherRepository teacherRepository, ManagerRepository managerRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.managerRepository = managerRepository;
    }

    public boolean cpfExists(String cpf) {
        return studentRepository.searchStudentByCpf(cpf) != null
                || teacherRepository.searchTeacherByCpf(cpf) != null
                || managerRepository.findByCpf(cpf) != null;
    }
}
