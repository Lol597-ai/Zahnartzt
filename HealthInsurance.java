import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class HealthInsurance implements Identifiable{
    
    //Attribute
    private int id;
    private String name;
    private Map<Integer, Patient> patients;

        public HealthInsurance(int id, String name) {
        this.id = id;
        this.name = name;
        this.patients = new HashMap<>();
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Methods for managing patient list
    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient.getId());
    }

    public ArrayList<Patient> getPatients() {
        return new ArrayList<>(patients.values());
    }
}

