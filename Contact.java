package contacts;

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

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getSearchableName() {
        return this.name + " " +
                this.surname + " " +
                this.phoneNumber + " " +
                this.dateOfBirth + " " +
                this.gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void getEditable() {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName() + "\nSurname: " + getSurname() +
                "\nBirth date: " + getDateOfBirth() + "\nGender: " + getGender() + "\nNumber: " + getPhoneNumber()
                + "\nTime created:" + getDateCreated() + "\nTime last edit:" + getDateEdited());
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

//package contacts;
//
//public class Contact extends ContactInfo {
//
//    private String surname;
//    private String dateOfBirth;
//    private String gender;
//
//    Contact(String name, String surname, String dateOfBirth, String gender, String phoneNumber) {
//        super(name, true, phoneNumber);
//        this.surname = surname;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//    }
//

//
//    private String getGender() {
//        return gender;
//    }
//
//    private String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String input) {
//        this.surname = input;
//        editDateEdited();
//    }
//
//    public void setBirthDate(String input) {
//        this.dateOfBirth = input;
//    }
//
//    public void setGender(String input) {
//        this.gender = input;
//    }
//
//    static class Builder {
//        private String name;
//        private String surname;
//        private String dateOfBirth;
//        private String gender;
//        private String phoneNumber;
//
//        Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        Builder setSurname(String surname) {
//            this.surname = surname;
//            return this;
//        }
//
//        Builder setPhoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//            return this;
//        }
//
//        Builder setDateOfBirth(String dateOfBirth) {
//            this.dateOfBirth = dateOfBirth;
//            return this;
//        }
//
//        Builder setGender(String gender) {
//            this.gender = gender;
//            return this;
//        }
//
//
//        Contact build() {
//            return new Contact(name, surname, dateOfBirth, gender, phoneNumber);
//        }
//
//
//    }
//}
//
