package repository;

import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> listAllStudents() {
        return students;
    }

    public List<Student> listStudentsByClassroom(int sala) {
        List<Student> studentsByClassroom = new ArrayList<>();
        for (Student student : students) {
            if (student.getSchoolClass().getSala() == sala) {
                studentsByClassroom.add(student);
            }
        }
        return studentsByClassroom;
    }

    public Student searchStudentByCpf(String cpf) {
        for (Student student : students) {
            if (student.getCpf().equals(cpf)) {
                return student;
            }
        }
        return null;
    }

    public Student searchStudentByName(String nome) {
        for (Student student : students) {
            if (student.getNome().equalsIgnoreCase(nome)) {
                return student;
            }
        }
        return null;
    }

    public boolean editStudent(String cpf, Student newstudent) {
        Student student = searchStudentByCpf(cpf);

        if (student != null) {
            student.setNome(newstudent.getNome());
            student.setSenha(newstudent.getSenha());
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String cpf) {
        Student student = searchStudentByCpf(cpf);

        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
