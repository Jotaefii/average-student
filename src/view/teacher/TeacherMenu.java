package view.teacher;

import java.util.Scanner;

public class TeacherMenu {

    public void star(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("=====================================");
            System.out.println("            MENU DO PROFESSOR        ");
            System.out.println("=====================================");

            System.out.println("1 - Minha Turma");
            System.out.println("2 - Gerenciar Notas");
            System.out.println("3 - Gerenciar Frequência");
            System.out.println("4 - Consultar Alunos");
            System.out.println("5 - Meu Perfil");
            System.out.println("0 - Sair");

            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
        }
    }
}
