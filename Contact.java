/************************************
 *
 * Hassan Lindsay
 * CS320 3-2 Milestone: Contact Service
 *
 *************************************/

package com.contact;

// The Contact class represents a person's contact information
public class Contact {
    // Unique ID for the contact (cannot be changed)
    private final String contactId;
    // First name of the contact
    private String firstName;
    // Last name of the contact
    private String lastName;
    // Phone number (must be exactly 10 digits)
    private String phone;
    // Address (max 30 characters)
    private String address;

    // Constructor to create a new Contact with all required fields
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contactId
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        // Validate first name
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        // Validate last name
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        // Validate phone number
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+"))
            throw new IllegalArgumentException("Invalid phone number");
        // Validate address
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contactId (no setter because it can't be changed)
    public String getContactId() {
        return contactId;
    }

    // Getter and setter for firstName
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    // Getter and setter for lastName
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    // Getter and setter for phone
    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    // Getter and setter for address
    public String getAddress() { return address; }
    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}
