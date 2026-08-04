package service;

import entities.SchoolClass;
import entities.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(String nome, String cpf, int senha, SchoolClass schoolClass) {
        Student student = new Student(nome, cpf, senha, schoolClass);
        schoolClass.adicionarEstudante(student);
        studentRepository.addStudent(student);
    }

    public List<Student> listAllStudents() {
        return studentRepository.listAllStudents();
    }

    public List<Student> listAllStudentsBySchool(int sala) {
        return studentRepository.listStudentsByClassroom(sala);
    }

    public Student searchStudentByCpf(String cpf) {
        return studentRepository.searchStudentByCpf(cpf);
    }

    public Student searchStudentByNome(String nome) {
        return studentRepository.searchStudentByName(nome);
    }

    public boolean editStudent(String cpf, Student student) {
        return studentRepository.editStudent(cpf, student);
    }

    public boolean deleteStudent(String cpf) {
        return studentRepository.deleteStudent(cpf);
    }
}
