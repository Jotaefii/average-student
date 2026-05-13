package sistemaescolar.service;

import sistemaescolar.model.Alunos;
import java.util.ArrayList;

public class CadastroAluno {
    ArrayList<Alunos> listaAlunos = new ArrayList<>();

    //CADASTRAR
    public void adicionarAluno (Alunos aluno){
        listaAlunos.add(aluno);
        System.out.println("Aluno cadastrado!");
    }

    //LISTAR
    public void listarAlunos () {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }
        for (Alunos aluno: listaAlunos) {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Média: " + aluno.calcularMedia());
            System.out.println("Situação: " + aluno.situacaoAluno());
            System.out.println("----------------------------");
        }
    }
}
