package com.task.three.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NamedQuery(name = "Car.getAll", query = "SELECT c from Car c")
public class Car {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "insuranceValue", nullable = false)
    private int insuranceValue;

    public Car(long id, String name, int price, int insuranceValue) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.insuranceValue = insuranceValue;
    }

    public Car(String name, int price, int insuranceValue) {
        this.name = name;
        this.price = price;
        this.insuranceValue = insuranceValue;
    }

    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(int insuranceValue) {
        this.insuranceValue = insuranceValue;
    }
}
