package contacts;

public class Organisation extends ContactInformation {

    private String address;

    Organisation(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        System.out.println("Organization name: " + getName() + "\nAddress: " + getAddress() + "\nNumber: " + getPhoneNumber()
                + "\nTime created:" + getDateCreated() + "\nTime last edit:" + getDateEdited());
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void getEditable() {
        System.out.println("Select a field (name, number, address): ");
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


//

//
//    private String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String input) {
//        this.address = input;
//    }
//
//    static class Builder {
//        private String name;
//        private String phoneNumber;
//        private String address;
//
//        Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        Builder setPhoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//            return this;
//        }
//
//        Builder setAddress(String address) {
//            this.address = address;
//            return this;
//        }
//
//        Organisation build() {
//            return new Organisation(name, phoneNumber, address);
//        }
//
//    }
//
//}
