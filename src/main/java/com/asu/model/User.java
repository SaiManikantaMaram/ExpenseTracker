
package com.asu.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="tbl_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Name should not be blank")
    private String name;
    @Email(message="Please provide correct Email")
    private String email;
    @NotBlank(message="Password should not be blank")
    private String password;
    @NotNull(message="Please enter age")
    private int age;

    @CreationTimestamp
    @Column(nullable=false,updatable = false)
    private Date created_at;
    @UpdateTimestamp
    private Date updated_at;
    
}
