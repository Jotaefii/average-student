package entities;

public class Teacher extends User {
    private SchoolClass classe;

    public Teacher(String nome, String cpf, String senha, SchoolClass classe) {
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
                + "\nProfessor(a): " + this.getNome()
                + "\nTurma: " + getClasse().getNomeTurma() + " - " + getClasse().getSala();
    }
}
