package utheryde.pet.project.models;

import utheryde.pet.project.dao.OrderDAO;

import java.time.LocalDate;

public class Order {
    private int id;
    private int personId;
    private int mangaId;
    private LocalDate orderDate;
    private LocalDate returnDate;

    public Order(int id, int mangaId, LocalDate orderDate, LocalDate returnDate) {
        this.id = id;
        this.mangaId = mangaId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getMangaId() {
        return mangaId;
    }

    public void setMangaId(int mangaId) {
        this.mangaId = mangaId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }



}
