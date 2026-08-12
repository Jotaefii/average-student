package view.management;

import entities.SchoolClass;
import entities.Student;
import service.SchoolClassService;
import service.StudentService;

import java.util.Scanner;

public class StudentManagementMenu {
    private final StudentService studentService;
    private final SchoolClassService schoolClassService;

    public StudentManagementMenu(StudentService studentService,  SchoolClassService schoolClassService) {
        this.studentService = studentService;
        this.schoolClassService = schoolClassService;
    }

    public void start(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("          GERENCIAR ESTUDANTES               ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Cadastrar Aluno(a)");
            System.out.println("2 - Buscar Aluno(a)");
            System.out.println("3 - Listar Aluno(a)");
            System.out.println("4 - Atualizar Aluno(a)");
            System.out.println("5 - Remover Aluno(a)");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> registerStudent(sc);
                case 2 -> searchStudent(sc);
                case 3 -> listStudent(sc);
                case 4 -> editStudent(sc);
                case 5 -> deleteStudent(sc);
                default -> opcao = 0;
            }
        }
    }

    private void registerStudent(Scanner sc) {
        System.out.print("Digite o nome do aluno(a): ");
        String nome = sc.nextLine();
        System.out.print("Digite o CPF do aluno(a): ");
        String cpf = sc.nextLine();
        System.out.print("Crie a senha do aluno(a): ");
        int senha = sc.nextInt();
        sc.nextLine();

        System.out.print("Adicionar " + nome + " na sala: ");
        int sala = sc.nextInt();

        SchoolClass schoolClass = schoolClassService.buscarTurma(sala);

        studentService.addStudent(nome, cpf, senha, schoolClass);
        System.out.println("Aluno adicionado com sucesso!");
    }

    private void searchStudent(Scanner sc) {
        System.out.print("Busque por nome do aluno(a): ");
        String nome = sc.nextLine();

        System.out.println("---------------------------------------------");

        Student students = studentService.searchStudentByNome(nome);

        System.out.println(students);
        System.out.println("---------------------------------------------");
    }

    private void listStudent(Scanner sc) {
        System.out.print("Deseja listar aluno(a) por sala? (S/N): ");
        char escolha = sc.next().charAt(0);

        System.out.println("---------------------------------------------");

        if (escolha == 'N' || escolha == 'n') {
            for (Student student : studentService.listAllStudents()) {
                System.out.println(student.getNome() + " | " + student.getSchoolClass().getNomeTurma() + " - " + student.getSchoolClass().getSala());
            }
            System.out.println("---------------------------------------------");
        } else {
            System.out.print("Busque alunos da sala: ");
            int sala = sc.nextInt();
            System.out.println();

            System.out.println("ALUNOS(A)");
            System.out.println("---------------------------------------------");

            for (Student student : studentService.listAllStudentsBySchool(sala)) {
                System.out.println(" - " + student.getNome());
            }
            System.out.println("---------------------------------------------");
        }
    }

    private void editStudent(Scanner sc) {
        System.out.print("Digite o CPF do aluno(a): ");
        String cpf = sc.nextLine();

        System.out.println("---------------------------------------------");

        Student student = studentService.searchStudentByCpf(cpf);
        if (student == null) {
            System.out.println("Nenhum aluno(a) encontrado!");
            return;
        }
        System.out.println(student);
        System.out.println("Senha: ********");

        System.out.println("---------------------------------------------");

        System.out.println("1 - Alterar nome");
        System.out.println("2 - Alterar senha");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        System.out.println("---------------------------------------------");

        switch (opcao) {
            case 1:
                System.out.print("Novo nome do aluno(a): ");
                String novoNome = sc.nextLine();
                student.setNome(novoNome);
                boolean editouNome = studentService.editStudent(cpf, student);

                if (editouNome) {
                    System.out.println("Nome alterado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno(a) encontrado!");
                }
                break;

            case 2:
                System.out.print("Novo senha do aluno(a): ");
                int novaSenha = sc.nextInt();
                student.setSenha(novaSenha);
                boolean editouSenha = studentService.editStudent(cpf, student);

                if (editouSenha) {
                    System.out.println("Senha alterado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno(a) encontrado!");
                }
                break;
        }
    }

    private void deleteStudent(Scanner sc) {
        System.out.print("Buscar aluno(a) pelo CPF: ");
        String cpf = sc.nextLine();

        System.out.println("---------------------------------------------");

        Student student = studentService.searchStudentByCpf(cpf);

        if (student == null) {
            System.out.println("Nenhum aluno(a) encontrado!");
            return;
        }

        System.out.println(student);
        System.out.println("Senha: ********");

        System.out.println("---------------------------------------------");

        System.out.print("Deseja realmente excluir esse aluno(a)? (S/N): ");
        char escolha = sc.next().charAt(0);

        if (escolha == 'N' || escolha == 'n') {
            System.out.println("Exclusão cancelada");
            return;
        }

        boolean excluiu = studentService.deleteStudent(cpf);
        if (excluiu) {
            System.out.println(student.getNome() + " excluido(a) com sucesso!");
        } else {
            System.out.println("Erro ao excluir");
        }
    }
}
