package view.management;

import service.SchoolClassService;
import service.StudentService;

import java.util.Scanner;

public class ManagementMenu {
    private final ClassMenu classMenu;
    private final StudentManagementMenu studentManagementMenu;

    public ManagementMenu(SchoolClassService classService, StudentService studentService) {
        this.classMenu = new ClassMenu(classService);
        this.studentManagementMenu = new StudentManagementMenu(studentService,  classService);
    }

    public void start(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("\n===== MENU GESTOR =====");
            System.out.println("1 - Gerenciar Turmas");
            System.out.println("2 - Gerenciar Alunos");
            System.out.println("3 - Gerenciar Professores");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> classMenu.start(sc);
                case 2 -> studentManagementMenu.start(sc);
            }
        }
    }
}