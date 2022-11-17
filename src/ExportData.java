import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportData {
    public void delete() {
        try {
            String path = "src/StudentExport.csv";
            File my = new File(path);
            my.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportData(ManageStudent listStudent) throws IOException {
        String path = "src/StudentExport.csv";
        try{
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            ImportData data = new ImportData();
            data.importData(listStudent);
            ExportData delete = new ExportData();
            delete.delete();

            for (Student st : listStudent.getListStudent()) {
                bw.write(st.getID() + "," + st.getName() + "," + st.getGPA() + "," + st.getImage() + "," + st.getAddress() + "," + st.getNote());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("----exportData successfully----");
        }catch (Exception e){
            e.printStackTrace();
        }
        //import check student valid then export
        // delete file then export

    }
}
