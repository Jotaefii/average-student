import repository.SchoolClassRepository;
import repository.StudentRepository;
import service.SchoolClassService;
import service.StudentService;
import view.management.ManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Repositories
        SchoolClassRepository schoolClassRepository = new SchoolClassRepository();
        StudentRepository studentRepository = new StudentRepository();
        // Service
        SchoolClassService schoolClassService = new SchoolClassService(schoolClassRepository);
        StudentService studentService = new StudentService(studentRepository);
        // Menus
        ManagementMenu managementMenu = new ManagementMenu(schoolClassService, studentService);

       managementMenu.start(sc);
    }
}