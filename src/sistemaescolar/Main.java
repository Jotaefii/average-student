package sistemaescolar;

import sistemaescolar.service.CadastroService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        CadastroService cadastro = new CadastroService();

        int opcao = 1;

        while (opcao != 0){
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao){
                case 1:
                    cadastro.adicionarAluno();
                    break;

                case 2:
                    cadastro.listarAlunos();
                    break;
            }
        }
    }
}