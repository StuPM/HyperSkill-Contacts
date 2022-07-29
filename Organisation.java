package contacts;

import java.util.Scanner;

public class Organisation extends ContactInformation {

    private String address;

    Organisation(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.editDateEdited();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void printInfo() {
        System.out.printf("Organization name: %s%nAddress: %s%nNumber: %s%nTime created: %s%nTime last edit: %s%n",
                getName(), getAddress(), getPhoneNumber(), getDateCreated(), getDateEdited());
    }


    @Override
    public void getEditable(Scanner scanner) {

        System.out.println("Select a field (name, number, address): ");
        String input = scanner.nextLine();

        switch (input) {
            case "name":
                System.out.println("Enter name: ");
                input = scanner.nextLine();
                this.setName(input);
                break;
            case "address":
                System.out.println("Enter address: ");
                input = scanner.nextLine();
                this.setAddress(input);
                break;
            case "number":
                System.out.println("Enter number: ");
                input = scanner.nextLine();
                this.setPhoneNumber(input);
                break;
            default:
                break;
        }


    }

    @Override
    public String getSearchableName() {
        return this.name + " " +
                this.address + " " +
                this.phoneNumber;
    }

    static class Builder {
        private String name;
        private String phoneNumber;
        private String address;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        Organisation build() {
            return new Organisation(name, phoneNumber, address);
        }

    }

}