package service;

import entities.SchoolClass;
import entities.Student;
import entities.Teacher;
import repository.SchoolClassRepository;
import repository.UserRepository;

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
}
