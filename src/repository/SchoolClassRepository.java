package repository;

import entities.SchoolClass;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassRepository {
    private final List<SchoolClass> classes = new ArrayList<>();

    public void adicionarTurma(String nome, int sala) {
        classes.add(new SchoolClass(nome, sala));
    }

    public List<SchoolClass> listClasses() {
        return classes;
    }

    public SchoolClass buscarPorSala(int sala) {
        for (SchoolClass classe : classes) {
            if (classe.getSala() == sala) {
                return classe;
            }
        }
        return null;
    }

    public boolean editarTurma(String nome, int sala) {
        for (SchoolClass turma : classes) {
            if (turma.getSala() == sala) {
                turma.setNomeTurma(nome);
                return true;
            }
        }
        return false;
    }

    public boolean deletarTurma(int sala) {

        for (SchoolClass schoolClass : classes) {
            if (schoolClass.getSala() == sala) {
                classes.remove(schoolClass);
                return true;
            }
        }
        return false;
    }
}
