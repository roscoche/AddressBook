package roscoche.com.addressbook;

/**
 * Created by fer on 10/04/2016.
 */
public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;



    public Contact(String contactID, String firstName, String lastName,String phonenumber,String email,String address1,String address2,String city, String state,String zip,String country){
        this.setContactID(contactID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhonenumber(phonenumber);
        this.setEmail(email);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
        this.setCountry(country);

    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String userID) {
        this.contactID = userID;
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

    @Override
    public String toString(){
        return this.contactID + " , "
                + this.firstName + " , "
                + this.lastName + " , "
                + this.phonenumber + " , "
                + this.email + " , "
                + this.address1 + " , "
                + this.address2 + " , "
                + this.city + " , "
                + this.state + " , "
                + this.zip + " , "
                + this.country;
    }
    public String simpleList(){
        return this.lastName + " , "
             + this.firstName;
    }
}

