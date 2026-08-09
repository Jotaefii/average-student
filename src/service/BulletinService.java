package service;

import entities.Bulletin;
import entities.Student;

public class BulletinService {

    public void launchGrade(Student student, int bimester, double grade) {
        Bulletin bulletin = student.getBulletin();

        if (bulletin == null) {
            System.out.println("Boletim não encontrado!");
            return;
        }

        switch (bimester) {
            case 1 -> bulletin.setFirstGrade(grade);
            case 2 -> bulletin.setSecondGrade(grade);
            case 3 -> bulletin.setThirdGrade(grade);
            case 4 -> bulletin.setFourthGrade(grade);
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
