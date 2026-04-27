import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        int contador = 0;
        String[] alunos = new String[10];

        do {
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Consultar aluno");
            System.out.println("[0] Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                        if (contador < alunos.length) {
                            System.out.print("Aluno: ");
                            alunos[contador] = sc.nextLine();
                            contador++;
                        } else {
                            System.out.println("Cadastro cheio!!");
                        }
                    break;
            }
        } while(opcao != 0);
    }
}