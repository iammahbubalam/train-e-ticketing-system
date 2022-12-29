package com.mahbubalam.traineticketingsystem.server.entity;

public class Transaction {
    private int transactionId;
    private int fromStationId;
    private int toStationId;
    private int userId;
    private int routeId;
    private float price;
    private int ticketCount;

    public Transaction(int fromStationId, int toStationId, int userId, int routeId, float price, int ticketCount) {
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.userId = userId;
        this.routeId = routeId;
        this.price = price;
        this.ticketCount = ticketCount;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(int fromStationId) {
        this.fromStationId = fromStationId;
    }

    public int getToStationId() {
        return toStationId;
    }

    public void setToStationId(int toStationId) {
        this.toStationId = toStationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromStationId=" + fromStationId +
                ", toStationId=" + toStationId +
                ", userId=" + userId +
                ", routeId=" + routeId +
                ", price=" + price +
                ", ticketCount=" + ticketCount +
                '}';
    }
}
