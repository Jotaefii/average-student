package sistemaescolar.service;

import sistemaescolar.entities.Alunos;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroService {

    Scanner sc = new Scanner(System.in);
    ArrayList<Alunos> alunos = new ArrayList<>();

    //CADASTRAR
    public void adicionarAluno (){
        System.out.print("Aluno: ");
        String nome = sc.nextLine();

        System.out.print("Codigo do aluno: ");
        int codigo = sc.nextInt();

        System.out.print("Primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.print("Segunda nota: ");
        double nota2 = sc.nextDouble();
        sc.nextLine();

        Alunos aluno = new Alunos(nome, codigo, nota1, nota2);

        alunos.add(aluno);
    }

    //LISTAR
    public void listarAlunos () {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }
        for (Alunos aluno: alunos) {
            System.out.println("Codigo do aluno: " + aluno.getCodigoAluno());
            System.out.println("Aluno(a): " + aluno.getNomedoAluno());
            System.out.println("Média: " + aluno.calcularMedia());
            System.out.println("Situação: " + aluno.situacaoAluno());
            System.out.println("----------------------------");
        }
    }
}
