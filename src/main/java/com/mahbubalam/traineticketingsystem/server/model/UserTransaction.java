package com.mahbubalam.traineticketingsystem.server.model;

public class UserTransaction {
    private String from;
    private String to;
    private Float distance ;
    private int count;
    private float price;

    public UserTransaction(String from, String to, Float distance, int count, float price) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.count = count;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
