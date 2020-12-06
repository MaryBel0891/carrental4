package com.task.three.model.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name="car_rental",
        uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
    //@SecondaryTables({
    //        @SecondaryTable(name="user"), @SecondaryTable(name="car")
    //})
@NamedQuery(name = "CarRental.getAll", query = "SELECT cr from CarRental cr")
public class CarRental {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    @Basic
    @Column(name = "daysAmount", nullable = false)
    private int daysAmount;
    @Column(name = "price", nullable = false)
    @Basic
    private int price;
    @Basic
    @Column(name = "client_id", nullable = false)
    private long clientId;
    @Basic
    @Column(name = "car_id", nullable = false)
    private long carId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", insertable = false, updatable = false)
    private Car car;

    public CarRental() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public static class Builder{
        CarRental carRental = new CarRental();

        public Builder id(int id){
            carRental.id = id;
            return this;
        }
        public Builder startDate(LocalDate startDate){
            carRental.startDate = startDate;
            return this;
        }
        public Builder daysAmount(int daysAmount){
            carRental.daysAmount = daysAmount;
            return this;
        }
        public Builder price(int price){
            carRental.price = price;
            return this;
        }
        public Builder clientId(long clientId){
            carRental.clientId = clientId;
            return this;
        }
        public Builder carId(long carId){
            carRental.carId = carId;
            return this;
        }
        public CarRental build(){
            return carRental;
        }
    }
}
