package view;

import entities.SchoolClass;
import entities.Student;
import entities.Teacher;
import entities.enums.UserType;
import repository.SchoolClassRepository;
import service.ManagementService;

import java.util.Scanner;

public class MenuManagement {


    public static void menuManagement(Scanner sc, ManagementService managementService, SchoolClassRepository classRepository) {
        int opcao = 0;

        while (opcao != 7) {
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
            opcao = sc.nextInt();
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

                        Teacher professor = new Teacher(nomeProfessor, cpfProfessor, senhaProfessor, UserType.PROFESSOR);
                        managementService.cadastrarProfessor(professor, salaEscolhida);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:
                    System.out.println("1 - Listar turmas");
                    System.out.println("2 - Listar professores");
                    System.out.println("3 - Listar alunos");
                    int opcaoListar = sc.nextInt();

                    if (opcaoListar == 1) {
                        for (SchoolClass turma : managementService.listarTurmas()) {
                            System.out.println(turma);
                        }
                    } else if (opcaoListar == 2) {
                        for (Teacher professor :  managementService.listarProfessores()) {
                            System.out.println(professor);
                        }
                    } else if (opcaoListar == 3) {
                        for (Student estudante : managementService.listarEstudantes()) {
                            System.out.println(estudante);
                        }
                    } else {
                        System.out.println("Opção invalida!");
                    }
                    break;
            }
        }
    }
}