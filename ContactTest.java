/************************************
 *
 * Hassan Lindsay
 * CS320 3-2 Milestone: Contact Service
 *
 *************************************/


package com.contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// This class tests the Contact class to make sure it works correctly
public class ContactTest {
    // Test valid contact creation
    @Test
    public void testValidContactCreation() {
        // Create a contact with valid data
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        // Check that all fields are set correctly
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test contact ID validation
    @Test
    public void testInvalidContactId() {
        // Try to create contact with null ID (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });

        // Try to create contact with ID longer than 10 characters (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test first name validation
    @Test
    public void testInvalidFirstName() {
        // Try to create contact with null first name (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });

        // Try to create contact with first name longer than 10 characters (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });

        // Try to update first name to invalid value (should fail)
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JohnJohnJohn");
        });
    }

    // Test last name validation
    @Test
    public void testInvalidLastName() {
        // Try to create contact with null last name (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });

        // Try to create contact with last name longer than 10 characters (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });

        // Try to update last name to invalid value (should fail)
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("DoeDoeDoeDoe");
        });
    }

    // Test phone number validation
    @Test
    public void testInvalidPhone() {
        // Try to create contact with null phone (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });

        // Try to create contact with phone not exactly 10 digits (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St");
        });

        // Try to create contact with phone containing non-digits (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123456789a", "123 Main St");
        });

        // Try to update phone to invalid value (should fail)
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789");
        });
    }

    // Test address validation
    @Test
    public void testInvalidAddress() {
        // Try to create contact with null address (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });

        // Try to create contact with address longer than 30 characters (should fail)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890",
                    "This address is way too long to be valid");
        });

        // Try to update address to invalid value (should fail)
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is way too long to be valid");
        });
    }

    // Test valid field updates
    @Test
    public void testValidFieldUpdates() {
        // Create a contact
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        // Update first name
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        // Update last name
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        // Update phone
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());

        // Update address
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
} 