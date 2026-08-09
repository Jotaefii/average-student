package view.teacher;

import entities.Student;
import service.BulletinService;
import service.StudentService;

import java.util.Scanner;

public class GradeMenu {
    private final BulletinService bulletinService;
    private final StudentService studentService;

    public GradeMenu(BulletinService bulletinService, StudentService studentService) {
        this.bulletinService = bulletinService;
        this.studentService = studentService;
    }

    public void startGrade(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("            GERENCIAR NOTAS                  ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Lançar Nota");
            System.out.println("2 - Consultar Notas");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Busque aluno pelo CPF: ");
                    String cpfSearch = sc.next();

                    Student student = studentService.searchStudentByCpf(cpfSearch);

                    if (student == null) {
                        System.out.println("Aluno(a) não encontrado!");
                        break;
                    }

                    System.out.print("Escolher o bimestre (1 - 4): ");
                    int monthPeriod = sc.nextInt();

                    System.out.print("Nota do " + monthPeriod + " bimestre: ");
                    double note = sc.nextDouble();

                    bulletinService.launchGrade(student, monthPeriod, note);
                    break;

                case 2:
                    System.out.print("Busque pelo CPF: ");
                    String cpfSearch1 = sc.next();

                    Student student1 = studentService.searchStudentByCpf(cpfSearch1);

                    if (student1 == null) {
                        System.out.println("Aluno(a) não encontrado!");
                        break;
                    }

                    System.out.println(student1.getBulletin().showGrades());
                    break;
            }
        }
    }
}
