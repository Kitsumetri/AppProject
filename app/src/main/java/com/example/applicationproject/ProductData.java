package com.example.applicationproject;

public class ProductData {
    private int id;
    private String hashId;
    private String name;
    private String description;
    private float price;
    private String metaData2;
    private String metaData3;
    private String itemSourceLink;
    private String imagePath;
    private int numberOfCalls;
    private float rating;
    private int priority;
    private boolean isInStore;
    private String category;

    public ProductData(int id, String hashId, String name, String description, float price, String metaData2, String metaData3, String itemSourceLink, String imagePath, int numberOfCalls, float rating, int priority, boolean isInStore, String category) {
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

    @Override
    public String toString() {
        return "ProductData{" +
                "id=" + id +
                ", hashId='" + hashId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", metaData2='" + metaData2 + '\'' +
                ", metaData3='" + metaData3 + '\'' +
                ", itemSourceLink='" + itemSourceLink + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", numberOfCalls=" + numberOfCalls +
                ", rating=" + rating +
                ", priority=" + priority +
                ", isInStore=" + isInStore +
                ", category='" + category + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMetaData2() {
        return metaData2;
    }

    public void setMetaData2(String metaData2) {
        this.metaData2 = metaData2;
    }

    public String getMetaData3() {
        return metaData3;
    }

    public void setMetaData3(String metaData3) {
        this.metaData3 = metaData3;
    }

    public String getItemSourceLink() {
        return itemSourceLink;
    }

    public void setItemSourceLink(String itemSourceLink) {
        this.itemSourceLink = itemSourceLink;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getIsInStore() {
        return isInStore;
    }

    public void setIsInStore(boolean inStore) {
        isInStore = inStore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
