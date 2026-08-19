package service;

import entities.Bulletin;
import entities.Student;
import excepetions.BusinessException;

public class BulletinService {

    public void launchGrade(Student student, int bimester, double grade) {
        Bulletin bulletin = student.getBulletin();

        if (bulletin == null) {
            throw new BusinessException("Boletim não encontrado!");
        }

        if (grade < 0 || grade > 10) {
            throw new BusinessException("A nota deve estar entre 0 e 10");
        }

        switch (bimester) {
            case 1 -> {
                if (bulletin.getFirstGrade() != null) {
                    throw new BusinessException("O 1° bimestre já possui uma nota!");
                }
                bulletin.setFirstGrade(grade);
            }
            case 2 -> {
                if (bulletin.getSecondGrade() != null) {
                    throw new BusinessException("O 2° bimestre já possui uma nota!");
                }
                bulletin.setSecondGrade(grade);
            }
            case 3 -> {
                if (bulletin.getThirdGrade() != null) {
                    throw new BusinessException("O 3° bimestre já possui uma nota!");
                }
                bulletin.setThirdGrade(grade);
            }
            case 4 -> {
                if (bulletin.getFourthGrade() != null) {
                    throw new BusinessException("O 4° bimestre já possui uma nota!");
                }
                bulletin.setFourthGrade(grade);
            }
            default -> throw new BusinessException("Bimestre inválido!");
        }
    }

    public void registerAttendance(Student student, boolean present) {
        Bulletin bulletin = student.getBulletin();

        bulletin.setTotalClasses(bulletin.getTotalClasses() + 1);

        if (present) {
            bulletin.setAttendedClasses(bulletin.getAttendedClasses() + 1);
        }
    }
}
