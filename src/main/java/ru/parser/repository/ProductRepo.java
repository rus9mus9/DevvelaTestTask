package ru.parser.repository;

import ru.parser.model.Product;

import java.util.List;

public interface ProductRepo
{
    Product insert(Product product);
    Product update(Product product);
    Product get(int id);
    boolean delete(int id);
    int getViews(int id);
    List<Product> getAll();
}
