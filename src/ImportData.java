import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportData {
    public void importData(ManageStudent listStudent) throws IOException {
        String path = "src/StudentExport.csv";
        FileReader fr = null;
        BufferedReader Br = null;
        try {
            fr = new FileReader(path);
            Br = new BufferedReader(fr);
            String line = Br.readLine();
            while (line != null) {
                String[] student = line.split(",");
                Student st = new Student(student[0], student[1], Float.parseFloat(student[2]), student[3], student[4]
                        , student[5]);
                listStudent.addStudent(st);
                line = Br.readLine();
            }

            Br.close();
            fr.close();
            System.out.println("----importData successfully----");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
