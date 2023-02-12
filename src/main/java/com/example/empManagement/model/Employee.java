package com.example.empManagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber ;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "location")
    private String location;
    //    @Column(name = "profile_image_name")
//    private String profileImageName;
//    @Column(name = "profile_image_file_path")
//    private String profileImageFilePath;
    @Column(name = "designation")
    private String designation;
    @Column(name = "joining_date")
    @JsonFormat(pattern="dd/MM/yy")
    private Date joiningDate;
    @Transient
    private Boolean viewOnly;

    public Employee() {

    }
}
