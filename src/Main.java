import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        int contador = 0;
        ArrayList<String> alunos = new ArrayList<>();

        do {
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos");
            System.out.println("[0] Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    if ( alunos.size() < 10) {
                        System.out.print("Aluno: ");
                        alunos.add(sc.nextLine());
                        contador++;
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
            }
        } while(opcao != 0);
    }
}