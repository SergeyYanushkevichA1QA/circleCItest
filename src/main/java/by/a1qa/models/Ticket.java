package by.a1qa.models;

public class Ticket {
    private String date;
    private String time;
    private String price;

    public Ticket(String price) {
        this.price = price;
    }

    public Ticket(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public Ticket(String date, String time, String price) {
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPrice() {
        return price;
    }
}
