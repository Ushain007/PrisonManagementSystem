package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import java.io.Serializable;
import java.time.LocalDate;

public class Librarian_Model implements Serializable {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private LocalDate dob;

    public Librarian_Model(int id, String name, String email, String phone, String password, String address, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.dob = dob;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public LocalDate getDob() { return dob; }

    @Override
    public String toString() {
        return "Librarian [ID=" + id + ", Name=" + name + "]";
    }
}