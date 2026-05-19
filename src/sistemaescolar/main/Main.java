package sistemaescolar.main;

import sistemaescolar.entities.Alunos;
import sistemaescolar.service.CadastroService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        CadastroService cadastro = new CadastroService();

        int opcao;

        do {
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("0 - Sair");

            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            sc.nextLine();
            System.out.println("----------------------------");

            switch (opcao){
                case 1:
                    System.out.print("Aluno: ");
                    String nome = sc.nextLine();

                    System.out.print("Codigo do aluno: ");
                    int codigo = sc.nextInt();

                    System.out.print("Primeira nota: ");
                    double nota1 = sc.nextDouble();

                    System.out.print("Segunda nota: ");
                    double nota2 = sc.nextDouble();

                    Alunos alunos = new Alunos(nome, nota1, nota2, codigo);

                    cadastro.adicionarAluno(alunos);
                    break;

                case 2:
                    cadastro.listarAlunos();
                    break;
            }
        } while (opcao != 0);
    }
}