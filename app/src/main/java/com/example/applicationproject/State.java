package com.example.applicationproject;

public class State {
    private String name;
    private int price;
    private int flagResource;

    public State(String name, int price, int flag){

        this.name=name;
        this.price=price;
        this.flagResource=flag;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return this.price; }
    public void setCapital(int price) { this.price = price; }

    public int getFlagResource() { return this.flagResource; }
    public void setFlagResource(int flagResource) { this.flagResource = flagResource; }
}
