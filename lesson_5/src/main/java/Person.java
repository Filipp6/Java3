import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

    private String name;
    private String familyName;
    private String address;
    private Date bd;
    private int tall;

    public Person(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public Person(String name, String familyName, String address, Date bd, int tall) {
        this.name = name;
        this.familyName = familyName;
        this.address = address;
        this.bd = bd;
        this.tall = tall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBd() {
        return bd;
    }

    public void setBd(Date bd) {
        this.bd = bd;
    }

    public int getTall() {
        return tall;
    }

    public void setTall(int tall) {
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}