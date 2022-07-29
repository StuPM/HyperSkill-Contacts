package contacts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class ContactBook {

    ArrayList<ContactInformation> contactInformation;

    ContactBook() {
        this.contactInformation = new ArrayList<>();
    }

    public void count() {
        System.out.println("The Phone Book has " + contactInformation.size() + " records.");

    }

    public void add(Scanner scanner) {
        System.out.print("[add] Enter the type (person, organization): ");
        switch (scanner.nextLine()) {
            case "person":
                addPerson(scanner);
                System.out.println("The record added.");
                break;
            case "organization":
                addOrganization(scanner);
                System.out.println("The record added.");
                break;
            default:
                System.out.println("Bad type!");
                break;
        }
    }

    private void addOrganization(Scanner scanner) {
        System.out.print("Enter the organization name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the number : ");
        String phoneNumber = checkNumberValid(scanner.nextLine());

        contactInformation.add(new Organisation.Builder().setName(name).setAddress(address).setPhoneNumber(phoneNumber).build());

    }

    private void addPerson(Scanner scanner) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter the birth date: ");
        String dateOfBirth = checkDateOfBirthValid(scanner.nextLine());

        System.out.print("Enter the gender (M, F): ");
        String gender = checkGenderValid(scanner.nextLine());

        System.out.print("Enter the number: ");
        String phoneNumber = checkNumberValid(scanner.nextLine());

        contactInformation.add(new Contact.Builder().setName(name).setSurname(surname).setDateOfBirth(dateOfBirth).setGender(gender).setPhoneNumber(phoneNumber).build());

    }

    public void search(Scanner scanner) {

        System.out.println("Enter the search query: ");
        String input = scanner.nextLine();
        ArrayList<ContactInformation> tempCI = new ArrayList<>();

        int tally = 0;
        String output = "";

        Pattern pattern = Pattern.compile(input, CASE_INSENSITIVE);

        for (ContactInformation CI : contactInformation) {
            Matcher matcher = pattern.matcher(CI.getSearchableName());
            if (matcher.find()) {
                tally++;
                output += "\n" + tally + ". " + CI;
                tempCI.add(CI);
            }
        }
        System.out.println("Found " + tally + " results:" + output);

        System.out.print("[search] Enter action ([number], back, again): ");
        input = scanner.nextLine();

        if (input.equals("again")) {
            search(scanner);
        } else if (!input.equals("back")){
            for (ContactInformation CI : contactInformation) {
                if (CI.getName().equals(tempCI.get(Integer.parseInt(input) - 1).getName())) {
                    CI.printInfo();
                    recordInformation(CI, scanner);
                }
            }
        }

    }

    private String checkNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            return phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            return "[no number]";
        }
    }

    private String checkGenderValid(String gender) {
        if (gender.equals("M")) {
            return "M";
        } else if (gender.equals("F")) {
            return "F";
        } else {
            System.out.println("Bad gender!");
            return "[no data]";
        }
    }

    public   String checkDateOfBirthValid(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            return "[no data]";
        }
        return dateOfBirth;
    }


    public void list(Scanner scanner) {
        if (contactInformation.isEmpty()) {
            System.out.println("No records to show!");
        } else {
            int tally = 1;
            for (ContactInformation CI : contactInformation) {
                System.out.println(tally + ". " + CI);
            }
            System.out.println("\n");
        }

        System.out.println("[list] Enter action ([number], back):");
        String input = scanner.nextLine();

        if (!input.equals("back")) {
            ContactInformation tempCI = contactInformation.get(Integer.parseInt(input) - 1);
            tempCI.printInfo();
            System.out.println("\n");
            recordInformation(tempCI, scanner);
        }

    }

    private void recordInformation(ContactInformation tempCI, Scanner scanner) {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String input = scanner.nextLine();

        switch (input) {
            case "edit":
                tempCI.getEditable(scanner);
                tempCI.printInfo();
                recordInformation(tempCI, scanner);
                break;
            case "delete":
                deleteRecord(tempCI);
                break;
            case "menu":
            default:
                break;
        }
    }

    private void deleteRecord(ContactInformation tempCI) {
        contactInformation.remove(tempCI);
        System.out.println("The record removed!");
    }
}