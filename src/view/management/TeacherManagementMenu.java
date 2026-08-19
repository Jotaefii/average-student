package view.management;

import entities.SchoolClass;
import entities.Teacher;
import excepetions.BusinessException;
import service.SchoolClassService;
import service.TeacherService;
import util.InputUtils;

import java.util.Scanner;

public class TeacherManagementMenu {
    private final TeacherService teacherService;
    private final SchoolClassService schoolClassService;

    public TeacherManagementMenu(TeacherService teacherService, SchoolClassService schoolClassService) {
        this.teacherService = teacherService;
        this.schoolClassService = schoolClassService;
    }

    public void start(Scanner sc) {
        while (true) {
            System.out.println();
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("          GERENCIAR PROFESSORES              ");
            System.out.println("╚═══════════════════════════════════════════╝");

            System.out.println("1 - Cadastrar Professor(a)");
            System.out.println("2 - Buscar Professor(a)");
            System.out.println("3 - Listar Professor(a)");
            System.out.println("4 - Atualizar Professor(a)");
            System.out.println("5 - Remover Professor(a)");
            System.out.println("0 - Voltar");

            System.out.println("═════════════════════════════════════════════");
            int opcao = InputUtils.readInt(sc, "Escolha: ");

            switch (opcao) {
                case 1 -> registerTeacher(sc);
                case 2 -> searchTeacher(sc);
                case 3 -> listTeacher();
                case 4 -> updateTeacher(sc);
                case 5 -> deleteTeacher(sc);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void registerTeacher(Scanner sc) {
        String nameTeacher = InputUtils.readName(sc, "Nome do Professor(a): ");
        String cpfTeacher = InputUtils.readNumbers(sc, "CPF do professor(a): ");
        String password = InputUtils.readNumbers(sc, "Crie a senha: ");

        int room = InputUtils.readInt(sc, "Adicionar " + nameTeacher + " na sala: ");

        try {
            SchoolClass schoolClass = schoolClassService.buscarTurma(room);

            teacherService.addTeacher(nameTeacher, cpfTeacher, password, schoolClass);
            System.out.println("Professor(a) adicionado com sucesso!");
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchTeacher(Scanner sc) {
        String nameSearch = InputUtils.readName(sc, "Busque por nome do professor(a): ");

        System.out.println("---------------------------------------------");

        try {
            Teacher teacher = teacherService.searchTeacherByName(nameSearch);
            System.out.println(teacher.toString());
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listTeacher() {
        System.out.println("---------------------------------------------");

        for (Teacher teacher : teacherService.teacherList()) {
            System.out.println(teacher.getNome() + " | " + teacher.getClasse().getNomeTurma() + " - " + teacher.getClasse().getSala());
        }

        System.out.println("---------------------------------------------");
    }

    private void updateTeacher(Scanner sc) {
        String cpf = InputUtils.readNumbers(sc, "Buscar pelo CPF: ");

        System.out.println("---------------------------------------------");

        try {
            Teacher teacher = teacherService.searchTeacherByCpf(cpf);

            System.out.println(teacher);
            System.out.println("Senha: ********");

            System.out.println("---------------------------------------------");

            System.out.println("1 - Alterar nome");
            System.out.println("2 - Alterar senha");
            int opcao = InputUtils.readInt(sc, "Opção: ");

            System.out.println("---------------------------------------------");

            switch (opcao) {
                case 1:
                    String newName = InputUtils.readName(sc, "Novo nome: ");
                    teacher.setNome(newName);

                    boolean editedName = teacherService.editTeacher(cpf, teacher);
                    if (editedName) {
                        System.out.println("Nome editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar nome!");
                    }
                    break;

                case 2:
                    String newPassaword = InputUtils.readNumbers(sc, "Nova senha: ");
                    teacher.setSenha(newPassaword);

                    boolean editedPassword = teacherService.editTeacher(cpf, teacher);
                    if (editedPassword) {
                        System.out.println("Senha editada com sucesso!");
                    } else {
                        System.out.println("Erro ao editar senha");
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

    private void deleteTeacher(Scanner sc) {
        String cpf = InputUtils.readNumbers(sc, "Buscar pelo CPF: ");

        System.out.println("---------------------------------------------");

        try {
            Teacher teacher = teacherService.searchTeacherByCpf(cpf);

            System.out.println(teacher);
            System.out.println("Senha: ********");

            System.out.println("---------------------------------------------");

            System.out.print("Tem certeza que deseja excluir " + teacher.getNome() + "? (S/N): ");
            char escolha = sc.next().charAt(0);

            if (escolha == 'N' || escolha == 'n') {
                System.out.println("Exclusão cancelada!");
                return;
            }

            boolean exlcuiu = teacherService.deleteTeacher(cpf, teacher);
            if (exlcuiu) {
                System.out.println(teacher.getNome() + " excluido(a) com sucesso!");
            } else {
                System.out.println("Erro ao excluir");
            }
        }
        catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
