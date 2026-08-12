package view.management;

import entities.Management;
import service.SchoolClassService;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class ManagementMenu {
    private final Management management;

    private final ClassManagementMenu classManagementMenu;
    private final StudentManagementMenu studentManagementMenu;
    private final TeacherManagementMenu teacherManagementMenu;

    public ManagementMenu(SchoolClassService classService, StudentService studentService, TeacherService teacherService, Management management) {
        this.classManagementMenu = new ClassManagementMenu(classService);
        this.studentManagementMenu = new StudentManagementMenu(studentService,  classService);
        this.teacherManagementMenu = new TeacherManagementMenu(teacherService, classService);
        this.management = management;
    }

    public void start(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("            Gestor(a) " + management.getNome());
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.println("Seu menu: ");

            System.out.println();
            System.out.println("1 - Gerenciar Turmas");
            System.out.println("2 - Gerenciar Professores");
            System.out.println("3 - Gerenciar Alunos");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> classManagementMenu.start(sc);
                case 2 -> teacherManagementMenu.start(sc);
                case 3 -> studentManagementMenu.start(sc);
                default -> opcao = 0;
            }
        }
    }
}