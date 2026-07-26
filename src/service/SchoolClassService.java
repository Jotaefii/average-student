package service;

import entities.SchoolClass;
import repository.SchoolClassRepository;

import java.util.List;

public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository repository){
        this.schoolClassRepository = repository;
    }

    public void criarTurma(String name, int room) {
        schoolClassRepository.adicionarTurma(name, room);
    }

    public List<SchoolClass> listarTurmas() {
        return schoolClassRepository.listClasses();
    }

    public SchoolClass buscarTurma(int sala) {
        return schoolClassRepository.buscarPorSala(sala);
    }

    public boolean editaTurma(String nome, int sala) {
        return schoolClassRepository.editarTurma(nome, sala);
    }

    public boolean deletaTurma(int sala) {
        return schoolClassRepository.deletarTurma(sala);
    }
}
