package kz.edu.astanait.models;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private int count_of_copy;

    public Book(String ISBN, String name, String author, int count_of_copy) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.count_of_copy = count_of_copy;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount_of_copy() {
        return count_of_copy;
    }

    public void setCount_of_copy(int count_of_copy) {
        this.count_of_copy = count_of_copy;
    }
}
