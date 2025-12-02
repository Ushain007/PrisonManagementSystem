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


    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
    public int getPublicationYear() {
        return publicationYear;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getShelfSection() {
        return shelfSection;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setShelfSection(String shelfSection) {
        this.shelfSection = shelfSection;
    }

    @Override
    public String toString() {
        return title + " (" + publicationYear + ")";
    }
}