package sistemaescolar.entities;

public class Alunos {

    private String nomedoAluno;
    private int codigoAluno;
    private double nota1;
    private double nota2;

    public Alunos (String nome, double nota1, double nota2, int codigo){
        this.nomedoAluno = nome;
        this.codigoAluno = codigo;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome(){
        return nomedoAluno;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public double calcularMedia(){
        return (nota1 + nota2) / 2;
    }

    public String situacaoAluno(){
        if (calcularMedia() >= 7){
            return "Aprovado";
        } else if (calcularMedia() <= 4) {
            return "Reprovado";
        } else {
            return "Recuperação";
        }
    }
}
