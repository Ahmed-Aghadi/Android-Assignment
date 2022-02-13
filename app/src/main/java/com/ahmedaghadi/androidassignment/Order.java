package com.ahmedaghadi.androidassignment;

public class Order {
    private int id;
    private String timestamp;
    private int itemCount;
    private String price;
    private String status;
    private int type;
    private boolean isNew;

    public Order(int id, String timestamp, int itemCount, String price, String status, int type, boolean isNew) {
        this.id = id;
        this.timestamp = timestamp;
        this.itemCount = itemCount;
        this.price = price;
        this.status = status;
        this.type = type;
        this.isNew = isNew;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public boolean isNew() {
        return isNew;
    }
}
