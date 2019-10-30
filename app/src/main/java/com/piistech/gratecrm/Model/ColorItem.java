package com.piistech.gratecrm.Model;

public class ColorItem {
    private boolean flag;
    private String color;

    public ColorItem() {
    }

    public ColorItem(boolean flag, String color) {
        this.flag = flag;
        this.color = color;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
