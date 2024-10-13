import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HealthInsurance insurance1 = new HealthInsurance(1, "Insurance1");
        HealthInsurance insurance2 = new HealthInsurance(2, "Insurance2");

        while (true) {
            System.out.println("1. Neuen Patienten hinzufügen");
            System.out.println("2. Patienten einer Versicherung anzeigen");
            System.out.println("3. Beenden");
            System.out.print("Wähle eine Option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Name des Patienten: ");
                    String name = scanner.nextLine();
                    System.out.print("Adresse des Patienten: ");
                    String address = scanner.nextLine();
                    System.out.print("Geburtsdatum des Patienten (YYYY-MM-DD): ");
                    String dobString = scanner.nextLine();
                    Date dob = parseDate(dobString, scanner);

                    System.out.print("Versicherungsname des Patienten: ");
                    String insuranceName = scanner.nextLine();

                    System.out.print("Ist die Versicherungskarte vorhanden? (ja/nein): ");
                    boolean insuranceCardPresent = scanner.nextLine().equalsIgnoreCase("ja");

                    Patient newPatient = new Patient(getNextPatientId(), name, address, dob, insuranceName);
                    newPatient.setInsuranceCardPresent(insuranceCardPresent);

                    System.out.println("Zu welcher Versicherung gehört der Patient (1 oder 2)? ");
                    int insuranceId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (insuranceId == 1) {
                        insurance1.addPatient(newPatient);
                    } else if (insuranceId == 2) {
                        insurance2.addPatient(newPatient);
                    } else {
                        System.out.println("Ungültige Versicherungs-ID.");
                    }
                    break;
                case 2:
                    System.out.print("Welche Versicherung möchtest du anzeigen (AOK oder Privatverssichert)? ");
                    int insuranceToShow = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (insuranceToShow == 1) {
                        System.out.println("Patients of Health Insurance " + insurance1.getName() + ":");
                        for (Patient patient : insurance1.getPatients()) {
                            System.out.println(patient);
                            System.out.println();
                        }
                    } else if (insuranceToShow == 2) {
                        System.out.println("Patients of Health Insurance " + insurance2.getName() + ":");
                        for (Patient patient : insurance2.getPatients()) {
                            System.out.println(patient);
                            System.out.println();
                        }
                    } else {
                        System.out.println("Ungültige Versicherungs-ID.");
                    }
                    break;
                case 3:
                    System.out.println("Programm wird beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }

    private static int nextPatientId = 3; // Start with 3 to avoid conflicts with test data IDs

    private static int getNextPatientId() {
        return nextPatientId++;
    }

    private static Date parseDate(String dateString, Scanner scanner) {
        while (true) {
            String[] parts = dateString.split("-");
            if (parts.length != 3) {
                System.out.println("Ungültiges Datumsformat. Verwende das Format YYYY-MM-DD.");
                System.out.print("Geburtsdatum des Patienten (YYYY-MM-DD): ");
                dateString = scanner.nextLine();
                continue;
            }
            try {
                int year = Integer.parseInt(parts[0]) - 1900; // Year is offset by 1900
                int month = Integer.parseInt(parts[1]) - 1; // Month is zero-based
                int day = Integer.parseInt(parts[2]);
                return new Date(year, month, day);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Ungültiges Datumsformat. Verwende das Format YYYY-MM-DD.");
                System.out.print("Geburtsdatum des Patienten (YYYY-MM-DD): ");
                dateString = scanner.nextLine();
            }
        }
    }
}