import entities.Management;
import entities.Student;
import entities.Teacher;
import entities.User;
import excepetions.BusinessException;
import repository.ManagerRepository;
import repository.SchoolClassRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.*;
import util.InputUtils;
import view.management.ManagementMenu;
import view.student.StudentMenu;
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
        StudentService studentService = new StudentService(studentRepository, schoolClassRepository, new UserService(studentRepository, teacherRepository, managerRepository));
        TeacherService teacherService = new TeacherService(teacherRepository, schoolClassRepository, new UserService(studentRepository, teacherRepository, managerRepository));
        BulletinService bulletinService = new BulletinService();

       int opcao = 1;

       while (opcao != 2) {
           System.out.println();
           System.out.println("╔═══════════════════════════════════════════╗");
           System.out.println("            MENU DO INICIAL                  ");
           System.out.println("╚═══════════════════════════════════════════╝");

           System.out.println("1 - Entrar");
           System.out.println("2 - Sair");

           System.out.println("═════════════════════════════════════════════");
           opcao = InputUtils.readInt(sc, "Opção: ");

           switch (opcao) {
               case 1:
                   String cpf = InputUtils.readNumbers(sc, "CPF: ");

                   String password = InputUtils.readNumbers(sc, "Senha: ");

                   try {
                       User user = authenticateLogin.login(cpf, password);

                       switch (user.getRole()) {
                           case MANAGER:
                               Management management = (Management) user;
                               ManagementMenu managementMenu = new ManagementMenu(schoolClassService, studentService, teacherService, management);
                               managementMenu.start(sc);
                               break;
                           case TEACHER:
                               Teacher teacher = (Teacher) user;
                               TeacherMenu teacherMenu = new TeacherMenu(bulletinService, studentService, teacher);
                               teacherMenu.start(sc);
                               break;

                           case STUDENT:
                               Student student = (Student) user;
                               StudentMenu studentMenu = new StudentMenu(student);
                               studentMenu.start(sc);
                               break;
                       }
                   }
                   catch (BusinessException e) {
                       System.out.println("Error: " + e.getMessage());
                   }
                   break;

               case 2:
                   System.out.println("Finalizando...");
                   break;

               default:
                   System.out.println("Opção inválida!");
                   break;
           }
       }
    }
}