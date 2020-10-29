package kz.edu.astanait.models;

public class Reader {
    private String iin;
    private String firstName;
    private String lastName;

    public Reader(String iin, String firstName, String lastName) {
        this.iin = iin;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
