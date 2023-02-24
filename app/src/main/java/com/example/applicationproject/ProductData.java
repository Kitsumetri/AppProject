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

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMetaData2(String metaData2) {
        this.metaData2 = metaData2;
    }

    public void setMetaData3(String metaData3) {
        this.metaData3 = metaData3;
    }

    public void setItemSourceLink(String itemSourceLink) {
        this.itemSourceLink = itemSourceLink;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }

    public String getName() {
        return name;
    }
}
