package view;

import java.util.Scanner;

public class MenuManagement {
    public static void menuManagement(Scanner sc) {
        System.out.println();
        System.out.println("=====================");
        System.out.println("     MENU GESTAO"     );
        System.out.println("=====================");
        System.out.println("1 - Criar turma");
        System.out.println("2 - Cadastrar");
        System.out.println("3 - Listar");
        System.out.println("4 - Consultar");
        System.out.println("5 - Atualizar");
        System.out.println("6 - Deletar");
        System.out.println("7 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao){
            case 1:
                // Implementar criar turma
                break;
        }
    }
}
