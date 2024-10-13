import java.util.Date;

public class person implements Identifiable{
    
    //Attribute
    private int id;
    private String name;
    private String address;
    private Date dateOfBirth;

    //Konstruktor
    public person(int id, String name, String address, Date dateOfBirth){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    //Getter und Setter
    public int getId(){
        return id;
    }

    public String getname(){
        return name;
    }
     public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

     @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nDate of Birth: " + dateOfBirth;
    }

   
}