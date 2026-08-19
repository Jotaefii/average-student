package service;

import entities.SchoolClass;
import entities.Teacher;
import entities.enums.UserRole;
import excepetions.BusinessException;
import repository.SchoolClassRepository;
import repository.TeacherRepository;
import util.CpfValidator;
import util.PasswordValidator;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final UserService userService;

    public TeacherService(TeacherRepository teacherRepository, SchoolClassRepository schoolClassRepository, UserService userService) {
        this.teacherRepository = teacherRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.userService = userService;
    }

    public void addTeacher(String nome, String cpf, String senha, SchoolClass schoolClass) {
        if (!CpfValidator.isValid(cpf)) {
            throw new BusinessException("CPF Inválido!");
        }

        if (!PasswordValidator.isValid(senha)) {
            throw new BusinessException("Senha inválida!");
        }

        if (userService.cpfExists(cpf)) {
            throw new BusinessException("CPF já cadastrado no sistema!");
        }

        if (schoolClass.getTeacher() != null) {
            throw new BusinessException("Essa turma já possui um professor(a)!");
        }

        Teacher teacher = new Teacher(nome, cpf, senha, schoolClass);

        teacher.setRole(UserRole.TEACHER);
        schoolClass.setTeacher(teacher);
        teacherRepository.addTeacher(teacher);
    }

    public Teacher searchTeacherByCpf(String cpf) {
        Teacher teacher = teacherRepository.searchTeacherByCpf(cpf);

        if (teacher == null) {
            throw new BusinessException("Nenhum professor(a) com este CPF foi encontrado!");
        }

        return teacher;
    }

    public Teacher searchTeacherByName(String name) {
        Teacher teacher = teacherRepository.searchTeacherByName(name);

        if (teacher == null) {
            throw new BusinessException("Nenhum professor(a) com este nome foi encontrado!");
        }

        return teacher;
    }

    public List<Teacher> teacherList() {
        return teacherRepository.teacherList();
    }

    public boolean editTeacher(String cpf, Teacher teacher) {
        return teacherRepository.editTeacher(cpf, teacher);
    }

    public boolean deleteTeacher(String cpf, Teacher teacher) {
        for (SchoolClass schoolClass : schoolClassRepository.listClasses()) {
            if (schoolClass.getTeacher() != null && schoolClass.getTeacher().equals(teacher)) {
                schoolClass.setTeacher(null);
            }
        }
        return teacherRepository.deleteTeacher(cpf);
    }
}
