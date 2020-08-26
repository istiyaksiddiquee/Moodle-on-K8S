package com.magnumopus.usermanagement.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
//@NamedNativeQuery(name = "Human.findByNameNamedNative",
//        query = "SELECT * FROM t_human h WHERE " +
//                "LOWER(h.last_name) LIKE LOWER(CONCAT('%',:name, '%'))" +
//                "ORDER BY h.first_name ASC",
//        resultClass = User.class
//)
//@NamedQuery(name = "Human.findByNameNamed",
//        query = "SELECT h FROM User h WHERE " +
//                "LOWER(h.lastName) LIKE LOWER(CONCAT('%', :name, '%')) " +
//                "ORDER BY h.firstName ASC"
//)

@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_user")
public class User {

    // ============================ VARIABLES ===================================
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    // ============================ CONSTRUCTOR ===================================

    public User(String firstName, String lastName, String emailId, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailId = emailId;
        this.password = password;
    }

    // ============================ METHODS ===================================

}