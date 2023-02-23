package com.example.applicationproject;

public class ProductData {
    public int numberOfCalls, priority;
    public  String id, hashId, name, description, itemSourceLink, imagePath, category;
    public  float price, rating;
    public  boolean isInStore;

    public ProductData(String id, String hashId, String name, String description, float price, String itemSourceLink, String imagePath, int numberOfCalls, float rating, int priority, boolean isInStore, String category) {
        this.id = id;
        this.hashId = hashId;
        this.name = name;
        this.description = description;
        this.price = price;
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