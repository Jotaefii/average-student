package view.management;

import entities.SchoolClass;
import entities.Student;
import excepetions.BusinessException;
import service.SchoolClassService;
import service.StudentService;
import util.InputUtils;

import java.util.Scanner;

public class StudentManagementMenu {
    private final StudentService studentService;
    private final SchoolClassService schoolClassService;

    public StudentManagementMenu(StudentService studentService,  SchoolClassService schoolClassService) {
        this.studentService = studentService;
        this.schoolClassService = schoolClassService;
    }

    public void start(Scanner sc) {
        while (true) {
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
            int opcao = InputUtils.readInt(sc, "Escolha: ");

            switch (opcao) {
                case 1 -> registerStudent(sc);
                case 2 -> searchStudent(sc);
                case 3 -> listStudent(sc);
                case 4 -> editStudent(sc);
                case 5 -> deleteStudent(sc);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void registerStudent(Scanner sc) {
        String nome = InputUtils.readName(sc, "Digite o nome do aluno(a): ");
        String cpf = InputUtils.readNumbers(sc, "Digite o CPF do aluno(a): ");
        String senha = InputUtils.readNumbers(sc, "Crie a senha do aluno(a): ");

        int sala = InputUtils.readInt(sc, "Adicionar " + nome + " na sala: ");

        SchoolClass schoolClass = schoolClassService.buscarTurma(sala);

        try {
            studentService.addStudent(nome, cpf, senha, schoolClass);
            System.out.println("Aluno(a) adicionado com sucesso!");
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchStudent(Scanner sc) {
        String nome = InputUtils.readName(sc, "Busque por nome do aluno(a): ");

        System.out.println("---------------------------------------------");

        try {
            Student students = studentService.searchStudentByNome(nome);
            System.out.println(students);
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
            int sala = InputUtils.readInt(sc, "Busque alunos(a) da sala: ");
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
        String cpf = InputUtils.readNumbers(sc, "digite o CPF do aluno(a): ");

        System.out.println("---------------------------------------------");

        try {
            Student student = studentService.searchStudentByCpf(cpf);

            System.out.println(student);
            System.out.println("Senha: ********");

            System.out.println("---------------------------------------------");

            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar senha");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            System.out.println("---------------------------------------------");

            switch (opcao) {
                case 1:
                    String novoNome = InputUtils.readName(sc, "Novo nome do aluno(a): ");
                    student.setNome(novoNome);
                    boolean editouNome = studentService.editStudent(cpf, student);

                    if (editouNome) {
                        System.out.println("Nome alterado com sucesso!");
                    } else {
                        System.out.println("Nenhum aluno(a) encontrado!");
                    }
                    break;

                case 2:
                    String novaSenha = InputUtils.readNumbers(sc, "Nova senha do aluno(a): ");
                    student.setSenha(novaSenha);
                    boolean editouSenha = studentService.editStudent(cpf, student);

                    if (editouSenha) {
                        System.out.println("Senha alterado com sucesso!");
                    } else {
                        System.out.println("Nenhum aluno(a) encontrado!");
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteStudent(Scanner sc) {
        String cpf = InputUtils.readNumbers(sc, "Buscar aluno(a) pelo CPF: ");

        System.out.println("---------------------------------------------");

        try {
            Student student = studentService.searchStudentByCpf(cpf);

            System.out.println(student);
            System.out.println("Senha: ********");

            System.out.println("---------------------------------------------");

            System.out.print("Deseja realmente excluir esse aluno(a)? (S/N): ");
            char escolha = sc.next().charAt(0);

            if (escolha == 'N' || escolha == 'n') {
                System.out.println("Exclusão cancelada");
                return;
            }

            boolean excluiu = studentService.deleteStudent(cpf, student);
            if (excluiu) {
                System.out.println(student.getNome() + " excluido(a) com sucesso!");
            } else {
                System.out.println("Erro ao excluir");
            }
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
