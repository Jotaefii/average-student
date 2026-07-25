package service;

import entities.SchoolClass;
import entities.Student;
import entities.Teacher;
import entities.User;
import entities.enums.UserType;
import repository.SchoolClassRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class ManagementService {
    private final UserRepository userRepository;
    private final SchoolClassRepository schoolClassRepository;

    public ManagementService(UserRepository userRepository, SchoolClassRepository schoolClassRepository) {
        this.userRepository = userRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    public void cadastrarAluno(Student student, int sala) {
        userRepository.adicionar(student);
        SchoolClass classe = schoolClassRepository.buscarPorSala(sala);

        if (classe == null){
            System.out.println("Turma não encontrada!");
            return;
        }
        classe.adicionarEstudante(student);
        student.setSchoolClass(classe);
    }

    public void cadastrarProfessor(Teacher teacher, int sala) {
        userRepository.adicionar(teacher);
        SchoolClass classe = schoolClassRepository.buscarPorSala(sala);

        if (classe == null){
            System.out.println("Turma não encontrada!");
            return;
        }
        classe.setTeacher(teacher);
        teacher.setClasse(classe);
    }

    public List<SchoolClass> listarTurmas() {
        return schoolClassRepository.listClasses();
    }

    public List<Teacher> listarProfessores() {
        List<Teacher> professores = new ArrayList<>();

        for (User prof : userRepository.listar()){
            if (prof.getTipoUsuario() == UserType.PROFESSOR){
                professores.add((Teacher) prof);
            }
            return professores;
        }
        return null;
    }

    public List<Student> listarEstudantes() {
        List<Student> estudantes = new ArrayList<>();

        for (User estudante : userRepository.listar()){
            if (estudante.getTipoUsuario() == UserType.ALUNO){
                estudantes.add((Student) estudante);

            }
        }
        return estudantes;
    }
}
