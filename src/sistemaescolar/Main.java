package sistemaescolar;

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

            switch (opcao) {
                case 1:
                    if ( alunos.size() < 10) {
                        System.out.print("Aluno: ");
                        alunos.add(sc.nextLine());
                    } else {
                        System.out.println("Cadastro cheio!!");
                    }
                    System.out.println();
                    break;

                case 2:
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println("Aluno(a): " + alunos.get(i));
                    }
                    System.out.println();
                    break;

                case 3:
                    if (alunos.size() == 0){
                        System.out.println("Nenhum aluno cadastrado!");
                    } else {
                        for (int i = 0; i < alunos.size(); i++) {
                            System.out.println((i + 1) + " - " + alunos.get(i));
                        }
                    }

                    System.out.print("Digite o numero do aluno que quer remover: ");
                    int numero_do_aluno = sc.nextInt();
                    sc.nextLine();

                    if (numero_do_aluno >= 1 && numero_do_aluno <= alunos.size()){
                        alunos.remove(numero_do_aluno - 1);
                        System.out.println("Aluno removido!");
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;
            }
        } while(opcao != 0);
    }
}