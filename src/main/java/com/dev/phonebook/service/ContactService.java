/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 02:25 PM
 *   File: ContactService
 */

package com.dev.phonebook.service;

import com.dev.phonebook.entity.Contact;

import java.util.Map;

public class ContactService {
    public Contact addNewUser(Contact c, Map<String, String> errors) {
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
        return null;
    }
}
