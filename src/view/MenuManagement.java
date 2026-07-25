package view;

import entities.Student;
import entities.Teacher;
import entities.enums.UserType;
import repository.SchoolClassRepository;
import service.ManagementService;

import java.util.Scanner;

public class MenuManagement {
    public static void menuManagement(Scanner sc, ManagementService managementService, SchoolClassRepository classRepository) {
        System.out.println();
        System.out.println("=====================");
        System.out.println("     MENU GESTAO");
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

        switch (opcao) {
            case 1:
                System.out.print("Crie o nome da turma: ");
                String nomeTurma = sc.nextLine();
                System.out.print("Crie o numero da sala: ");
                int sala = sc.nextInt();
                sc.nextLine();

                classRepository.adicionarClasse(nomeTurma, sala);
                System.out.println("Turma criada!");
                break;

            case 2:
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Cadastrar professor");
                int opcaoCadastro = sc.nextInt();
                sc.nextLine();

                if (opcaoCadastro == 1) {
                    System.out.print("Nome do aluno(a): ");
                    String nomeAluno = sc.nextLine();
                    System.out.print("CPF do aluno(a): ");
                    String cpfAluno = sc.next();
                    System.out.print("Senha do aluno(a): ");
                    int senhaAluno = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Escolha a sala do aluno(a): ");
                    int salaEscolhida = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(nomeAluno, cpfAluno, senhaAluno, UserType.ALUNO);
                    managementService.cadastrarAluno(student, salaEscolhida);
                } else if (opcaoCadastro == 2) {
                    System.out.print("Nome do professor(a): ");
                    String nomeProfessor = sc.nextLine();
                    System.out.print("CPF do professor(a): ");
                    String cpfProfessor = sc.next();
                    System.out.print("Senha do professor(a): ");
                    int senhaProfessor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Escolha a turma do professor(a): ");
                    int salaEscolhida = sc.nextInt();
                    sc.nextLine();

                    Teacher teacher = new Teacher(nomeProfessor, cpfProfessor, senhaProfessor, UserType.PROFESSOR);
                    managementService.cadastrarProfessor(teacher, salaEscolhida);
                } else {
                    System.out.println("Opção inválida!");
                }
                break;
        }
    }
}