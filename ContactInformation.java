package contacts;

import java.time.LocalDateTime;

public class ContactInformation {

    protected String name;
    protected String phoneNumber;
    LocalDateTime dateCreated;
    LocalDateTime dateEdited;

    ContactInformation(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateCreated = LocalDateTime.now().withSecond(0).withNano(0);
        this.dateEdited = this.dateCreated;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateEdited() {
        return dateEdited;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        this.printInfo();
    }

    public void getEditable() {
        this.getEditable();
    }

    public String getSearchableName() {
        return this.name ;
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

