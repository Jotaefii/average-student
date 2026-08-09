package view.teacher;

import entities.Student;
import service.BulletinService;
import service.StudentService;

import java.util.Scanner;

public class AttendanceMenu {
    private final BulletinService bulletinService;
    private final StudentService studentService;

    public AttendanceMenu(BulletinService bulletinService, StudentService studentService) {
        this.bulletinService = bulletinService;
        this.studentService = studentService;
    }

    public void startAttendance(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("          GERENCIAR FREQUÊNCIA               ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Registrar presença");
            System.out.println("2 - Consultar frequência");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Busque pelo CPF: ");
                    String cpfSearch = sc.next();

                    Student student = studentService.searchStudentByCpf(cpfSearch);

                    if (student == null) {
                        System.out.println("Aluno(a)");
                        break;
                    }

                    System.out.println();
                    System.out.println("Aluno: " + student.getNome());

                    System.out.println("1 - Presente");
                    System.out.println("2 - Ausente");

                    System.out.print("Situação: ");
                    int option = sc.nextInt();
                    sc.nextLine();
                    
                    if (option == 1) {
                        bulletinService.registerAttendance(student, true);
                        System.out.println("Presença registrada!");
                    } else if (option == 2) {
                        bulletinService.registerAttendance(student, false);
                        System.out.println("Falta registrada!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.print("Busque aluno(a) pelo CPF: ");
                    String cpfSearch1 = sc.next();

                    Student student1 = studentService.searchStudentByCpf(cpfSearch1);

                    if (student1 == null) {
                        System.out.println("Aluno(a) não encontrado!");
                        break;
                    }

                    System.out.println(student1.getBulletin().showAttendance());
                    break;
            }
        }
    }
}
