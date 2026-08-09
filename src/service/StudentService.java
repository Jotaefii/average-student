package service;

import entities.Bulletin;
import entities.SchoolClass;
import entities.Student;
import entities.enums.UserRole;
import repository.SchoolClassRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public StudentService(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    public void addStudent(String nome, String cpf, int senha, SchoolClass schoolClass) {
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
        return studentRepository.searchStudentByCpf(cpf);
    }

    public Student searchStudentByNome(String nome) {
        return studentRepository.searchStudentByName(nome);
    }

    public boolean editStudent(String cpf, Student student) {
        return studentRepository.editStudent(cpf, student);
    }

    public boolean deleteStudent(String cpf) {

        Student student = studentRepository.searchStudentByCpf(cpf);

        if (student == null) {
            return false;
        }

        for (SchoolClass schoolClass : schoolClassRepository.listClasses()) {
            schoolClass.getEstudantes().remove(student);
        }
        return studentRepository.deleteStudent(cpf);
    }
}
