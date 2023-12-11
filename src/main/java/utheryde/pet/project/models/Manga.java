package utheryde.pet.project.models;

import java.time.LocalDate;

public class Manga {
    private int id;
    private String title;
    private String author;
    private LocalDate year;
    private int count;
    private int order_count;

    public Manga(int id, String title, String author, LocalDate year, int count, int order_count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.count = count;
        this.order_count = order_count;
    }

    public Manga() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }
}
