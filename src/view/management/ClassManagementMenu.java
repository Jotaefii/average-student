package view.management;

import entities.SchoolClass;
import service.SchoolClassService;

import java.util.Scanner;

public class ClassManagementMenu {
    private final SchoolClassService turmaService;

    public ClassManagementMenu(SchoolClassService classService) {
        this.turmaService = classService;
    }

    public void start(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("=====================================");
            System.out.println("            GERENCIAR TURMAS         ");
            System.out.println("=====================================");

            System.out.println("1 - Criar Turma");
            System.out.println("2 - Buscar Turma");
            System.out.println("3 - Listar Turmas");
            System.out.println("4 - Atualizar Turma");
            System.out.println("5 - Excluir Turma");
            System.out.println("0 - Voltar");

            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

            case 1 -> createClass(sc);
            case 2 -> searchClass(sc);
            case 3 -> listClasses();
            case 4 -> updateClass(sc);
            case 5 -> deleteClass(sc);
            default -> opcao = 0;

            }
        }
    }

    private void createClass(Scanner sc) {
        System.out.print("Criar nome da turma: ");
        String nomeTurma = sc.nextLine();

        System.out.print("Numero da sala: ");
        int sala = sc.nextInt();

        turmaService.criarTurma(nomeTurma, sala);
    }

    private void searchClass(Scanner sc) {
        System.out.print("Buscar por sala: ");
        int salaBusca = sc.nextInt();

        SchoolClass turma = turmaService.buscarTurma(salaBusca);

        System.out.print(turma.toString());
    }

    private void listClasses() {
        for (SchoolClass turma : turmaService.listarTurmas()) {
            System.out.println(turma);
        }
    }

    private void updateClass(Scanner sc) {
        System.out.print("Buscar por sala: ");
        int salaBusca = sc.nextInt();
        sc.nextLine();

        SchoolClass turma = turmaService.buscarTurma(salaBusca);
        if (turma == null) {
            System.out.println("Nenhum Turma encontrada.");
            return;
        }

        System.out.printf("Turma de %s, sala %d encontrada!%n", turma.getNomeTurma(), turma.getSala());
        System.out.print("Novo nome: ");
        String novoNomeTurma = sc.nextLine();

        boolean editou = turmaService.editaTurma(novoNomeTurma, salaBusca);
        if (editou) {
            System.out.println("Turma atualizada com sucesso!");
        } else {
            System.out.println("Error ao atualizar turma!");
        }
    }

    private void deleteClass(Scanner sc) {
        System.out.print("Buscar por sala: ");
        int salaBusca = sc.nextInt();

        SchoolClass turma = turmaService.buscarTurma(salaBusca);
        if (turma == null) {
            System.out.println("Nenhum Turma encontrada.");
            return;
        }

        System.out.println(turma);
        System.out.print("Tem certeza que deseja excluir essa turma? (S/N): ");
        char escolha = sc.next().charAt(0);

        if (escolha == 's' || escolha == 'S') {
            boolean exlcuiu = turmaService.deletaTurma(salaBusca);
            if (exlcuiu) {
                System.out.println("Turma excluida com sucesso!");
            }  else {
                System.out.println("Error ao excluir turma!");
            }
        } else {
            System.out.println("Erro ao excluir turma!");
        }
    }
}
