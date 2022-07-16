/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 02:25 PM
 *   File: ContactService
 */

package com.dev.phonebook.service;

import com.dev.phonebook.dao.ContactDao;
import com.dev.phonebook.dao.DaoFactory;
import com.dev.phonebook.entity.Contact;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactService {
    public Contact addNewContact(Contact c, Map<String, String> errors) throws IOException {
        String fname = c.getFirstname().trim();

        if (fname.length() == 0) {
            errors.put("firstname", "Firstname is required");
        } else if (fname.length() < 3) {
            errors.put("firstname", "At least 3 letters required for firstname");
        }

        if (c.getEmail().trim().length() == 0) {
            errors.put("email", "Email address is required!");
        }

        if (c.getPhone().trim().length() == 0) {
            errors.put("phone", "Phone number is required!");
        }

        if (errors.size() > 0) {
            return c;
        }

        ContactDao dao = DaoFactory.getContactDao();
        Contact c1 = dao.getContactByEmail(c.getEmail());
        if (c1 != null) {
            errors.put("email", "There is already a contact for this email");
        }

        c1 = dao.getContactByPhone(c.getPhone());
        if (c1 != null) {
            errors.put("phone", "There is already a contact for this phone number");
        }

        if (errors.size() > 0) {
            return c;
        }

        dao.createContact(c);
        return c;
    }

    public void updateContact(Integer id, Contact c,  Map<String, String> errors) throws IOException {
        c.setId(id);

        String fname = c.getFirstname().trim();

        if (fname.length() == 0) {
            errors.put("firstname", "Firstname is required");
        } else if (fname.length() < 3) {
            errors.put("firstname", "At least 3 letters required for firstname");
        }

        if (c.getEmail().trim().length() == 0) {
            errors.put("email", "Email address is required!");
        }

        if (c.getPhone().trim().length() == 0) {
            errors.put("phone", "Phone number is required!");
        }

        if (errors.size() > 0) {
            return;
        }
        ContactDao dao = DaoFactory.getContactDao();
        dao.updateContact(c);
    }

    public Contact getContactById(Integer id, Integer userId) throws IOException {
        return DaoFactory.getContactDao().getContact(id, userId);
    }

    public List<Contact> getAllContacts(Integer userId) throws IOException {
        return DaoFactory.getContactDao().getAllContacts(userId);
    }

    public void deleteContactById(Integer id, Integer userId, Map<String, String> errors) throws IOException {
        ContactDao dao = DaoFactory.getContactDao();
        Contact c1 = dao.getContact(id, userId);

        if (c1 == null) {
            errors.put("userId", "Permission denied for deleting this contact");
            return;
        }
        dao.deleteContact(id);
    }
}
