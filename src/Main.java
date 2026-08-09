import entities.Teacher;
import entities.User;
import repository.ManagerRepository;
import repository.SchoolClassRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.*;
import view.management.ManagementMenu;
import view.teacher.TeacherMenu;

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
        AuthenticateLogin authenticateLogin = new AuthenticateLogin(managerRepository, teacherRepository, studentRepository);
        SchoolClassService schoolClassService = new SchoolClassService(schoolClassRepository);
        StudentService studentService = new StudentService(studentRepository, schoolClassRepository);
        TeacherService teacherService = new TeacherService(teacherRepository, schoolClassRepository);
        BulletinService bulletinService = new BulletinService();

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
                       case MANAGER:
                           ManagementMenu managementMenu = new ManagementMenu(schoolClassService, studentService, teacherService);
                           managementMenu.start(sc);
                           break;
                       case TEACHER:
                           Teacher teacher = (Teacher) user;
                           TeacherMenu teacherMenu = new TeacherMenu(bulletinService, studentService, teacher);
                           teacherMenu.start(sc);
                           break;
                   }
                   break;

               case 2:
                   System.out.println("Finalizando...");
                   break;

               default:
                   System.out.println("Opção inválida!");
           }
       }
    }
}