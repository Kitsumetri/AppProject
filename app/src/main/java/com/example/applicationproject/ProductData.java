package com.example.applicationproject;

public class ProductData {
    private  String id, hashId, name, description, itemSourceLink, category;
    private  float price, rating;
    private  boolean isInStore;

    public ProductData(String id, String hashId, String name, String description, float price, String itemSourceLink,  float rating,  boolean isInStore, String category) {
        this.id = id;
        this.hashId = hashId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemSourceLink = itemSourceLink;
        this.rating = rating;
        this.isInStore = isInStore;
        this.category = category;
    }

    public ProductData() {}

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
    public void setItemSourceLink(String itemSourceLink) {
        this.itemSourceLink = itemSourceLink;
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
    public String getId() { return id; }
    public String getHashId() { return hashId; }
    public String getDescription() { return description; }
    public String getItemSourceLink() { return itemSourceLink; }
    public String getCategory() { return category; }
    public float getPrice() { return price; }
    public float getRating() { return rating; }
    public boolean isInStore() { return isInStore; }
}