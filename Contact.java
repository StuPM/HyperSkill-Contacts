package contacts;

import java.util.Scanner;

public class Contact extends ContactInformation {

    private String surname;
    private String dateOfBirth;
    private String gender;
    Contact(String name, String surname, String dateOfBirth, String gender, String phoneNumber) {
        super(name, phoneNumber);
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }
    public void setSurname(String surname) {
        this.surname = surname;
        this.editDateEdited();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.editDateEdited();
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.editDateEdited();
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }
    @Override
    public String getSearchableName() {
        return this.name + " " +
                this.surname + " " +
                this.phoneNumber + " " +
                this.dateOfBirth + " " +
                this.gender;
    }


    @Override
    public void getEditable(Scanner scanner) {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String input = scanner.nextLine();

        switch (input) {
            case "name":
                System.out.println("Enter name: ");
                input = scanner.nextLine();
                this.setName(input);
                break;
            case "number":
                System.out.println("Enter number: ");
                input = scanner.nextLine();
                this.setPhoneNumber(input);
                break;
            case "surname":
                System.out.println("Enter surname: ");
                input = scanner.nextLine();
                this.setSurname(input);
                break;
            case "birth":
                System.out.println("Enter surname: ");
                input = scanner.nextLine();
                this.setDateOfBirth(input);
                break;
            case "gender":
                System.out.println("Enter surname: ");
                input = scanner.nextLine();
                this.setGender(input);
                break;
            default:
                break;
        }
    }
    @Override
    public void printInfo() {
        System.out.printf("Name: %s%nSurname: %s%nBirth date: %s%nGender: %s%nNumber: %s%nTime created: %s%nTime last edit: %s%n",
                getName(), getSurname(), getDateOfBirth(), getGender(), getPhoneNumber(), getDateCreated(), getDateEdited());
    }

    static class Builder {
        private String name;
        private String surname;
        private String dateOfBirth;
        private String gender;
        private String phoneNumber;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }


        Contact build() {
            return new Contact(name, surname, dateOfBirth, gender, phoneNumber);
        }


    }
}