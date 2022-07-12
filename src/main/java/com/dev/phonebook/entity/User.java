/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 01:45 PM
 *   File: User
 */

package com.dev.phonebook.entity;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date createAt;
}
