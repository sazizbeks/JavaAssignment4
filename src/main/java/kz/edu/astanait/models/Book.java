package kz.edu.astanait.models;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private Integer count_of_copy;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Book() {
    }

    public Book(String ISBN, String name, String author, int count_of_copy,String url) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.count_of_copy = count_of_copy;
        this.url = url;
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

    public Integer getCount_of_copy() {
        return count_of_copy;
    }

    public void setCount_of_copy(Integer count_of_copy) {
        this.count_of_copy = count_of_copy;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count_of_copy=" + count_of_copy +
                '}';
    }
}
