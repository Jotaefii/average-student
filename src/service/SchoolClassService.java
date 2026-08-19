package service;

import entities.SchoolClass;
import excepetions.BusinessException;
import repository.SchoolClassRepository;

import java.util.List;

public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassService(SchoolClassRepository repository){
        this.schoolClassRepository = repository;
    }

    public void criarTurma(String name, int room) {
        if (schoolClassRepository.buscarPorSala(room) != null) {
            throw new BusinessException("Número de sala já existente!");
        }
        schoolClassRepository.adicionarTurma(name, room);
    }

    public List<SchoolClass> listarTurmas() {
        return schoolClassRepository.listClasses();
    }

    public SchoolClass buscarTurma(int sala) {
        SchoolClass schoolClass = schoolClassRepository.buscarPorSala(sala);

        if (schoolClass == null) {
            throw new BusinessException("Turma não encontrada!");
        }

        return schoolClass;
    }

    public boolean editaTurma(String nome, int sala) {
        return schoolClassRepository.editarTurma(nome, sala);
    }

    public boolean deletaTurma(int sala) {
        return schoolClassRepository.deletarTurma(sala);
    }
}
