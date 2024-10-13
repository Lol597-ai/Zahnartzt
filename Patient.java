
import java.util.Date;

public class Patient extends person{

//Attribute
private String insuranceName;
 private boolean insuranceCardPresent;
   

//Konstruktor
public Patient(int id, String name, String address, Date dateOfBirth, String insuranceName){
    
    super(id, name, address, dateOfBirth);
        this.insuranceName = insuranceName;
        this.insuranceCardPresent = true; // Default to true
}

//Getter und Setter
public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String _insuranceName) {
        this.insuranceName = _insuranceName;
    }

    public boolean getisInsuranceCardPresent() {
        return insuranceCardPresent;
    }

    public void setInsuranceCardPresent(boolean _insuranceCardPresent) {
        this.insuranceCardPresent = _insuranceCardPresent;
    }

    @Override
    public String toString() {
        return super.toString() + "\nInsurance Name: " + insuranceName + "\nInsurance Card Present: " + insuranceCardPresent;
    }

    @Override
    public int getId() {
        return super.getId();
    }

}