/************************************
 *
 * Hassan Lindsay
 * CS320 3-2 Milestone: Contact Service
 *
 *************************************/

package com.contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// This class tests the ContactService class to make sure it works correctly
public class ContactServiceTest {

    // Test adding a new contact
    @Test
    public void testAddContact() {
        // Create the service and a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Add the contact
        service.addContact(contact);

        // Try to add the same contact again - should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        // Create the service and a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Add thee contact
        service.addContact(contact);

        // Delete the contact
        service.deleteContact("1234567890");

        // Try to delete non-existent contact - should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("1234567890");
        });
    }

    // Test updating contact fields
    @Test
    public void testUpdateContact() {
        // Create the service and a contact
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Add the contact
        service.addContact(contact);

        // Update first name
        service.updateFirstName("1234567890", "Jane");
        assertEquals("Jane", contact.getFirstName());

        // Update last name
        service.updateLastName("1234567890", "Smith");
        assertEquals("Smith", contact.getLastName());

        // Update phone
        service.updatePhone("1234567890", "9876543210");
        assertEquals("9876543210", contact.getPhone());

        // Update address
        service.updateAddress("1234567890", "456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Test updating non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        // Create the service (no contacts added)
        ContactService service = new ContactService();

        // Try to update fields of non-existent contact - should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("1234567890", "Jane");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("1234567890", "Smith");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("1234567890", "9876543210");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("1234567890", "456 Oak Ave");
        });
    }
} 