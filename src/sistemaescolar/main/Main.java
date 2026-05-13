package sistemaescolar.main;

import sistemaescolar.entities.Alunos;
import sistemaescolar.service.CadastroAluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        CadastroAluno cadastro = new CadastroAluno();

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

                    System.out.print("Primeira nota: ");
                    double nota1 = sc.nextDouble();

                    System.out.print("Segunda nota: ");
                    double nota2 = sc.nextDouble();

                    Alunos alunos = new Alunos(nome, nota1, nota2);

                    cadastro.adicionarAluno(alunos);
                    break;

                case 2:
                    cadastro.listarAlunos();
                    break;
            }
        } while (opcao != 0);
    }
}