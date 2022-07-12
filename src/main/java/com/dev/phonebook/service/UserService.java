/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 02:24 PM
 *   File: UserService
 */

package com.dev.phonebook.service;

import com.dev.phonebook.entity.User;

import java.util.Map;

public class UserService {

    public User registerUser(String name, String email, String password, String cPassword, Map<String, String> errors) {
        if (name.trim().length() == 0) {
            errors.put("name", "Name is mandatory");
        } else if (name.trim().length() < 3) {
            errors.put("name", "At least 3 letters are required");
        }

        if (email.trim().length() == 0) {
            errors.put("email", "Email address is mandatory");
        }

        if (password.trim().length() == 0) {
            errors.put("password", "Password is mandatory");
        }

        if (!password.equals(cPassword)) {
            errors.put("cPassword", "Passwords do not match");
        }
        return null;
    }

}
