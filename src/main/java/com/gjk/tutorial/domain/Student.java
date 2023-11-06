package com.gjk.tutorial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Please add Student name.")
    @Column(name = "name")
    private String name;

    @Column(name = "roleNumber")
    private Integer rollNo;

    @Column(name = "address")
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, Integer rollNo, String address) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student {id=" + id + ", name=" + name + ",rollNo=" + rollNo + ", address=" + address + "]";
    }
}
