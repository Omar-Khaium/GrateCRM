package com.piistech.gratecrm.Model;

public class Estimate {

    private String id;
    private String product;
    private String description;
    private String quantity;
    private String rate;
    private String amount;

    public Estimate() {
    }

    public Estimate(String id, String product, String description, String quantity, String rate, String amount) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
