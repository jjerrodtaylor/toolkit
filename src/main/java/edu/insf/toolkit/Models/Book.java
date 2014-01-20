package edu.insf.toolkit.Models;


import java.util.ArrayList;

public class Book
{
    private ArrayList<Chapter> book;

    public Book()
    {
        super();
    }

    public Book(ArrayList<Chapter> book)
    {
        this.book = book;
    }

    public void setBook(ArrayList<Chapter> book)
    {
        this.book = book;
    }

    public ArrayList<Chapter> getBook()
    {
        return this.book;
    }

}
