package view;

import repository.SchoolClassRepository;

import java.util.Scanner;

public class MenuManagement {
    public static void menuManagement(Scanner sc, SchoolClassRepository classRepository) {
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
                System.out.print("Crie o nome da turma: ");
                String nomeTurma = sc.nextLine();
                System.out.print("Crie o numero da sala: ");
                int sala = sc.nextInt();
                sc.nextLine();

                classRepository.addClass(nomeTurma, sala);
                System.out.println("Turma criada!");
                break;
        }
    }
}
