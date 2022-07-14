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
        }

        return null;
    }
}
