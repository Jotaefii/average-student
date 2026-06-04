package sistemaescolar.entities;

public class Alunos {

    private String nomedoAluno;
    private int codigoAluno;
    private double nota1;
    private double nota2;

    public Alunos (String nome, int codigo, double nota1, double nota2){
        this.nomedoAluno = nome;
        this.codigoAluno = codigo;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNomedoAluno() {
        return nomedoAluno;
    }

    public void setNomedoAluno(String nomedoAluno) {
        this.nomedoAluno = nomedoAluno;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularMedia (){
        return (getNota1() + getNota2()) / 2;
    }

    public String situacaoAluno (){
        if (calcularMedia() >= 7){
            return "Aprovado";
        } else if (calcularMedia() <= 5){
            return "Reprovado";
        } else {
            return "Recuperação";
        }
    }
}
