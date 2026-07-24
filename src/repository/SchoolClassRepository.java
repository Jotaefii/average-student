package repository;

import entities.SchoolClass;

import java.util.ArrayList;
import java.util.List;

public class SchoolClassRepository {
    private List<SchoolClass> classes = new ArrayList<>();

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void addClass(String nome, int sala) {
        classes.add(new SchoolClass(nome, sala));
    }

    public List<SchoolClass> listClasses() {
        return classes;
    }

}
