package com.piistech.gratecrm.Model;

public class Repair {

    private String id;
    private String date;
    private String level;
    private String amount;
    private String cash;

    public Repair() {
    }

    public Repair(String id, String date, String level, String amount, String cash) {
        this.id = id;
        this.date = date;
        this.level = level;
        this.amount = amount;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }
}
