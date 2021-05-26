package service;

import model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Products> list;
    static {
        list = new ArrayList<>();
        list.add(new Products(1,"but",2500));
        list.add(new Products(2,"thuong ke",3000));
        list.add(new Products(3,"sach",5600));
        list.add(new Products(4,"sach in",35000));
    }
    @Override
    public List<Products> findAll() {
        return list;
    }

    @Override
    public Products findById(int id) {
        for (Products p: findAll()
             ) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void save(Products p) {

    }

    @Override
    public void add(Products p) {
        list.add(p);
    }

    @Override
    public void edit(int id, Products p) {
        list.set(id,p);
    }

    @Override
    public Products delete(int id) {
        for (Products p: findAll()
             ) {
            if (p.getId() == id){
                list.remove(p);
                return null;
            }
        }
        return null;
    }
}
