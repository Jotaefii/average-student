import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcao;
        String aluno;

        do {
            System.out.println("[1] Media Aluno");
            System.out.println("[0] Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            if (opcao == 1){
                System.out.print("Nome do aluno: ");
                aluno = sc.nextLine();

                System.out.print("Primeira nota: ");
                double nota1 = sc.nextDouble();

                System.out.print("Segunda nota: ");
                double nota2 = sc.nextDouble();

                System.out.print("Terceira nota: ");
                double nota3 = sc.nextDouble();

                double media = (nota1 + nota2 + nota3) / 3;
                System.out.printf("Media: %.2f%n", media);

                    if (media >= 7){
                        System.out.println("APROVADO!!");
                    } else if (media <= 5){
                        System.out.println("REPROVADO!!");
                    } else {
                        System.out.println("RECUPERACAO!!");
                    }
                break;
            }
        } while(opcao != 0);
    }
}