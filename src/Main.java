import java.util.Scanner;

public class Main {
    static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do aluno: ");
        String aluno = sc.nextLine();

        System.out.print("Primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.print("Segunda nota: ");
        double nota2 = sc.nextDouble();

        System.out.print("Terceira nota: ");
        double nota3 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7){
            System.out.println("Aprovado!!");
        } else if (media <= 4.50) {
            System.out.println("Reprovado!!");
        } else {
            System.out.println("Recuperacao!!");
        }
    }
}