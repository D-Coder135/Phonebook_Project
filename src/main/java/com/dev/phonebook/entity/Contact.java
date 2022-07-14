/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 12-07-2022/07/2022
 *   Time: 01:49 PM
 *   File: Contact
 */

package com.dev.phonebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Contact {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private Integer userId;
    private Date createdAt = new Date();
}
