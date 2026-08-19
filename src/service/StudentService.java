package service;

import entities.Bulletin;
import entities.SchoolClass;
import entities.Student;
import entities.Teacher;
import entities.enums.UserRole;
import excepetions.BusinessException;
import repository.SchoolClassRepository;
import repository.StudentRepository;
import util.CpfValidator;
import util.PasswordValidator;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final UserService userService;

    public StudentService(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository, UserService userService) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.userService = userService;
    }

    public void addStudent(String nome, String cpf, String senha, SchoolClass schoolClass) {
        if (nome == null || nome.isBlank()) {
            throw new BusinessException("Nome não pode ficar vazio");
        }

        if (!CpfValidator.isValid(cpf)) {
            throw new BusinessException("CPF inválido!");
        }

        if (!PasswordValidator.isValid(senha)) {
            throw new BusinessException("Senha inválida!");
        }

        if (userService.cpfExists(cpf)) {
            throw new BusinessException("CPF já cadastro no sistema!");
        }

        Student student = new Student(nome, cpf, senha, schoolClass);

        student.setRole(UserRole.STUDENT);
        schoolClass.adicionarEstudante(student);

        Bulletin bulletin = new Bulletin();
        student.setBulletin(bulletin);
        bulletin.setStudent(student);

        studentRepository.addStudent(student);
    }

    public List<Student> listAllStudents() {
        return studentRepository.listAllStudents();
    }

    public List<Student> listAllStudentsBySchool(int sala) {
        return studentRepository.listStudentsByClassroom(sala);
    }

    public Student searchStudentByCpf(String cpf) {
        Student student = studentRepository.searchStudentByCpf(cpf);

        if (student == null) {
            throw new BusinessException("Nenhum aluno(a) com este CPF foi encontrado!");
        }

        return student;
    }

    public Student searchStudentByNome(String nome) {
        Student student = studentRepository.searchStudentByName(nome);

        if (student == null) {
            throw new BusinessException("Nenhum aluno(a) com este nome foi encontrado!");
        }

        return student;
    }

    public boolean editStudent(String cpf, Student student) {
        return studentRepository.editStudent(cpf, student);
    }

    public boolean deleteStudent(String cpf, Student student) {
        for (SchoolClass schoolClass : schoolClassRepository.listClasses()) {
            schoolClass.getEstudantes().remove(student);
        }
        return studentRepository.deleteStudent(cpf);
    }
}
