package service;

import model.Products;

import java.util.List;

public interface ProductService {
    List<Products> findAll();
    Products findById(int id);
    void save(Products p);
    void add(Products p);
    void edit(int id, Products p);
    Products delete(int id);
}
