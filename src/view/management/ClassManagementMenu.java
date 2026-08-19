package view.management;

import entities.SchoolClass;
import excepetions.BusinessException;
import service.SchoolClassService;
import util.InputUtils;

import java.util.Scanner;

public class ClassManagementMenu {
    private final SchoolClassService turmaService;

    public ClassManagementMenu(SchoolClassService classService) {
        this.turmaService = classService;
    }

    public void start(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("            GERENCIAR TURMAS                 ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Criar Turma");
            System.out.println("2 - Buscar Turma");
            System.out.println("3 - Listar Turmas");
            System.out.println("4 - Atualizar Turma");
            System.out.println("5 - Excluir Turma");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            switch (opcao) {

            case 1 -> createClass(sc);
            case 2 -> searchClass(sc);
            case 3 -> listClasses();
            case 4 -> updateClass(sc);
            case 5 -> deleteClass(sc);
            case 0 -> {
                    return;
                }
            default -> System.out.println("Opcão inválida!");

            }
        }
    }

    private void createClass(Scanner sc) {
        String nomeTurma = InputUtils.readName(sc, "Criar nome da turma: ");

        int sala = InputUtils.readInt(sc, "Número da sala: ");

        try {
            turmaService.criarTurma(nomeTurma, sala);
            System.out.println("Turma criada com sucesso!");
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchClass(Scanner sc) {
        int salaBusca = InputUtils.readInt(sc, "Buscar por sala: ");

        System.out.println("---------------------------------------------");

        try {
            SchoolClass turma = turmaService.buscarTurma(salaBusca);
            System.out.println(turma.toString());
        }
        catch (BusinessException e) {
            System.out.println("Errror: " + e.getMessage());
        }
    }

    private void listClasses() {
        System.out.println("---------------------------------------------");

        for (SchoolClass turma : turmaService.listarTurmas()) {
            System.out.println(turma);
            System.out.println();
        }

        System.out.println("---------------------------------------------");
    }

    private void updateClass(Scanner sc) {
        int salaBusca = InputUtils.readInt(sc, "Buscar por sala: ");

        System.out.println("---------------------------------------------");

        try {
            SchoolClass turma = turmaService.buscarTurma(salaBusca);

            System.out.printf("Turma de %s, sala %d encontrada!%n", turma.getNomeTurma(), turma.getSala());
            String novoNomeTurma = InputUtils.readName(sc, "Novo nome: ");

            boolean editou = turmaService.editaTurma(novoNomeTurma, salaBusca);
            if (editou) {
                System.out.println("Turma atualizada com sucesso!");
            } else {
                System.out.println("Error ao atualizar turma!");
            }
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteClass(Scanner sc) {
        int salaBusca = InputUtils.readInt(sc, "Buscar por sala: ");

        System.out.println("---------------------------------------------");

        try {
            SchoolClass turma = turmaService.buscarTurma(salaBusca);

            System.out.println(turma);
            System.out.println("---------------------------------------------");

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
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
