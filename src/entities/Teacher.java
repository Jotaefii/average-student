package entities;

public class Teacher extends User {
    private SchoolClass classe;

    public Teacher(String nome, String cpf, int senha) {
        super(nome, cpf, senha);
    }

    public SchoolClass getClasse() {
        return classe;
    }

    public void setClasse(SchoolClass classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome()
                + "Turma: " + this.classe
                + "\n";
    }
}
