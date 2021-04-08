package by.a1qa.models;

import java.util.Objects;

public class Show {
    private String showName;
    private double price;

    public Show(String showName, double price) {
        this.showName = showName;
        this.price = price;
    }

    public String getShowName() {
        return showName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return price == show.price && Objects.equals(showName, show.showName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showName, price);
    }
}
