import entities.User;
import repository.ManagerRepository;
import repository.SchoolClassRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.AuthenticateLogin;
import service.SchoolClassService;
import service.StudentService;
import service.TeacherService;
import view.management.ManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Repositories
        ManagerRepository managerRepository = new ManagerRepository();
        SchoolClassRepository schoolClassRepository = new SchoolClassRepository();
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        // Service
        SchoolClassService schoolClassService = new SchoolClassService(schoolClassRepository);
        StudentService studentService = new StudentService(studentRepository, schoolClassRepository);
        TeacherService teacherService = new TeacherService(teacherRepository, schoolClassRepository);
        AuthenticateLogin authenticateLogin = new AuthenticateLogin(managerRepository, teacherRepository, studentRepository);
        // Menus
        ManagementMenu managementMenu = new ManagementMenu(schoolClassService, studentService, teacherService);

       int opcao = 1;

       while (opcao != 2) {
           System.out.println("1 - Entrar");
           System.out.println("2 - Sair");
           opcao = sc.nextInt();

           switch (opcao) {
               case 1:
                   System.out.print("CPF: ");
                   String cpf = sc.next();

                   System.out.print("Senha: ");
                   int password = sc.nextInt();

                   User user = authenticateLogin.login(cpf, password);

                   switch (user.getRole()) {
                       case MANAGER -> managementMenu.start(sc);
                   }
                   break;
           }
       }
    }
}