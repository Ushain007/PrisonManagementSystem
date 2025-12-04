package com.example.prisonmanagementsystem.Ushain_2320676.Librarian;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryMember_Model implements Serializable {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String type; // "Prisoner" or "Staff"
    private String membershipType; // "Standard" or "Premium"

    public LibraryMember_Model(int id, String name, String email, String phone, String type, String membershipType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.membershipType = membershipType;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getType() { return type; }
    public String getMembershipType() { return membershipType; }

    @Override
    public String toString() {
        return "Member [ID=" + id + ", Name=" + name + ", Type=" + type + "]";
    }
}