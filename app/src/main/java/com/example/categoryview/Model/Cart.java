package com.example.categoryview.Model;

public class Cart {

    private String pid,pname,price,discount;

    public Cart()
    {

    }

    public Cart(String pid, String pname, String price, String discount) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        //this.quantity = quantity;
        this.discount = discount;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    /*public void setQuantity(String quantity) {
        this.quantity = "1";
    }

    public String getQuantity() {
        return quantity;
    }*/

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
