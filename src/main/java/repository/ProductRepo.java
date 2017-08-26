package repository;

import model.Product;

import java.util.List;

public interface ProductRepo
{
    Product insert(Product product);
    Product update(Product product);
    Product get(int id);
    boolean delete(int id);
    int getViews(int id);


    List<Product> getAll();
    List<Product> getBad();
    List<Product> getNormal();
    List<Product> getGood();
}
