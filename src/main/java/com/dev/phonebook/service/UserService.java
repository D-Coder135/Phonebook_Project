/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 02:24 PM
 *   File: UserService
 */

package com.dev.phonebook.service;

import com.dev.phonebook.dao.DaoFactory;
import com.dev.phonebook.dao.UserDao;
import com.dev.phonebook.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Map;

public class UserService {

    public User registerUser(String name, String email, String password, String cPassword, Map<String, String> errors) throws IOException {
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

        UserDao dao = DaoFactory.getUserDao();
        User user = dao.getUserByEmail(email);
        if (user != null) {
            errors.put("email", "This email is already registered with us");
        }

        if (errors.size() > 0) {
            return null;
        }

        password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        user = new User(name, email, password);
        dao.createUser(user);
        return user;
    }

    public User login(String email, String password, Map<String, String> errors) throws IOException {
        if (email.trim().length() == 0) {
            errors.put("email", "Email address is mandatory");
        }

        if (password.trim().length() == 0) {
            errors.put("password", "Password is mandatory");
        }

        if (errors.size() > 0) {
            return null;
        }

        UserDao dao = DaoFactory.getUserDao();
        User user = dao.getUserByEmail(email);

        if (user == null) {
            errors.put("email", "Invalid email/password!");
        } else {
            boolean result = BCrypt.checkpw(password, user.getPassword());
            if (!result) {
                errors.put("email", "Invalid email/password!");
            }
        }

        if (errors.size() > 0) {
            return null;
        }
        return user;
    }
}
