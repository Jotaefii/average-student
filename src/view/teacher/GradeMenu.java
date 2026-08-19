package view.teacher;

import entities.Bulletin;
import entities.Student;
import excepetions.BusinessException;
import service.BulletinService;
import service.StudentService;
import util.InputUtils;

import java.util.Scanner;

public class GradeMenu {
    private final BulletinService bulletinService;
    private final StudentService studentService;

    public GradeMenu(BulletinService bulletinService, StudentService studentService) {
        this.bulletinService = bulletinService;
        this.studentService = studentService;
    }

    public void startGrade(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("            GERENCIAR NOTAS                  ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Lançar Nota");
            System.out.println("2 - Consultar Notas");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            switch (opcao) {
                case 1:
                    String cpfSearch = InputUtils.readNumbers(sc, "Busque aluno pelo CPF: ");

                    try {
                        Student student = studentService.searchStudentByCpf(cpfSearch);

                        Bulletin bulletin = student.getBulletin();

                        System.out.println("\nAluno(a): " + student.getNome());
                        System.out.println("---------------------------------------------");
                        System.out.println("\nBIMESTRES DISPONÍVEIS");
                        System.out.println("---------------------------------------------");

                        if (bulletin.getFirstGrade() == null) {
                            System.out.println("[1] 1° Bimestre");
                        }
                        if (bulletin.getSecondGrade() == null) {
                            System.out.println("[2] 2° Bimestre");
                        }
                        if (bulletin.getThirdGrade() == null) {
                            System.out.println("[3] 3° Bimestre");
                        }
                        if (bulletin.getFourthGrade() == null) {
                            System.out.println("[4] 4° Bimestre");
                        }

                        System.out.println("---------------------------------------------");

                        int monthPeriod = InputUtils.readInt(sc, "Escolha o bimestre: ");

                        double note = InputUtils.readDouble(sc, "Nota do " + monthPeriod + " bimesstre: ");

                        bulletinService.launchGrade(student, monthPeriod, note);
                        System.out.println("Nota lançada com sucesso!");
                    }
                    catch (BusinessException e) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    String cpfSearch1 = InputUtils.readNumbers(sc, "Busque pelo CPF: ");

                    try {
                        Student student1 = studentService.searchStudentByCpf(cpfSearch1);
                        System.out.println(student1.getBulletin().showGrades());
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
