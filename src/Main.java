import java.io.IOException;
import java.util.Scanner;

public class Main {

    public void menu() throws IOException {
        int choose;
        Scanner input = new Scanner(System.in);
        ManageStudent listStudent = new ManageStudent();
        do {
            System.out.println("1.Add student!");
            System.out.println("2.Update student information");
            System.out.println("3.Delete a student");
            System.out.println("4.View student list");
            System.out.println("5.Save student list into file(s).");
            System.out.println("6.Import/Export student list to/from text file (csv)");
            System.out.println("0.EXIT");
            System.out.print("Enter choose:");

            choose = input.nextInt();
            input.nextLine();
            if(choose==1){
                System.out.print("Input ID: "); String ID = input.nextLine();
                System.out.print("Input Name: "); String name = input.nextLine();
                System.out.print("Input GPA: "); float GPA = input.nextFloat();
                input.nextLine();
                System.out.print("Input Image: "); String image = input.nextLine();
                System.out.print("Input Address: "); String address = input.nextLine();
                System.out.print("Input Note: "); String note = input.nextLine();
                Student st = new Student(ID,name,GPA,image,address,note);
                listStudent.addStudent(st);
            }
            else if(choose == 2){
                System.out.print("Input student's ID need update: "); String ID = input.nextLine();
                listStudent.updateStudent(ID);
            }
            else if(choose == 3){
                System.out.print("Input student's ID need delete: "); String ID = input.nextLine();
                listStudent.deleteStudent(ID);
            }
            else if(choose == 4){
                int choose4;

                do{
                    System.out.println("---------------------------");
                    System.out.println("1.With the student id in ascending order");
                    System.out.println("2.With the GPA in ascending order");
                    System.out.println("0.EXIT");
                    System.out.print("Enter choose:");
                    choose4 = input.nextInt();
                    if(choose4 == 1){
                        listStudent.sortAscendingByID();
                        listStudent.showStudent();
                    }
                    else if(choose4==2){
                        listStudent.sortAscendingByGPA();
                        listStudent.showStudent();
                    }
                }while (choose4!=0);
                listStudent.showStudent();
            }
            else if(choose==5){
                try {
                    listStudent.writeToFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(choose == 6){

                int choose4;

                do{
                    System.out.println("---------------------------");
                    System.out.println("1.Export student list to/from text file (csv)");
                    System.out.println("2.Import student list to/from text file (csv)");
                    System.out.println("0.EXIT");
                    System.out.print("Enter choose:");
                    choose4 = input.nextInt();
                    if(choose4 == 1){
                        //export save in listStudent
                        ExportData export =new ExportData();
                        export.exportData(listStudent);
                    }
                    else if(choose4==2){
                        ImportData im = new ImportData();
                        im.importData(listStudent);
                    }
                }while (choose4!=0);

            }
        }while(choose!=0);
    }

    public static void main(String[] args) throws IOException {
        Main menu =new Main();
        menu.menu();
    }
}