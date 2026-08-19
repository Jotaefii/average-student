package view.student;

import entities.Student;
import util.InputUtils;

import java.util.Scanner;

public class StudentMenu {
    private final Student student;

    public StudentMenu(Student student) {
        this.student = student;
    }

    public void start(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("         Estudante " + student.getNome()      );
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.println("Seu menu: ");

            System.out.println();
            System.out.println("1 - Meu Perfil");
            System.out.println("2 - Minha Turma");
            System.out.println("3 - Ver Boletim");
            System.out.println("0 - Sair");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            switch (opcao) {
                case 1 -> myProfile();
                case 2 -> myClass();
                case 3 -> System.out.println(student.getBulletin());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void myProfile() {
        System.out.println("\nMEU PERFIL");
        System.out.println("---------------------------------------------");
        System.out.println("Nome: " + student.getNome());
        System.out.println("CPF: " + student.getCpf());
        System.out.println("Senha: " + student.getSenha());

        System.out.println("---------------------------------------------");
        System.out.println("Turma: " + student.getSchoolClass().getNomeTurma() + " - " + student.getSchoolClass().getSala());
        System.out.println("---------------------------------------------");
    }

    private void myClass() {
        System.out.println("\nDADOS DA TURMA");
        System.out.println("---------------------------------------------");

        System.out.println("Turma: " + student.getSchoolClass().getNomeTurma());
        System.out.println("Sala: " + student.getSchoolClass().getSala());
        System.out.println("Professor(a): " + student.getSchoolClass().getTeacher().getNome());

        System.out.println("---------------------------------------------");
    }
}
