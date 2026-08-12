package entities;

public class Teacher extends User {
    private SchoolClass classe;

    public Teacher(String nome, String cpf, int senha, SchoolClass classe) {
        super(nome, cpf, senha);
        this.classe = classe;
    }

    public SchoolClass getClasse() {
        return classe;
    }

    public void setClasse(SchoolClass classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf()
                + "\nNome: " + this.getNome()
                + "\nTurma: " + getClasse().getNomeTurma() + " - " + getClasse().getSala();
    }
}
