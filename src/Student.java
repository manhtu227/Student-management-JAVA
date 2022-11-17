import java.util.ArrayList;

public class Student {
    private String ID;
    private String name;
    private float GPA;
    private String image;
    private String address;
    private String note;
    public Student(String ID, String name, float GPA,String image, String address,String note){
        this.ID = ID;
        this.name=name;
        this.GPA=GPA;
        this.image =image;
        this.address=address;
        this.note=note;
    }
    public Student()
    {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getGPA() {
        return GPA;
    }
    public String getAddress() {
        return address;
    }
    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getNote() {
        return note;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", GPA=" + GPA +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
