package com.example.foodordering;

public class Food {
    private String Title;
    private int pic;
    private String description;
    private double price;
    private int numInCart;

    public Food(String title, int pic, String description, double price, int numInCart) {
        Title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.numInCart = numInCart;
    }

    public Food(String title,int pic, String description,double price) {
        Title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumInCart() {
        return numInCart;
    }

    public void setNumInCart(int numInCart) {
        this.numInCart = numInCart;
    }
}
