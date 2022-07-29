package contacts;

import java.time.LocalDateTime;

public class ContactInformation {

    protected String name;
    protected String phoneNumber;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateEdited;
    ContactInformation(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateCreated = LocalDateTime.now().withSecond(0).withNano(0);
        this.dateEdited = this.dateCreated;
    }
    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected LocalDateTime getDateCreated() {
        return dateCreated;
    }

    protected LocalDateTime getDateEdited() {
        return dateEdited;
    }

    protected String getName() {
        return this.name;
    }

    protected void printInfo() {
        this.printInfo();
    }

    protected void getEditable() {
        this.getEditable();
    }

    protected String getSearchableName() {
        return getName();
    }

    protected void setName(String input) {
        this.name = input;
        editDateEdited();
    }

    protected void setPhoneNumber(String input) {
        this.phoneNumber = input;
        editDateEdited();
    }

    protected void editDateEdited() {
        this.dateEdited = LocalDateTime.now().withSecond(0).withNano(0);
    }
}

