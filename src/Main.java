import entities.User;
import entities.enums.UserType;
import repository.SchoolClassRepository;
import repository.UserRepository;
import service.AuthenticateLogin;
import service.ManagementService;
import view.MenuManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        UserRepository userRepository = new UserRepository();
        SchoolClassRepository schoolClassRepository = new SchoolClassRepository();
        ManagementService managementService = new ManagementService(userRepository, schoolClassRepository);

        int opcao = 0;
        while (opcao != 2){
            System.out.println("1 - Entrar");
            System.out.println("2 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite seu cpf: ");
                    String cpf = sc.nextLine();
                    System.out.print("Digite sua senha: ");
                    int senha = sc.nextInt();
                    sc.nextLine();

                    User user = AuthenticateLogin.autenticar(userRepository.listar(), cpf, senha);

                    assert user != null;
                    if (user.getTipoUsuario() == UserType.GESTOR) {
                        MenuManagement.menuManagement(sc, managementService, schoolClassRepository);
                    } else if (user.getTipoUsuario() == UserType.PROFESSOR) {
                        // Show professor menu
                    } else if (user.getTipoUsuario() == UserType.ALUNO) {
                        // Show student menu
                    } else {
                        System.out.println("Tipo de usuário desconhecido!");
                    }
                    break;

                case 2:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}