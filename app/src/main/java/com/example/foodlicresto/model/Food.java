package com.example.foodlicresto.model;

public class Food {
    private String name;
    private String image;
    private String Description;
    private String price;

    public Food(String name, String Description, String price, String menuId) {
        this.name = name;
        this.Description = Description;
        this.price = price;
        this.menuId = menuId;
    }

    private String discount;
    private String menuId;

    public Food(){}

    public Food(String name, String description, String price, String discount, String menuId, String image) {
        this.name = name;
        this.image = image;
        this.Description = description;
        this.price = price;
        this.discount = discount;
        this.menuId = menuId;
    }

    // Getter Methods

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getMenuId() {
        return menuId;
    }

    // Setter Methods

    public void setName(String Name) {
        this.name = Name;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrice(String Price) {
        this.price = Price;
    }

    public void setDiscount(String Discount) {
        this.discount = Discount;
    }

    public void setMenuId(String MenuId) {
        this.menuId = MenuId;
    }
}
