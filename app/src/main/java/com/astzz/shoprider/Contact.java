package com.astzz.shoprider;

public class Contact {

    private int contactID;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;
    private String contactAge;
    private String contactCNIC;

    public Contact() {

    }

    public Contact(int id, String name, String email, String phone, String address, String age, String cnic) {
        this.contactID = id;
        this.contactName = name;
        this.contactEmail = email;
        this.contactPhone = phone;
        this.contactAddress = address;
        this.contactAge = age;
        this.contactCNIC = cnic;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactAge() {
        return contactAge;
    }

    public void setContactAge(String contactAge) {
        this.contactAge = contactAge;
    }

    public String getContactCNIC() {
        return contactCNIC;
    }

    public void setContactCNIC(String contactCNIC) {
        this.contactCNIC = contactCNIC;
    }
}
