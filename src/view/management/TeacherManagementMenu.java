package view.management;

import entities.SchoolClass;
import entities.Teacher;
import service.SchoolClassService;
import service.TeacherService;

import java.util.Scanner;

public class TeacherManagementMenu {
    private final TeacherService teacherService;
    private final SchoolClassService schoolClassService;

    public TeacherManagementMenu(TeacherService teacherService, SchoolClassService schoolClassService) {
        this.teacherService = teacherService;
        this.schoolClassService = schoolClassService;
    }

    public void start(Scanner sc) {
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("=====================================");
            System.out.println("          GERENCIAR PROFESSORES      ");
            System.out.println("=====================================");

            System.out.println("1 - Cadastrar Professor(a)");
            System.out.println("2 - Buscar Professor(a)");
            System.out.println("3 - Listar Professor(a)");
            System.out.println("4 - Atualizar Professor(a)");
            System.out.println("5 - Remover Professor(a)");
            System.out.println("0 - Voltar");

            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> registerTeacher(sc);
                case 2 -> searchTeacher(sc);
                case 3 -> listTeacher();
                case 4 -> updateTeacher(sc);
                case 5 -> deleteTeacher(sc);
                default -> opcao = 0;
            }
        }
    }

    private void registerTeacher(Scanner sc) {
        System.out.print("Professor(a): ");
        String nameTeacher = sc.nextLine();
        System.out.print("CPF do professor(a): ");
        String cpfTeacher = sc.next();
        System.out.print("Crie a senha: ");
        int password = sc.nextInt();
        System.out.print("Adicionar " + nameTeacher + " na sala: ");
        int room = sc.nextInt();

        SchoolClass schoolClass = schoolClassService.buscarTurma(room);

        teacherService.addTeacher(nameTeacher, cpfTeacher, password, schoolClass);
        System.out.println("Professor(a) adicionado com sucesso!");
    }

    private void searchTeacher(Scanner sc) {
        System.out.print("Busque por nome do professor(a): ");
        String nameSearch = sc.nextLine();

        Teacher teacher = teacherService.searchTeacherByName(nameSearch);

        System.out.println(teacher.toString());
    }

    private void listTeacher() {
        for (Teacher teacher : teacherService.teacherList()) {
            System.out.println(teacher.getNome() + " | " + teacher.getClasse().getNomeTurma() + " - " + teacher.getClasse().getSala());
        }
    }

    private void updateTeacher(Scanner sc) {
        System.out.print("Buscar pelo CPF: ");
        String cpf = sc.next();

        Teacher teacher = teacherService.searchTeacherByCpf(cpf);

        if (teacher == null) {
            System.out.println("Professor(a) não encontrado!");
            return;
        }

        System.out.print(teacher);
        System.out.println("Senha: ********");

        System.out.println("1 - Alterar nome");
        System.out.println("2 - Alterar senha");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Novo nome: ");
                String newName = sc.nextLine();
                teacher.setNome(newName);

                boolean editedName = teacherService.editTeacher(cpf, teacher);
                if (editedName) {
                    System.out.println("Nome editado com sucesso!");
                } else {
                    System.out.println("Erro ao editar nome!");
                }
                break;

            case 2:
                System.out.print("Nova senha: ");
                int newPassaword = sc.nextInt();
                teacher.setSenha(newPassaword);

                boolean editedPassword = teacherService.editTeacher(cpf, teacher);
                if (editedPassword) {
                    System.out.println("Senha editada com sucesso!");
                } else {
                    System.out.println("Erro ao editar senha");
                }
                break;
        }
    }

    private void deleteTeacher(Scanner sc) {
        System.out.print("Buscar pelo CPF: ");
        String cpf = sc.next();

        Teacher teacher = teacherService.searchTeacherByCpf(cpf);

        if (teacher == null) {
            System.out.println("Professor(a) não encontrado!");
            return;
        }
        System.out.print(teacher);
        System.out.println("Senha: ********");

        System.out.println();
        System.out.print("Tem certeza que deseja excluir " + teacher.getNome() + "? (S/N): ");
        char escolha = sc.next().charAt(0);

        if (escolha == 'N' || escolha == 'n') {
            System.out.println("Exclusão cancelada!");
            return;
        }

        boolean exlcuiu = teacherService.deleteTeacher(cpf);
        if (exlcuiu) {
            System.out.println(teacher.getNome() + " excluido(a) com sucesso!");
        } else {
            System.out.println("Erro ao excluir");
        }
    }
}
