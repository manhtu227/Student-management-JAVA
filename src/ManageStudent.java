import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ManageStudent {
    private ArrayList<Student> listStudent;

    public ManageStudent() {
        this.listStudent = new ArrayList<>();
    }
    public ArrayList<Student> getListStudent() {
        return listStudent;
    }
    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
    public void addStudent(Student st) {
        int size = this.listStudent.size();
        for (int i = 0; i < size; i++) {
            if (this.listStudent.get(i).getID().compareTo(st.getID()) == 0) {
                System.out.println("----Student have ID:" + st.getID() + " is valid in listStudent-----");
                return;
            }
        }
        this.listStudent.add(st);
        System.out.println("----add student successfully---");
    }
    public void showStudent() {
        for (Student st : this.listStudent) {
            System.out.println(st);
        }
    }
    public void updateStudent(String ID) {
        for (Student st : this.listStudent) {
            if (st.getID().compareTo(ID) == 0) {
                int choose;
                do {
                    Scanner input = new Scanner(System.in);
                    System.out.println("1.Update name");
                    System.out.println("2.Update GPA");
                    System.out.println("3.Update image");
                    System.out.println("4.Update address");
                    System.out.println("5.Update note");
                    System.out.println("0.Exit");
                    System.out.print("Enter choose: ");
                    choose = input.nextInt();
                    input.nextLine();
                    if (choose == 1) {
                        System.out.print("Enter name need update: ");
                        String name = input.nextLine();
                        st.setName(name);
                        System.out.println("-----update name successfully-----");

                    } else if (choose == 2) {
                        System.out.print("Enter GPA need update: ");
                        float name = input.nextFloat();
                        st.setGPA(name);
                        System.out.println("-----update GPA successfully-----");

                    } else if (choose == 3) {
                        System.out.print("Enter image need update: ");
                        String name = input.nextLine();
                        st.setImage(name);
                        System.out.println("-----update Image successfully-----");

                    } else if (choose == 4) {
                        System.out.print("Enter address need update: ");
                        String name = input.nextLine();
                        st.setAddress(name);
                        System.out.println("-----update address successfully-----");

                    } else if (choose == 5) {
                        System.out.print("Enter note need update: ");
                        String name = input.nextLine();
                        st.setNote(name);
                        System.out.println("-----update note successfully-----");
                    }
                } while (choose != 0);
            }
        }
        System.out.println("-----Can not find ID to update-----");

    }
    public void deleteStudent(String ID) {
        int i = 0;
        for (Student st : this.listStudent) {
            if (st.getID().compareTo(ID) == 0) {
                this.listStudent.remove(i);
                System.out.println("-----Delete successfully-----");
                return;
            }
            i++;
        }
        System.out.println("-----Can not find ID to delete-----");
    }
    public void sortAscendingByID() {
        Collections.sort(this.listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return st1.getID().compareTo(st2.getID());
            }
        });
    }
    public void sortAscendingByGPA() {
        Collections.sort(this.listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                if (st1.getGPA() > st2.getGPA()) {
                    return 1;
                } else if (st1.getGPA() < st2.getGPA()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
    public void writeToFile() throws IOException {

        FileWriter fw;
        try {
            fw = new FileWriter("a.data");
        } catch (IOException exc) {
            System.out.println("Error opening file");
            return;
        }
        fw.write(String.valueOf(this.listStudent.size())+"\r\n");

        for (Student st : this.listStudent) {
            fw.write(st.getID() + ","+st.getName()+","+String.valueOf(st.getGPA())+","+st.getImage()+","+st.getAddress()+","+st.getNote()+"\r\n");

        }
        fw.close(); //wfsfsdfsdf
        System.out.println("Finished ! Check your file !");
        System.out.println("xin chap");
    }
}
