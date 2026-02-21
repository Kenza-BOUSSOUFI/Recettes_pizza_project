package com.example.recettes_pizza_project.dao;
import java.util.List;

//=====================l'interface dao qui contient les méthodes CRUD==================================

public interface IDao<T> {
    T create(T t);
    T update(T t);
    boolean delete(long id);
    T findById(long id);
    List<T> findAll();
}