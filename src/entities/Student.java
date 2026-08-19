package entities;

public class Student extends User {

    private SchoolClass schoolClass;
    private Bulletin bulletin;

    public Student(String nome, String cpf, String senha, SchoolClass schoolClass) {
        super(nome, cpf, senha);
        this.schoolClass = schoolClass;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf()
                + "\nAluno(a): " + getNome()
                + "\nTurma: " + getSchoolClass().getNomeTurma() + " - " + getSchoolClass().getSala();
    }
}
