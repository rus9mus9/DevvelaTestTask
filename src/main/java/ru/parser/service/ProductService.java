package ru.parser.service;

import ru.parser.model.Product;

import java.util.List;

public interface ProductService
{
    Product insert(Product product);
    void update(Product product);
    Product get(int id);
    void delete(int id);
    int getViews(Product product);

    List<Product> getBad();
    List<Product> getNormal();
    List<Product> getGood();
    List<Product> getAll();
}
