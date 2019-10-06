package main.java.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlElement
    private String manufacturer;
    @XmlElement
    private String model;
    @XmlElement
    private String dateOfManufacture;
    @XmlElement
    private String color;
    @XmlElement
    private Float Price;
    @XmlElement
    private int Amount;

    //    Block of methods
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }


    @Override
    public String toString() {
        return "main.java.entity.Product{\n" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", color='" + color + '\'' +
                ", Price=" + Price +
                ", Amount=" + Amount +
                '}' +
                "\n";
    }
}
