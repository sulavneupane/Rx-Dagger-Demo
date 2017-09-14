package com.nepalicoders.rxdaggerdemo.model;

import com.google.gson.annotations.Expose;

public class FlowerResponse {

    @Expose
    private String name;
    @Expose
    private String photo;
    @Expose
    private String category;
    @Expose
    private String instructions;
    @Expose
    private int productId;
    @Expose
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
