package ru.parser.service;

import ru.parser.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.parser.repository.ProductRepo;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }

    @Override
    public Product insert(Product product)
    {
       return productRepo.insert(product);
    }

    public void update(Product product)
    {
        productRepo.update(product);
    }

    public Product get(int id)
    {
        return productRepo.get(id);
    }

    public boolean delete(int id)
    {
       return productRepo.delete(id);
    }

    public int getViews(Product product)
    {
        return productRepo.getViews(product.getProductId());
    }

    public List<Product> getBad()
    {
        return productRepo.getBad();
    }

    public List<Product> getNormal()
    {
        return productRepo.getNormal();
    }

    public List<Product> getGood()
    {
        return productRepo.getGood();
    }

    @Override
    public List<Product> getAll()
    {
        return productRepo.getAll();
    }
}
