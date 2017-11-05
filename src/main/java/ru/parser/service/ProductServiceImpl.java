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

    public void delete(int id)
    {
       productRepo.delete(id);
    }

    @Override
    public int getAllViews()
    {
        int allViews = 0;
        for(Product product : productRepo.getAll())
        {
            allViews += product.getViews();
        }
        return allViews;
    }

    @Override
    public List<Product> getAll()
    {
        return productRepo.getAll();
    }
}
