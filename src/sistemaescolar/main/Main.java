package sistemaescolar.main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        ArrayList<String> alunos = new ArrayList<>();

        do {
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos");
            System.out.println("[3] Remover aluno");
            System.out.println("[0] Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

        } while(opcao != 0);
    }
}