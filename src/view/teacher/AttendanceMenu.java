package view.teacher;

import entities.Student;
import excepetions.BusinessException;
import service.BulletinService;
import service.StudentService;
import util.InputUtils;

import java.util.Scanner;

public class AttendanceMenu {
    private final BulletinService bulletinService;
    private final StudentService studentService;

    public AttendanceMenu(BulletinService bulletinService, StudentService studentService) {
        this.bulletinService = bulletinService;
        this.studentService = studentService;
    }

    public void startAttendance(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("          GERENCIAR FREQUÊNCIA               ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Registrar presença");
            System.out.println("2 - Consultar frequência");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            switch (opcao) {
                case 1:
                    String cpfSearch = InputUtils.readNumbers(sc, "Busque pelo CPF: ");

                    try {
                        Student student = studentService.searchStudentByCpf(cpfSearch);

                        System.out.println();
                        System.out.println("Aluno(a): " + student.getNome());
                        System.out.println("---------------------------------------------");

                        System.out.println("1 - Presente");
                        System.out.println("2 - Ausente");

                        int option = InputUtils.readInt(sc, "Situação: ");
                        System.out.println("---------------------------------------------");

                        if (option == 1) {
                            bulletinService.registerAttendance(student, true);
                            System.out.println("Presença registrada!");
                        } else if (option == 2) {
                            bulletinService.registerAttendance(student, false);
                            System.out.println("Falta registrada!");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                    catch (BusinessException e) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    String cpfSearch1 = InputUtils.readNumbers(sc, "Busque aluno(a) pelo CPF: ");

                    try {
                        Student student1 = studentService.searchStudentByCpf(cpfSearch1);
                        System.out.println(student1.getBulletin().showAttendance());
                    }
                    catch (BusinessException e) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
