package com.example.prisonmanagementsystem.Ushain_2320676;

import java.io.Serializable;

public class Book_Model implements Serializable {
    private String title;
    private String author;
    private String category;
    private int publicationYear;
    private int quantity;
    private String shelfSection;

    public Book_Model(String title, String author, String category, int publicationYear, int quantity, String shelfSection) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
        this.shelfSection = shelfSection;
    }
