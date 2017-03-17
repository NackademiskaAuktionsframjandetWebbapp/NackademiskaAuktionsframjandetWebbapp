package com.example.gustav.androidmenyer;

import java.io.Serializable;

public class Bid implements Serializable {

    private String auctionId;
    private String customerId;
    private double bidPrice;
    private String id;
    private String dateTime;

    public Bid(String auctionId, String customerId, double bidPrice, String id, String dateTime) {
        this.auctionId = auctionId;
        this.customerId = customerId;
        this.bidPrice = bidPrice;
        this.id = id;
        this.dateTime = dateTime;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public String getBidId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }
}
