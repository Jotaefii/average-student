package entities;

public class Student extends User {
    private SchoolClass schoolClass;

    public Student(String nome, String cpf, int senha, SchoolClass schoolClass) {
        super(nome, cpf, senha);
        this.schoolClass = schoolClass;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf()
                + "\nAluno(a): " + getNome()
                + "\nTurma: " + getSchoolClass().getNomeTurma() + " - " + getSchoolClass().getSala()
                + "\n";
    }
}
