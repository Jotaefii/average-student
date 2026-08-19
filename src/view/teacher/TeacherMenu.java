package view.teacher;

import entities.Student;
import entities.Teacher;
import service.BulletinService;
import service.StudentService;
import util.InputUtils;

import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    private final Teacher teacher;

    private final StudentService studentService;

    private final GradeMenu gradeMenu;
    private final AttendanceMenu attendanceMenu;

    public TeacherMenu(BulletinService bulletinService, StudentService studentService, Teacher teacher) {
        this.gradeMenu = new GradeMenu(bulletinService, studentService);
        this.attendanceMenu = new AttendanceMenu(bulletinService, studentService);
        this.studentService = studentService;
        this.teacher = teacher;
    }

    public void start(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("       Professor(a) " + teacher.getNome()     );
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.println("Seu menu: ");

            System.out.println();
            System.out.println("1 - Minha Turma");
            System.out.println("2 - Gerenciar Notas");
            System.out.println("3 - Gerenciar Frequência");
            System.out.println("4 - Meu Perfil");
            System.out.println("5 - Ver boletim");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Escolha: ");

            switch (opcao) {
                case 1 -> myClass();
                case 2 -> gradeMenu.startGrade(sc);
                case 3 -> attendanceMenu.startAttendance(sc);
                case 4 -> myProfile();
                case 5 -> seeBulletin(sc);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opão inválida!");
            }
        }
    }

    private void myClass() {
        List<Student> students = teacher.getClasse().getEstudantes();

        System.out.println("\nDADOS DA TURMA");
        System.out.println("---------------------------------------------");
        System.out.println("Turma: " + teacher.getClasse().getNomeTurma() + " - " + teacher.getClasse().getSala());
        System.out.println("Professor(a): " + teacher.getNome());
        System.out.println("Quantidade de alunos: " + students.size());

        System.out.println("\nALUNOS");
        System.out.println("---------------------------------------------");

        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            int number = 1;

            for (Student student : students) {
                System.out.println("  " + number + " - " + student.getNome() + " | CPF: " + student.getCpf());
                number++;
            }
        }
        System.out.println("---------------------------------------------");
    }

    private void myProfile() {
        System.out.println("\nMEU PERFIL");
        System.out.println("---------------------------------------------");
        System.out.println("Nome: " + teacher.getNome());
        System.out.println("CPF: " + teacher.getCpf());
        System.out.println("Senha: " + teacher.getSenha());

        System.out.println("---------------------------------------------");

        if (teacher.getClasse() != null) {
            System.out.println("Turma: " + teacher.getClasse().getNomeTurma() + " - " + teacher.getClasse().getSala());
        } else {
            System.out.println("Turma: Nenhuma turma atribuída");
        }

        System.out.println("---------------------------------------------");
    }

    private void seeBulletin(Scanner sc) {
        String cpf = InputUtils.readNumbers(sc, "Busque o aluno(a) pelo CPF: ");

        Student student = studentService.searchStudentByCpf(cpf);

        if (student == null) {
            System.out.println("Aluno(a) não encontrado!");
            return;
        }
        System.out.println(student.getBulletin());
    }
}
