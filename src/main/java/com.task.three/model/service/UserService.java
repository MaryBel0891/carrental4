package com.task.three.model.service;

import com.task.three.model.entity.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
@Singleton
@LocalBean
public class UserService{

    public EntityManager em = Persistence.createEntityManagerFactory("CARPARK").createEntityManager();


    public User findByEmail(String email) {
        String queryString = "SELECT u FROM User u " +
                "WHERE LOWER(u.email) = :email";
        Query query = em.createQuery(queryString);

        query.setParameter("email", email);
        User user = (User) query.getSingleResult();
        System.out.println(user);
        return user;
    }

    public List<User> findAllUsers() {
        String queryString = "SELECT u FROM User u";
        Query query = em.createQuery(queryString);
        return query.getResultList();
    }

    public List<User> findAllUsersByName(String name) {
        String queryString = "SELECT u FROM User u WHERE LOWER(u.name) = :name";
        Query query = em.createQuery(queryString);
        query.setParameter("name", name);
        return query.getResultList();
    }


    public User addUser(User user){
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }

    @Remove
    public void deleteUser(long id){
        em.getTransaction().begin();
        em.remove(getUser(id));
        em.getTransaction().commit();
    }

    public User getUser(long id){
        return em.find(User.class, id);
    }

    public void updateUser(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }


}
