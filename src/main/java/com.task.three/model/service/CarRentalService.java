package com.task.three.model.service;

import com.task.three.model.entity.CarRental;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class CarRentalService {

    @PersistenceContext(unitName = "CARPARK")
    public EntityManager em;

    public CarRental carRental(CarRental carRental){
        em.getTransaction().begin();
        CarRental carRentalFromDB = em.merge(carRental);
        em.getTransaction().commit();
        return carRentalFromDB;
    }

    public void deleteCarRental(long id){
        em.getTransaction().begin();
        em.remove(getCarRental(id));
        em.getTransaction().commit();
    }

    public CarRental getCarRental(long id){
        return em.find(CarRental.class, id);
    }

    public void updateCarRental(CarRental carRental){
        em.getTransaction().begin();
        em.merge(carRental);
        em.getTransaction().commit();
    }
    public List<CarRental> getAll(){
        TypedQuery<CarRental> namedQuery = em.createNamedQuery("CarRental.getAll", CarRental.class);
        return namedQuery.getResultList();
    }

    public List<CarRental> findAllCarRentalByDate(LocalDate startDate) {
        String queryString = "SELECT cr FROM CarRental cr WHERE LOWER(cr.startDate) = :startDate";
        Query query = em.createQuery(queryString);
        query.setParameter("startDate", startDate);
        return query.getResultList();
    }

}
