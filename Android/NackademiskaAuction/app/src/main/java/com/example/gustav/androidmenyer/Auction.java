package com.example.gustav.androidmenyer;

import java.io.Serializable;

public class Auction implements Serializable {

    private String name;
    private double price;
    private String imageUrl;
    private String description;
    private String startTime;
    private String endTime;
    private String categoryId;
    private String supplierId;
    private String id;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getId() {
        return id;
    }
}