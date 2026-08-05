import repository.SchoolClassRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.SchoolClassService;
import service.StudentService;
import service.TeacherService;
import view.management.ManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Repositories
        SchoolClassRepository schoolClassRepository = new SchoolClassRepository();
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        // Service
        SchoolClassService schoolClassService = new SchoolClassService(schoolClassRepository);
        StudentService studentService = new StudentService(studentRepository, schoolClassRepository);
        TeacherService teacherService = new TeacherService(teacherRepository, schoolClassRepository);
        // Menus
        ManagementMenu managementMenu = new ManagementMenu(schoolClassService, studentService, teacherService);

       managementMenu.start(sc);
    }
}