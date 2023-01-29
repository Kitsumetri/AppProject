package com.example.applicationproject;

public class ProductData {
    public int numberOfCalls, priority;
    public  String id, hashId, name, description, metaData2, metaData3, itemSourceLink, imagePath, category;
    public  float price, rating;
    public  boolean isInStore;

    public ProductData(String id, String hashId, String name, String description, float price, String metaData2, String metaData3, String itemSourceLink, String imagePath, int numberOfCalls, float rating, int priority, boolean isInStore, String category) {
        this.id = id;
        this.hashId = hashId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.metaData2 = metaData2;
        this.metaData3 = metaData3;
        this.itemSourceLink = itemSourceLink;
        this.imagePath = imagePath;
        this.numberOfCalls = numberOfCalls;
        this.rating = rating;
        this.priority = priority;
        this.isInStore = isInStore;
        this.category = category;
    }

    public ProductData() {
    }
}
